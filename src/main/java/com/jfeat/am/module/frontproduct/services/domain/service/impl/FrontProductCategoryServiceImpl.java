package com.jfeat.am.module.frontproduct.services.domain.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.dao.QueryFrontProductCategoryDao;
import com.jfeat.am.module.frontproduct.services.domain.filter.FrontProductCategoryFilter;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductCategoryModel;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductCategoryRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.FrontProductCategoryService;
import com.jfeat.am.module.frontproduct.services.domain.service.ProductCategoryPropertyService;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.impl.CRUDFrontProductCategoryServiceImpl;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.ProductCategoryPropertyMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProductCategory;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductCategoryProperty;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.plus.CRUD;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */
@Service
public class FrontProductCategoryServiceImpl extends CRUDFrontProductCategoryServiceImpl implements FrontProductCategoryService {
    @Resource
    QueryFrontProductCategoryDao queryProductCategoryDao;
    @Resource
    ProductCategoryPropertyService productCategoryPropertyService;
    @Resource
    ProductCategoryPropertyMapper productCategoryPropertyMapper;

    @Override
    public List findProductCategoryPage(Page<FrontProductCategoryRecord> page, FrontProductCategoryRecord record,
                                        String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryProductCategoryDao.findProductCategoryPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }

    @Override
    @Transactional
    public Integer createProductCategory(FrontProductCategoryModel entity) {
        int affected  = 0;
        /*entity.setOrgId(JWTKit.getOrgId());
        affected += this.frontProductCategoryMapper.insert(entity);*/
//        FrontProductCategoryFilter filter = new FrontProductCategoryFilter ();
        affected += this.createMaster(entity);

//        Long entityId = filter.result().containsKey("id")
//                ? filter.result().getLong("id"): null;

        List<ProductCategoryProperty> productCategoryPropertyList = entity.getProductCategoryPropertyList();
        if(productCategoryPropertyList!=null){
            productCategoryPropertyList.forEach(item -> {
                item.setCategoryId(entity.getId());
                productCategoryPropertyService.createMaster(item);
            });
        }
        return affected;
    }

    @Override
    public FrontProductCategoryModel getProductCategoryById(Long id) {
        FrontProductCategory frontProductCategory = this.retrieveMaster(id);
        List<ProductCategoryProperty> categoryPropertyList = productCategoryPropertyMapper.selectList(new EntityWrapper<ProductCategoryProperty>().eq("category_id", id));
        if(frontProductCategory==null){
            throw new BusinessException(BusinessCode.BadRequest, "目标Id对应的实体不存在");
        }
        FrontProductCategoryModel frontProductCategoryModel = CRUD.castObject(frontProductCategory, FrontProductCategoryModel.class);
        frontProductCategoryModel.setProductCategoryPropertyList(categoryPropertyList);
        return frontProductCategoryModel;
    }

    @Override
    @Transactional
    public Integer updateProductCategoryById(FrontProductCategoryModel entity) {
        int affected = 0;

        //父id不为空 且 父id 等于 当前Id
        if(entity.getParentId()!=null && entity.getId() == entity.getParentId().longValue() ){
            entity.setParentId(null);
         }

        affected += this.updateMaster(entity,false);


        affected += productCategoryPropertyMapper.delete(new EntityWrapper<ProductCategoryProperty>().eq("category_id",entity.getId()));
        List<ProductCategoryProperty> productCategoryPropertyList = entity.getProductCategoryPropertyList();
        productCategoryPropertyList.forEach(item -> {
            item.setCategoryId(entity.getId());
            productCategoryPropertyService.createMaster(item);
        });
        return affected;
    }

    @Override
    public List<FrontProductCategoryRecord> queryProductCategoryies(String name) {

        List<FrontProductCategory> frontProductCategoryList;
        if (name!=null && !name.equals("")){
            frontProductCategoryList = frontProductCategoryMapper.selectList(new EntityWrapper<FrontProductCategory>()
                    .eq("name",name)
                    .isNull("parent_id").orderBy("sort_order"));

        }
        else {
            frontProductCategoryList  = frontProductCategoryMapper.selectList(new EntityWrapper<FrontProductCategory>().isNull("parent_id").orderBy("sort_order"));
        }
        return frontProductCategoryList.stream().map(item -> {
            FrontProductCategoryRecord record = CRUD.castObject(item, FrontProductCategoryRecord.class);
            return addSubProductCategory(record);
        }).collect(Collectors.toList());

    }

    /**
     * 填充子类别
     * @param frontProductCategoryRecord
     * @return
     */
    private FrontProductCategoryRecord addSubProductCategory(FrontProductCategoryRecord frontProductCategoryRecord){

        List<FrontProductCategory> frontProductCategoryList = frontProductCategoryMapper.selectList(new EntityWrapper<FrontProductCategory>().eq("parent_id", frontProductCategoryRecord.getId()).orderBy("sort_order"));

        if(!CollectionUtils.isEmpty(frontProductCategoryList)){
            List<FrontProductCategoryRecord> frontProductCategoryRecordList = frontProductCategoryList.stream().map(item -> {
                FrontProductCategoryRecord record = CRUD.castObject(item, FrontProductCategoryRecord.class);
                return addSubProductCategory(record);
            }).collect(Collectors.toList());
            frontProductCategoryRecord.setSubCategoryList(frontProductCategoryRecordList);

        }
        return frontProductCategoryRecord;
    }

}
