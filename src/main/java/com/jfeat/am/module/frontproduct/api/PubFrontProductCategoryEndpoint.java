package com.jfeat.am.module.frontproduct.api;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductCategoryRecord;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductList;
import com.jfeat.am.module.frontproduct.services.domain.service.FrontProductCategoryService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.FrontProductMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProduct;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProductCategory;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2019-07-25
 */
@RestController

@Api("FrontProductCategory")
@RequestMapping("/openapi/crud/productCategoryies")
public class PubFrontProductCategoryEndpoint {


    @Resource
    FrontProductCategoryService frontProductCategoryService;

    @Resource
    FrontProductMapper frontProductMapper;




    //前端专用
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 FrontProductCategory", response = FrontProductCategory.class)
    public Tip getPubProductCategory(@PathVariable Long id) {
        List<FrontProduct> product=new ArrayList<>();
        FrontProductList products=new FrontProductList();
        if(id==-1L){
            product=frontProductMapper.selectList(new EntityWrapper<FrontProduct>());
            products.setLength(product.size());
            products.setProducts(product);
            return SuccessTip.create(products);
        }
        product=frontProductMapper.selectList(new EntityWrapper<FrontProduct>().eq("category_id",id));
        products.setLength(product.size());
        products.setProducts(product);
        return SuccessTip.create(products);
    }


    @ApiOperation(value = "前端专用 返回所有ProductCategory", response = FrontProductCategoryRecord.class)
    @GetMapping
    public Tip queryPubProductCategoryies(@RequestParam(name = "name", required = false)  String name){
        List<FrontProductCategoryRecord> frontProductCategoryRecordList =  frontProductCategoryService.queryProductCategoryies(name);
        return SuccessTip.create(frontProductCategoryRecordList);
    }

}
