package com.jfeat.am.module.frontproduct.api;
    
                                            
                    import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductPropertyRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.ProductPropertyService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductProperty;
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

@Api("ProductProperty")
@RequestMapping("/api/crud/product/productPropertyies")
public class ProductPropertyEndpoint {



@Resource
    ProductPropertyService productPropertyService;

@PostMapping
@ApiOperation(value = "新建 ProductProperty",response = ProductProperty.class)
public Tip createProductProperty(@RequestBody ProductProperty entity){

        Integer affected=0;
        try{
                affected= productPropertyService.createMaster(entity);
    
        }catch(DuplicateKeyException e){
        throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
        }

@GetMapping("/{id}")
@ApiOperation(value = "查看 ProductProperty",response = ProductProperty.class)
public Tip getProductProperty(@PathVariable Long id){
                return SuccessTip.create(productPropertyService.retrieveMaster(id));
            }

@PutMapping("/{id}")
@ApiOperation(value = "修改 ProductProperty",response = ProductProperty.class)
public Tip updateProductProperty(@PathVariable Long id,@RequestBody ProductProperty entity){
        entity.setId(id);
                return SuccessTip.create(productPropertyService.updateMaster(entity));
            }

@DeleteMapping("/{id}")
@ApiOperation("删除 ProductProperty")
public Tip deleteProductProperty(@PathVariable Long id){
                return SuccessTip.create(productPropertyService.deleteMaster(id));
            }

@ApiOperation(value = "ProductProperty 列表信息",response = ProductPropertyRecord.class)
@GetMapping
@ApiImplicitParams({
        @ApiImplicitParam(name= "pageNum", dataType = "Integer"),
        @ApiImplicitParam(name= "pageSize", dataType = "Integer"),
        @ApiImplicitParam(name= "search", dataType = "String"),
                                                                                        @ApiImplicitParam(name = "id", dataType = "Integer"),
                                                                                                            @ApiImplicitParam(name = "productId", dataType = "Integer"),
                                                                                                            @ApiImplicitParam(name = "propertyId", dataType = "Integer"),
                                                                                                    @ApiImplicitParam(name = "propertyValue", dataType = "String"),
                                @ApiImplicitParam(name = "orderBy", dataType = "String"),
                @ApiImplicitParam(name = "sort", dataType = "String")
            })
public Tip queryProductPropertyies(Page<ProductPropertyRecord> page,
@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
@RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
@RequestParam(name = "search", required = false) String search,
                                                                                                                @RequestParam(name = "id", required = false) Long id,
                                                                                                                                                @RequestParam(name = "productId", required = false) Integer productId,
                                                                                                                                                @RequestParam(name = "propertyId", required = false) Integer propertyId,
                                                                                                                                        @RequestParam(name = "propertyValue", required = false) String propertyValue,
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

    ProductPropertyRecord record = new ProductPropertyRecord();
                                                                                    record.setId(id);
                                                                                                record.setProductId(productId);
                                                                                                record.setPropertyId(propertyId);
                                                                                                record.setPropertyValue(propertyValue);
                    page.setRecords(this.productPropertyService.findProductPropertyPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
        }
        }
