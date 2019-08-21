package com.jfeat.am.module.product.services.domain.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.core.jwt.JWTKit;
import com.jfeat.am.module.product.services.domain.dao.QueryProductCategoryDao;
import com.jfeat.am.module.product.services.domain.model.ProductCategoryModel;
import com.jfeat.am.module.product.services.domain.model.ProductCategoryRecord;
import com.jfeat.am.module.product.services.domain.service.ProductCategoryPropertyService;
import com.jfeat.am.module.product.services.domain.service.ProductCategoryService;
import com.jfeat.am.module.product.services.gen.crud.service.impl.CRUDProductCategoryServiceImpl;
import com.jfeat.am.module.product.services.gen.persistence.dao.ProductCategoryPropertyMapper;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductCategory;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductCategoryProperty;
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
@Service("productCategoryService")
public class ProductCategoryServiceImpl extends CRUDProductCategoryServiceImpl implements ProductCategoryService {
    @Resource
    QueryProductCategoryDao queryProductCategoryDao;
    @Resource
    ProductCategoryPropertyService productCategoryPropertyService;
    @Resource
    ProductCategoryPropertyMapper productCategoryPropertyMapper;

    @Override
    public List findProductCategoryPage(Page<ProductCategoryRecord> page, ProductCategoryRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryProductCategoryDao.findProductCategoryPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }

    @Override
    @Transactional
    public Integer createProductCategory(ProductCategoryModel entity) {
        int affected  = 0;
        entity.setOrgId(JWTKit.getOrgId());
        affected += this.productCategoryMapper.insert(entity);
        //affected += this.createMaster(entity);
        List<ProductCategoryProperty> productCategoryPropertyList = entity.getProductCategoryPropertyList();
        productCategoryPropertyList.forEach(item -> {
            item.setCategoryId(entity.getId());
            productCategoryPropertyService.createMaster(item);
        });
        return affected;
    }

    @Override
    public ProductCategoryModel getProductCategoryById(Long id) {
        ProductCategory productCategory = this.retrieveMaster(id);
        List<ProductCategoryProperty> categoryPropertyList = productCategoryPropertyMapper.selectList(new EntityWrapper<ProductCategoryProperty>().eq("category_id", id));
        ProductCategoryModel productCategoryModel = CRUD.castObject(productCategory, ProductCategoryModel.class);
        productCategoryModel.setProductCategoryPropertyList(categoryPropertyList);
        return productCategoryModel;
    }

    @Override
    @Transactional
    public Integer updateProductCategoryById(ProductCategoryModel entity) {
        int affected = 0;
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
    public List<ProductCategoryRecord> queryProductCategoryies() {

        List<ProductCategory> productCategoryList = productCategoryMapper.selectList(new EntityWrapper<ProductCategory>().isNull("parent_id").orderBy("sort_order"));

        return productCategoryList.stream().map(item -> {
            ProductCategoryRecord record = CRUD.castObject(item, ProductCategoryRecord.class);
            return addSubProductCategory(record);
        }).collect(Collectors.toList());

    }

    /**
     * 填充子类别
     * @param productCategoryRecord
     * @return
     */
    private ProductCategoryRecord addSubProductCategory(ProductCategoryRecord productCategoryRecord){

        List<ProductCategory> productCategoryList = productCategoryMapper.selectList(new EntityWrapper<ProductCategory>().eq("parent_id", productCategoryRecord.getId()).orderBy("sort_order"));

        if(!CollectionUtils.isEmpty(productCategoryList)){
            List<ProductCategoryRecord> productCategoryRecordList = productCategoryList.stream().map(item -> {
                ProductCategoryRecord record = CRUD.castObject(item, ProductCategoryRecord.class);
                return addSubProductCategory(record);
            }).collect(Collectors.toList());
            productCategoryRecord.setSubCategoryList(productCategoryRecordList);

        }
        return productCategoryRecord;
    }

}
