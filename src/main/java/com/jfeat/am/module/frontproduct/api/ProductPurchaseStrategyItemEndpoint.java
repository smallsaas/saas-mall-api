package com.jfeat.am.module.frontproduct.api;
    
                                            
                    import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductPurchaseStrategyItemRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.ProductPurchaseStrategyItemService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductPurchaseStrategyItem;
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

@Api("ProductPurchaseStrategyItem")
@RequestMapping("/api/crud/product/productPurchaseStrategyItems")
public class ProductPurchaseStrategyItemEndpoint {



@Resource
    ProductPurchaseStrategyItemService productPurchaseStrategyItemService;

@PostMapping
@ApiOperation(value = "新建 ProductPurchaseStrategyItem",response = ProductPurchaseStrategyItem.class)
public Tip createProductPurchaseStrategyItem(@RequestBody ProductPurchaseStrategyItem entity){

        Integer affected=0;
        try{
                affected= productPurchaseStrategyItemService.createMaster(entity);
    
        }catch(DuplicateKeyException e){
        throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
        }

@GetMapping("/{id}")
@ApiOperation(value = "查看 ProductPurchaseStrategyItem",response = ProductPurchaseStrategyItem.class)
public Tip getProductPurchaseStrategyItem(@PathVariable Long id){
                return SuccessTip.create(productPurchaseStrategyItemService.retrieveMaster(id));
            }

@PutMapping("/{id}")
@ApiOperation(value = "修改 ProductPurchaseStrategyItem",response = ProductPurchaseStrategyItem.class)
public Tip updateProductPurchaseStrategyItem(@PathVariable Long id,@RequestBody ProductPurchaseStrategyItem entity){
        entity.setId(id);
                return SuccessTip.create(productPurchaseStrategyItemService.updateMaster(entity));
            }

@DeleteMapping("/{id}")
@ApiOperation("删除 ProductPurchaseStrategyItem")
public Tip deleteProductPurchaseStrategyItem(@PathVariable Long id){
                return SuccessTip.create(productPurchaseStrategyItemService.deleteMaster(id));
            }

@ApiOperation(value = "ProductPurchaseStrategyItem 列表信息",response = ProductPurchaseStrategyItemRecord.class)
@GetMapping
@ApiImplicitParams({
        @ApiImplicitParam(name= "pageNum", dataType = "Integer"),
        @ApiImplicitParam(name= "pageSize", dataType = "Integer"),
        @ApiImplicitParam(name= "search", dataType = "String"),
                                                                                        @ApiImplicitParam(name = "id", dataType = "Integer"),
                                                                                                            @ApiImplicitParam(name = "strategyId", dataType = "Integer"),
                                                                                            @ApiImplicitParam(name = "name", dataType = "String"),
                                                                                            @ApiImplicitParam(name = "operator", dataType = "String"),
                                                                                                            @ApiImplicitParam(name = "sortNum", dataType = "Integer"),
                                                                                            @ApiImplicitParam(name = "param", dataType = "String"),
                                @ApiImplicitParam(name = "orderBy", dataType = "String"),
                @ApiImplicitParam(name = "sort", dataType = "String")
            })
public Tip queryProductPurchaseStrategyItems(Page<ProductPurchaseStrategyItemRecord> page,
@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
@RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
@RequestParam(name = "search", required = false) String search,
                                                                                                                @RequestParam(name = "id", required = false) Long id,
                                                                                                                                                @RequestParam(name = "strategyId", required = false) Integer strategyId,
                                                                                                                                @RequestParam(name = "name", required = false) String name,
                                                                                                                                @RequestParam(name = "operator", required = false) String operator,
                                                                                                                                                @RequestParam(name = "sortNum", required = false) Integer sortNum,
                                                                                                                                @RequestParam(name = "param", required = false) String param,
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

    ProductPurchaseStrategyItemRecord record = new ProductPurchaseStrategyItemRecord();
                                                                                    record.setId(id);
                                                                                                record.setStrategyId(strategyId);
                                                                                        record.setName(name);
                                                                                        record.setOperator(operator);
                                                                                                record.setSortNum(sortNum);
                                                                                        record.setParam(param);
                    page.setRecords(this.productPurchaseStrategyItemService.findProductPurchaseStrategyItemPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
        }
        }
