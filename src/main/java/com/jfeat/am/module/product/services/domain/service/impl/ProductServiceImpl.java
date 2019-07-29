package com.jfeat.am.module.product.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.dao.QueryProductDao;
import com.jfeat.am.module.product.services.domain.model.ProductDescriptionModel;
import com.jfeat.am.module.product.services.domain.model.ProductImageModel;
import com.jfeat.am.module.product.services.domain.model.ProductModel;
import com.jfeat.am.module.product.services.domain.model.ProductRecord;
import com.jfeat.am.module.product.services.domain.service.ProductDescriptionService;
import com.jfeat.am.module.product.services.domain.service.ProductImageService;
import com.jfeat.am.module.product.services.domain.service.ProductService;
import com.jfeat.am.module.product.services.domain.service.ProductTagRelationService;
import com.jfeat.am.module.product.services.gen.crud.service.impl.CRUDProductServiceImpl;
import com.jfeat.am.module.product.services.gen.persistence.model.Product;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductTagRelation;
import com.jfeat.crud.plus.CRUD;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */
@Service("productService")
public class ProductServiceImpl extends CRUDProductServiceImpl implements ProductService {
    @Resource
    QueryProductDao queryProductDao;
    @Resource
    ProductDescriptionService productDescriptionService;
    @Resource
    ProductImageService productImageService;
    @Resource
    ProductTagRelationService productTagRelationService;

    @Override
    public List findProductPage(Page<ProductRecord> page, ProductRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryProductDao.findProductPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }

    @Override
    @Transactional
    public Integer createProduct(ProductModel entity) {
        int affected = 0;
        affected += this.createMaster(entity);
        //保存描述
        ProductDescriptionModel productDescriptionModel = entity.getProductDescriptionModel();
        productDescriptionModel.setProductId(entity.getId());
        affected += productDescriptionService.createMaster(productDescriptionModel);
        //保存封面
        List<ProductImageModel> productImageModelList = entity.getProductImageModelList();
        for(ProductImageModel productImageModel : productImageModelList){
            productImageModel.setProductId(entity.getId());
            affected += productImageService.createMaster(productImageModel);
        }
        //保存标签
        List<Integer> tagIds = entity.getTagIds();
        for(Integer tagId : tagIds){
            ProductTagRelation productTagRelation = new ProductTagRelation();
            productTagRelation.setProductId(entity.getId());
            productTagRelation.setTagId(tagId);
            affected += productTagRelationService.createMaster(productTagRelation);
        }
        return affected;
    }

    @Override
    public ProductModel getProduct(Long id) {
        Product product = this.retrieveMaster(id);
        ProductModel productModel = CRUD.castObject(product, ProductModel.class);

        return null;
    }
}
