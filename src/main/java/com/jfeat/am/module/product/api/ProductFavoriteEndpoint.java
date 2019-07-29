package com.jfeat.am.module.product.api;
    
                                            
                    import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.model.ProductFavoriteRecord;
import com.jfeat.am.module.product.services.domain.service.ProductFavoriteService;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductFavorite;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;


/**
 * <p>
 *  api
 * </p>
 *
 * @author Code Generator
 * @since 2019-07-25
 */
@RestController

@Api("ProductFavorite")
@RequestMapping("/api/crud/product/productFavorites")
public class ProductFavoriteEndpoint {



@Resource
    ProductFavoriteService productFavoriteService;

@PostMapping
@ApiOperation(value = "新建 ProductFavorite",response = ProductFavorite.class)
public Tip createProductFavorite(@RequestBody ProductFavorite entity){

        Integer affected=0;
        try{
                affected= productFavoriteService.createMaster(entity);
    
        }catch(DuplicateKeyException e){
        throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
        }

@GetMapping("/{id}")
@ApiOperation(value = "查看 ProductFavorite",response = ProductFavorite.class)
public Tip getProductFavorite(@PathVariable Long id){
                return SuccessTip.create(productFavoriteService.retrieveMaster(id));
            }

@PutMapping("/{id}")
@ApiOperation(value = "修改 ProductFavorite",response = ProductFavorite.class)
public Tip updateProductFavorite(@PathVariable Integer id,@RequestBody ProductFavorite entity){
        entity.setId(id);
                return SuccessTip.create(productFavoriteService.updateMaster(entity));
            }

@DeleteMapping("/{id}")
@ApiOperation("删除 ProductFavorite")
public Tip deleteProductFavorite(@PathVariable Long id){
                return SuccessTip.create(productFavoriteService.deleteMaster(id));
            }

@ApiOperation(value = "ProductFavorite 列表信息",response = ProductFavoriteRecord.class)
@GetMapping
@ApiImplicitParams({
        @ApiImplicitParam(name= "pageNum", dataType = "Integer"),
        @ApiImplicitParam(name= "pageSize", dataType = "Integer"),
        @ApiImplicitParam(name= "search", dataType = "String"),
                                                                                        @ApiImplicitParam(name = "id", dataType = "Integer"),
                                                                                                            @ApiImplicitParam(name = "userId", dataType = "Integer"),
                                                                                                            @ApiImplicitParam(name = "productId", dataType = "Integer"),
                                                                                                            @ApiImplicitParam(name = "collectDate", dataType = "Date"),
                                @ApiImplicitParam(name = "orderBy", dataType = "String"),
                @ApiImplicitParam(name = "sort", dataType = "String")
            })
public Tip queryProductFavorites(Page<ProductFavoriteRecord> page,
@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
@RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
@RequestParam(name = "search", required = false) String search,
                                                                                                                @RequestParam(name = "id", required = false) Integer id,
                                                                                                                                                @RequestParam(name = "userId", required = false) Integer userId,
                                                                                                                                                @RequestParam(name = "productId", required = false) Integer productId,
                                                                                                                                                @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date collectDate,
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

    ProductFavoriteRecord record = new ProductFavoriteRecord();
                                                                                    record.setId(id);
                                                                                                record.setUserId(userId);
                                                                                                record.setProductId(productId);
                                                                                                record.setCollectDate(collectDate);
                    page.setRecords(this.productFavoriteService.findProductFavoritePage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
        }
        }
