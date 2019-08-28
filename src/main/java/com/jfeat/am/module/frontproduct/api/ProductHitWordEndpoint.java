package com.jfeat.am.module.frontproduct.api;
    
                                            
                    import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductHitWordRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.ProductHitWordService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductHitWord;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * <p>
 *  api
 * </p>
 *
 * @author Code Generator
 * @since 2019-07-25
 */
@RestController

@Api("ProductHitWord")
@RequestMapping("/api/crud/product/productHitWords")
public class ProductHitWordEndpoint {



@Resource
    ProductHitWordService productHitWordService;

@PostMapping
@ApiOperation(value = "新建 ProductHitWord",response = ProductHitWord.class)
public Tip createProductHitWord(@RequestBody ProductHitWord entity){

        Integer affected=0;
        try{
                affected= productHitWordService.createMaster(entity);
    
        }catch(DuplicateKeyException e){
        throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
        }

@GetMapping("/{id}")
@ApiOperation(value = "查看 ProductHitWord",response = ProductHitWord.class)
public Tip getProductHitWord(@PathVariable Long id){
                return SuccessTip.create(productHitWordService.retrieveMaster(id));
            }

@PutMapping("/{id}")
@ApiOperation(value = "修改 ProductHitWord",response = ProductHitWord.class)
public Tip updateProductHitWord(@PathVariable Long id,@RequestBody ProductHitWord entity){
        entity.setId(id);
                return SuccessTip.create(productHitWordService.updateMaster(entity));
            }

@DeleteMapping("/{id}")
@ApiOperation("删除 ProductHitWord")
public Tip deleteProductHitWord(@PathVariable Long id){
                return SuccessTip.create(productHitWordService.deleteMaster(id));
            }

@ApiOperation(value = "ProductHitWord 列表信息",response = ProductHitWordRecord.class)
@GetMapping
@ApiImplicitParams({
        @ApiImplicitParam(name= "pageNum", dataType = "Integer"),
        @ApiImplicitParam(name= "pageSize", dataType = "Integer"),
        @ApiImplicitParam(name= "search", dataType = "String"),
                                                                                        @ApiImplicitParam(name = "id", dataType = "Integer"),
                                                                                            @ApiImplicitParam(name = "name", dataType = "String"),
                                                                                                    @ApiImplicitParam(name = "hit", dataType = "Integer"),
                                @ApiImplicitParam(name = "orderBy", dataType = "String"),
                @ApiImplicitParam(name = "sort", dataType = "String")
            })
public Tip queryProductHitWords(Page<ProductHitWordRecord> page,
@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
@RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
@RequestParam(name = "search", required = false) String search,
                                                                                                                @RequestParam(name = "id", required = false) Long id,
                                                                                                                                @RequestParam(name = "name", required = false) String name,
                                                                                                                                        @RequestParam(name = "hit", required = false) Integer hit,
                                    @RequestParam(name = "orderBy", required = false) String orderBy,
        @RequestParam(name = "sort", required = false)  String sort) {
                    if(orderBy!=null&&orderBy.length()>0){
        if(sort!=null&&sort.length()>0){
        String pattern = "(ASC|DESC|asc|desc)";
        if(!sort.matches(pattern)){
        throw new BusinessException(BusinessCode.BadRequest.getCode(), "sort must be ASC or DESC");//此处异常类型根据实际情况而定
        }
        }else{
        sort = "ASC";
        }
        orderBy = "`"+orderBy+"`" +" "+sort;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);

    ProductHitWordRecord record = new ProductHitWordRecord();
                                                                                    record.setId(id);
                                                                                        record.setName(name);
                                                                                        record.setHit(hit);
                    page.setRecords(this.productHitWordService.findProductHitWordPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
        }
        }
