package com.jfeat.am.module.product.services.domain.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.constant.ProductStatus;
import com.jfeat.am.module.product.services.domain.dao.QueryProductDao;
import com.jfeat.am.module.product.services.domain.model.ProductModel;
import com.jfeat.am.module.product.services.domain.model.ProductRecord;
import com.jfeat.am.module.product.services.domain.service.ProductDescriptionService;
import com.jfeat.am.module.product.services.domain.service.ProductImageService;
import com.jfeat.am.module.product.services.domain.service.ProductService;
import com.jfeat.am.module.product.services.domain.service.ProductTagRelationService;
import com.jfeat.am.module.product.services.gen.crud.service.impl.CRUDProductServiceImpl;
import com.jfeat.am.module.product.services.gen.persistence.dao.ProductDescriptionMapper;
import com.jfeat.am.module.product.services.gen.persistence.dao.ProductImageMapper;
import com.jfeat.am.module.product.services.gen.persistence.dao.ProductTagMapper;
import com.jfeat.am.module.product.services.gen.persistence.dao.ProductTagRelationMapper;
import com.jfeat.am.module.product.services.gen.persistence.model.*;
import com.jfeat.crud.plus.CRUD;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    @Resource
    ProductImageMapper productImageMapper;
    @Resource
    ProductDescriptionMapper productDescriptionMapper;
    @Resource
    ProductTagRelationMapper productTagRelationMapper;
    @Resource
    ProductTagMapper productTagMapper;

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
        if(entity.getStatus()==null){
            entity.setStatus(ProductStatus.OFFSELL.getStatus());
        }
        affected += this.createMaster(entity);
        //保存描述
        ProductDescription productDescription = entity.getProductDescription();
        if(productDescription!=null){
            productDescription.setProductId(entity.getId());
            affected += productDescriptionService.createMaster(productDescription);
        }
        //保存封面
        List<ProductImage> productImageList = entity.getProductImageList();
        if(!CollectionUtils.isEmpty(productImageList)){
            for(ProductImage productImage : productImageList){
                productImage.setProductId(entity.getId());
                affected += productImageService.createMaster(productImage);
            }
        }
        //保存标签
        List<Integer> tagIds = entity.getTagIds();
        if(!CollectionUtils.isEmpty(tagIds)){
            for(Integer tagId : tagIds){
                ProductTagRelation productTagRelation = new ProductTagRelation();
                productTagRelation.setProductId(entity.getId());
                productTagRelation.setTagId(tagId);
                affected += productTagRelationService.createMaster(productTagRelation);
            }
        }

        return affected;
    }

    @Override
    public ProductModel getProduct(Integer id) {
        Product product = this.retrieveMaster(id);
        ProductModel productModel = CRUD.castObject(product, ProductModel.class);
        //添加images
        List<ProductImage> productImageList = productImageMapper.selectList(new EntityWrapper<ProductImage>().eq("product_id", id));
        productModel.setProductImageList(productImageList);
        //添加description
        ProductDescription productDescription = productDescriptionMapper.selectOne(new ProductDescription().setProductId(id));
        productModel.setProductDescription(productDescription);
        //添加标签
        List<ProductTagRelation> productTagRelationList = productTagRelationMapper.selectList(new EntityWrapper<ProductTagRelation>().eq("product_id", id));
        List<ProductTag> productTagList = new ArrayList<>();
        productTagRelationList.forEach(item -> {
            ProductTag productTag = productTagMapper.selectById(item.getTagId());
            productTagList.add(productTag);
        });

        return productModel;
    }

    @Override
    @Transactional
    public Integer updateProduct(ProductModel entity) {
        int affected = 0;
        affected += this.updateMaster(entity, false);
        //更新描述
        ProductDescription productDescription = entity.getProductDescription();
        if(productDescription!=null){
            affected += productDescriptionService.updateMaster(productDescription,false);
        }
        //更新封面
        affected += productImageMapper.delete(new EntityWrapper<ProductImage>().eq("product_id",entity.getId()));
        List<ProductImage> productImageList = entity.getProductImageList();
        if(!CollectionUtils.isEmpty(productImageList)){
            for(ProductImage productImage : productImageList){
                productImage.setProductId(entity.getId());
                affected += productImageService.createMaster(productImage);
            }
        }
        //更新标签
        affected += productTagRelationMapper.delete(new EntityWrapper<ProductTagRelation>().eq("product_id", entity.getId()));
        List<Integer> tagIds = entity.getTagIds();
        if(!CollectionUtils.isEmpty(tagIds)){
            for(Integer tagId : tagIds){
                ProductTagRelation productTagRelation = new ProductTagRelation();
                productTagRelation.setProductId(entity.getId());
                productTagRelation.setTagId(tagId);
                affected += productTagRelationService.createMaster(productTagRelation);
            }
        }
        return affected;
    }

    @Override
    public Integer updateProductStatus(Integer id, String status) {
        return productMapper.updateById(new Product().setId(id).setStatus(status));
    }
}
