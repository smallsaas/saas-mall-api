package com.jfeat.am.module.product.api;
    
                                            
                    import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.model.ProductSettlementProportionRecord;
import com.jfeat.am.module.product.services.domain.service.ProductSettlementProportionService;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductSettlementProportion;
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

@Api("ProductSettlementProportion")
@RequestMapping("/api/crud/product/productSettlementProportions")
public class ProductSettlementProportionEndpoint {



@Resource
    ProductSettlementProportionService productSettlementProportionService;

@PostMapping
@ApiOperation(value = "新建 ProductSettlementProportion",response = ProductSettlementProportion.class)
public Tip createProductSettlementProportion(@RequestBody ProductSettlementProportion entity){

        Integer affected=0;
        try{
                affected= productSettlementProportionService.createMaster(entity);
    
        }catch(DuplicateKeyException e){
        throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
        }

@GetMapping("/{id}")
@ApiOperation(value = "查看 ProductSettlementProportion",response = ProductSettlementProportion.class)
public Tip getProductSettlementProportion(@PathVariable Long id){
                return SuccessTip.create(productSettlementProportionService.retrieveMaster(id));
            }

@PutMapping("/{id}")
@ApiOperation(value = "修改 ProductSettlementProportion",response = ProductSettlementProportion.class)
public Tip updateProductSettlementProportion(@PathVariable Integer id,@RequestBody ProductSettlementProportion entity){
        entity.setId(id);
                return SuccessTip.create(productSettlementProportionService.updateMaster(entity));
            }

@DeleteMapping("/{id}")
@ApiOperation("删除 ProductSettlementProportion")
public Tip deleteProductSettlementProportion(@PathVariable Long id){
                return SuccessTip.create(productSettlementProportionService.deleteMaster(id));
            }

@ApiOperation(value = "ProductSettlementProportion 列表信息",response = ProductSettlementProportionRecord.class)
@GetMapping
@ApiImplicitParams({
        @ApiImplicitParam(name= "pageNum", dataType = "Integer"),
        @ApiImplicitParam(name= "pageSize", dataType = "Integer"),
        @ApiImplicitParam(name= "search", dataType = "String"),
                                                                                        @ApiImplicitParam(name = "id", dataType = "Integer"),
                                                                                                            @ApiImplicitParam(name = "productId", dataType = "Integer"),
                                                                                            @ApiImplicitParam(name = "name", dataType = "String"),
                                                                                            @ApiImplicitParam(name = "type", dataType = "String"),
                                                                                            @ApiImplicitParam(name = "proportion", dataType = "String"),
                                                                                                    @ApiImplicitParam(name = "level", dataType = "Integer"),
                                @ApiImplicitParam(name = "orderBy", dataType = "String"),
                @ApiImplicitParam(name = "sort", dataType = "String")
            })
public Tip queryProductSettlementProportions(Page<ProductSettlementProportionRecord> page,
@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
@RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
@RequestParam(name = "search", required = false) String search,
                                                                                                                @RequestParam(name = "id", required = false) Integer id,
                                                                                                                                                @RequestParam(name = "productId", required = false) Integer productId,
                                                                                                                                @RequestParam(name = "name", required = false) String name,
                                                                                                                                @RequestParam(name = "type", required = false) String type,
                                                                                                                                @RequestParam(name = "proportion", required = false) String proportion,
                                                                                                                                        @RequestParam(name = "level", required = false) Integer level,
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

    ProductSettlementProportionRecord record = new ProductSettlementProportionRecord();
                                                                                    record.setId(id);
                                                                                                record.setProductId(productId);
                                                                                        record.setName(name);
                                                                                        record.setType(type);
                                                                                        record.setProportion(proportion);
                                                                                        record.setLevel(level);
                    page.setRecords(this.productSettlementProportionService.findProductSettlementProportionPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
        }
        }
