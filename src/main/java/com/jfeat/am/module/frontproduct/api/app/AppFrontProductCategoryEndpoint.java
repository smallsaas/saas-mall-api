package com.jfeat.am.module.frontproduct.api.app;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductCategoryRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.FrontProductCategoryService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.FrontProductCategoryMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProductCategory;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api("FrontProduct")
@RequestMapping("/api/u/product/productCategory")
public class AppFrontProductCategoryEndpoint {


    @Resource
    FrontProductCategoryService frontProductCategoryService;


    @Resource
    FrontProductCategoryMapper frontProductCategoryMapper;

    @GetMapping("/childCategoryById/{id}")
    public Tip getChildProductCategoryById(@PathVariable("id") Long id){
        FrontProductCategoryRecord treeProductCategory = frontProductCategoryService.getTreeProductCategoryById(id);
        if (treeProductCategory!=null&&treeProductCategory.getSubCategoryList()!=null&&treeProductCategory.getSubCategoryList().size()>0){
            return SuccessTip.create(frontProductCategoryService.treeToList(treeProductCategory.getSubCategoryList()));
        }
       return SuccessTip.create();
    }

    @GetMapping("/childCategoryByName/{name}")
    public Tip getChildProductCategoryByName(@PathVariable("name") String name){
        QueryWrapper<FrontProductCategory> frontProductCategoryQueryWrapper = new QueryWrapper<>();
        frontProductCategoryQueryWrapper.eq(FrontProductCategory.CATEGORY_NAME,name);
        FrontProductCategory frontProductCategory = frontProductCategoryMapper.selectOne(frontProductCategoryQueryWrapper);

        if (frontProductCategory!=null){
            FrontProductCategoryRecord treeProductCategory = frontProductCategoryService.getTreeProductCategoryById(frontProductCategory.getId());
            if (treeProductCategory!=null&&treeProductCategory.getSubCategoryList()!=null&&treeProductCategory.getSubCategoryList().size()>0){
                return SuccessTip.create(frontProductCategoryService.treeToList(treeProductCategory.getSubCategoryList()));
            }
        }
        return SuccessTip.create();
    }

    @GetMapping("/app/{appid}")
    public Tip getProductCategoryByAppid(@PathVariable("appid")String appid){
        QueryWrapper<FrontProductCategory> frontProductCategoryQueryWrapper = new QueryWrapper<>();
        frontProductCategoryQueryWrapper.eq(FrontProductCategory.APPID,appid);
        List<FrontProductCategory> frontProductCategories = frontProductCategoryMapper.selectList(frontProductCategoryQueryWrapper);
        return SuccessTip.create(frontProductCategories);
    }

}
