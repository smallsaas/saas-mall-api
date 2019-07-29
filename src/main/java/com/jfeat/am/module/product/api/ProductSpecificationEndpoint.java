package com.jfeat.am.module.product.api;
    
                                            
                    import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.model.ProductSpecificationRecord;
import com.jfeat.am.module.product.services.domain.service.ProductSpecificationService;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductSpecification;
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
import java.math.BigDecimal;


/**
 * <p>
 *  api
 * </p>
 *
 * @author Code Generator
 * @since 2019-07-25
 */
@RestController

@Api("ProductSpecification")
@RequestMapping("/api/crud/product/productSpecifications")
public class ProductSpecificationEndpoint {



@Resource
    ProductSpecificationService productSpecificationService;

@PostMapping
@ApiOperation(value = "新建 ProductSpecification",response = ProductSpecification.class)
public Tip createProductSpecification(@RequestBody ProductSpecification entity){

        Integer affected=0;
        try{
                affected= productSpecificationService.createMaster(entity);
    
        }catch(DuplicateKeyException e){
        throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
        }

@GetMapping("/{id}")
@ApiOperation(value = "查看 ProductSpecification",response = ProductSpecification.class)
public Tip getProductSpecification(@PathVariable Long id){
                return SuccessTip.create(productSpecificationService.retrieveMaster(id));
            }

@PutMapping("/{id}")
@ApiOperation(value = "修改 ProductSpecification",response = ProductSpecification.class)
public Tip updateProductSpecification(@PathVariable Integer id,@RequestBody ProductSpecification entity){
        entity.setId(id);
                return SuccessTip.create(productSpecificationService.updateMaster(entity));
            }

@DeleteMapping("/{id}")
@ApiOperation("删除 ProductSpecification")
public Tip deleteProductSpecification(@PathVariable Long id){
                return SuccessTip.create(productSpecificationService.deleteMaster(id));
            }

@ApiOperation(value = "ProductSpecification 列表信息",response = ProductSpecificationRecord.class)
@GetMapping
@ApiImplicitParams({
        @ApiImplicitParam(name= "pageNum", dataType = "Integer"),
        @ApiImplicitParam(name= "pageSize", dataType = "Integer"),
        @ApiImplicitParam(name= "search", dataType = "String"),
                                                                                        @ApiImplicitParam(name = "id", dataType = "Integer"),
                                                                                                            @ApiImplicitParam(name = "productId", dataType = "Integer"),
                                                                                            @ApiImplicitParam(name = "name", dataType = "String"),
                                                                                                            @ApiImplicitParam(name = "stockBalance", dataType = "Integer"),
                                                                                                    @ApiImplicitParam(name = "price", dataType = "BigDecimal"),
                                                                                                            @ApiImplicitParam(name = "costPrice", dataType = "BigDecimal"),
                                                                                                            @ApiImplicitParam(name = "suggestedPrice", dataType = "BigDecimal"),
                                                                                                    @ApiImplicitParam(name = "weight", dataType = "Integer"),
                                                                                                    @ApiImplicitParam(name = "bulk", dataType = "Integer"),
                                                                                                    @ApiImplicitParam(name = "skuId", dataType = "String"),
                                                                                                    @ApiImplicitParam(name = "skuName", dataType = "String"),
                                                                                                    @ApiImplicitParam(name = "skuCode", dataType = "String"),
                                                                                                    @ApiImplicitParam(name = "barCode", dataType = "String"),
                                @ApiImplicitParam(name = "orderBy", dataType = "String"),
                @ApiImplicitParam(name = "sort", dataType = "String")
            })
public Tip queryProductSpecifications(Page<ProductSpecificationRecord> page,
@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
@RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
@RequestParam(name = "search", required = false) String search,
                                                                                                                @RequestParam(name = "id", required = false) Integer id,
                                                                                                                                                @RequestParam(name = "productId", required = false) Integer productId,
                                                                                                                                @RequestParam(name = "name", required = false) String name,
                                                                                                                                                @RequestParam(name = "stockBalance", required = false) Integer stockBalance,
                                                                                                                                        @RequestParam(name = "price", required = false) BigDecimal price,
                                                                                                                                                @RequestParam(name = "costPrice", required = false) BigDecimal costPrice,
                                                                                                                                                @RequestParam(name = "suggestedPrice", required = false) BigDecimal suggestedPrice,
                                                                                                                                        @RequestParam(name = "weight", required = false) Integer weight,
                                                                                                                                        @RequestParam(name = "bulk", required = false) Integer bulk,
                                                                                                                                        @RequestParam(name = "skuId", required = false) String skuId,
                                                                                                                                        @RequestParam(name = "skuName", required = false) String skuName,
                                                                                                                                        @RequestParam(name = "skuCode", required = false) String skuCode,
                                                                                                                                        @RequestParam(name = "barCode", required = false) String barCode,
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

    ProductSpecificationRecord record = new ProductSpecificationRecord();
                                                                                    record.setId(id);
                                                                                                record.setProductId(productId);
                                                                                        record.setName(name);
                                                                                                record.setStockBalance(stockBalance);
                                                                                        record.setPrice(price);
                                                                                                record.setCostPrice(costPrice);
                                                                                                record.setSuggestedPrice(suggestedPrice);
                                                                                        record.setWeight(weight);
                                                                                        record.setBulk(bulk);
                                                                                                record.setSkuId(skuId);
                                                                                                record.setSkuName(skuName);
                                                                                                record.setSkuCode(skuCode);
                                                                                                record.setBarCode(barCode);
                    page.setRecords(this.productSpecificationService.findProductSpecificationPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
        }
        }
