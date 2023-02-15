package com.jfeat.am.module.frontproduct.services.domain.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.core.jwt.JWTKit;
import com.jfeat.am.module.frontproduct.constant.ProductStatus;
import com.jfeat.am.module.frontproduct.services.domain.dao.QueryFrontProductDao;
import com.jfeat.am.module.frontproduct.services.domain.dao.QueryOrgInfoDao;
import com.jfeat.am.module.frontproduct.services.domain.dao.QueryProductSettlementProportionDao;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductModel;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductRecord;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductSettlementProportionRecord;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductSpecificationRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.*;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.impl.CRUDFrontProductServiceImpl;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.*;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.*;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
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
@Service
public class FrontProductServiceImpl extends CRUDFrontProductServiceImpl implements FrontProductService {
    @Resource
    QueryFrontProductDao queryFrontProductDao;

    @Resource
    QueryOrgInfoDao queryOrgInfoDao;


    @Resource
    ProductDescriptionService productDescriptionService;
    @Resource
    ProductImageService productImageService;
    @Resource
    FrontProductTagRelationService frontProductTagRelationService;
    @Resource
    ProductImageMapper productImageMapper;
    @Resource
    ProductDescriptionMapper productDescriptionMapper;
    @Resource
    FrontProductTagRelationMapper frontProductTagRelationMapper;
    @Resource
    FrontProductTagMapper frontProductTagMapper;
    @Resource
    ProductBrandService productBrandService;
    @Resource
    ProductSettlementProportionService productSettlementProportionService;
    @Resource
    ProductSettlementProportionMapper productSettlementProportionMapper;
    @Resource
    QueryProductSettlementProportionDao queryProductSettlementProportionDao;

    @Resource
    ProductSpecificationService productSpecificationService;

    @Override
    public List findProductPage(Page<FrontProductRecord> page, FrontProductRecord record,
                                String search, String orderBy, Date startTime, Date endTime,Long supplierId,String supplierName) {
        List<FrontProductRecord> recordList = this.queryFrontProductDao.findProductPage(page, record, search, orderBy, startTime, endTime,supplierId,supplierName);
        recordList.forEach(item -> {

            FrontProductRecord frontProductRecord = (FrontProductRecord) item;



            if(frontProductRecord.getBrandId()!=null){
                ProductBrand productBrand = productBrandService.retrieveMaster(frontProductRecord.getBrandId());
                frontProductRecord.setProductBrand(productBrand);
            }
        });

       // return this.getEavProxy().selectList(recordList, this.entityName());
        return recordList;
    }

    @Override
    public List<FrontProductRecord> findProductPageByCategoryIds(Page<FrontProductRecord> page, List<Long> categoryIds, FrontProductRecord record, String search, String orderBy, Date startTime, Date endTime, Long supplierId, String supplierName) {

        List<FrontProductRecord> recordList = this.queryFrontProductDao.findProductPageByCategoryIds(page, categoryIds,record, search, orderBy, startTime, endTime,supplierId,supplierName);
        recordList.forEach(item -> {

            FrontProductRecord frontProductRecord = (FrontProductRecord) item;



            if(frontProductRecord.getBrandId()!=null){
                ProductBrand productBrand = productBrandService.retrieveMaster(frontProductRecord.getBrandId());
                frontProductRecord.setProductBrand(productBrand);
            }
        });

        // return this.getEavProxy().selectList(recordList, this.entityName());
        return recordList;
    }

    @Override
    public Long getTenantIdByOrgId(Long orgId){

      Long tenantId = queryOrgInfoDao.getTenantOrgIdByOrgId(orgId);
      return tenantId;
    }

    @Override
    @Transactional
    public Integer createProduct(FrontProductModel entity) {
        int affected = 0;
        if(entity.getStatus()==null){
            entity.setStatus(ProductStatus.OFFSELL.getStatus());
        }
        entity.setOrgId(JWTKit.getOrgId());

        //保存海报
        List<ProductImage> bannerList = entity.getBannerList();
        if(!CollectionUtils.isEmpty(bannerList)){
            for(ProductImage banner : bannerList){
                entity.setBanner(banner.getUrl());
            }
        }

        //设置第一个图片为封面
        List<ProductImage> productImageList = entity.getProductImageList();
        if(!CollectionUtils.isEmpty(productImageList)){
            entity.setCover( productImageList.get(0).getUrl());
        }

        //保存产品
        affected += this.createMaster(entity);

        //保存描述
        ProductDescription productDescription = new ProductDescription();
        productDescription.setProductId(entity.getId());
        productDescription.setDescription(entity.getDescription());
        if(productDescription!=null&&productDescription.getDescription()!=null){
            productDescription.setProductId(entity.getId());
            affected += productDescriptionService.createMaster(productDescription);
        }


        //保存封面
        if(!CollectionUtils.isEmpty(productImageList)){
            for(ProductImage productImage : productImageList){
                productImage.setProductId(entity.getId());
                affected += productImageService.createMaster(productImage);
            }
        }



        //保存标签
        List<Long> tagIds = entity.getTagIds();
        if(!CollectionUtils.isEmpty(tagIds)){
            for(Long tagId : tagIds){
                FrontProductTagRelation frontProductTagRelation = new FrontProductTagRelation();
                frontProductTagRelation.setProductId(entity.getId());
                frontProductTagRelation.setTagId(tagId);
                affected += frontProductTagRelationService.createMaster(frontProductTagRelation);
            }
        }

        //保存分成比例
        List<ProductSettlementProportionRecord> productSettlementProportionList= entity.getProductSettlementProportionList();
        if(productSettlementProportionList!=null && !productSettlementProportionList.isEmpty()){
            //调用方法配置 分成 扁平化
            productSettlementProportionList=
                    productSettlementProportionService.setProductSettlementProportionSettingGroup
                            (productSettlementProportionList,entity.getId().intValue());
            for (ProductSettlementProportionRecord tpsp:productSettlementProportionList) {tpsp.setId(null);
                affected+= productSettlementProportionMapper.insert(tpsp);
            }
        }

        //保存规格
        List<ProductSpecificationRecord> productSpecificationRecords = entity.getSpecifications();
        if(productSpecificationRecords != null && !productSpecificationRecords.isEmpty()){
            for(ProductSpecificationRecord pRecord : productSpecificationRecords){
                pRecord.setProductId(entity.getId().intValue());
                affected+= productSpecificationService.createMaster(pRecord);
            }
        }

        return affected;
    }

    @Override
    public FrontProductModel getProduct(Long id) {

        FrontProductModel frontProduct = queryFrontProductDao.findProductModelById(id);
        if(frontProduct==null){
            throw new BusinessException(BusinessCode.CRUD_QUERY_FAILURE);
        }
        FrontProductModel frontProductModel = CRUD.castObject(frontProduct, FrontProductModel.class);
        //添加images
        List<ProductImage> productImageList = productImageMapper.selectList(new QueryWrapper<ProductImage>().eq("product_id", id));
        frontProductModel.setProductImageList(productImageList);
        //添加banner
        List<ProductImage> bannerList = new ArrayList<>();
        ProductImage banner=new ProductImage();
        banner.setUrl(frontProduct.getBanner());
        bannerList.add(banner);
        frontProductModel.setBannerList(bannerList);
        //添加description
        ProductDescription productDescription = productDescriptionMapper
                .selectOne(new LambdaQueryWrapper<>(new ProductDescription().setProductId(id)));
        if(productDescription!=null&&productDescription.getDescription()!=""){
            String description = productDescription.getDescription();
            frontProductModel.setDescription(description);
            frontProductModel.setProductDescription(productDescription);
        }

        //添加标签
        List<FrontProductTagRelation> frontProductTagRelationList = frontProductTagRelationMapper.selectList(new QueryWrapper<FrontProductTagRelation>().eq("product_id", id));
        List<Long> tagIds = new ArrayList<>();
        frontProductTagRelationList.forEach(item -> {
            tagIds.add(item.getTagId());
        });
        frontProductModel.setTagIds(tagIds);
        //添加分成比例
        List<ProductSettlementProportionRecord> productSettlementProportionList= queryProductSettlementProportionDao.findProductSettlementProportion(id);
          //调用方法配置 分成 扁平化
        productSettlementProportionList=productSettlementProportionService.reSetProductSettlementProportionSettingGroup(productSettlementProportionList);
        frontProductModel.setProductSettlementProportionList(productSettlementProportionList);


        //添加品牌
        if(frontProduct.getBrandId()!=null){
            ProductBrand productBrand = productBrandService.retrieveMaster(frontProduct.getBrandId());
            frontProductModel.setProductBrand(productBrand);
        }
        return frontProductModel;
    }

    @Override
    @Transactional
    public Integer updateProduct(FrontProductModel entity) {
        int affected = 0;

        //更新海报
        List<ProductImage> bannerList = entity.getBannerList();
        if(!CollectionUtils.isEmpty(bannerList)){
            for(ProductImage banner : bannerList){
                entity.setBanner(banner.getUrl());
            }
        }

        //设置第一个图片为封面
        List<ProductImage> productImageList = entity.getProductImageList();
        if(!CollectionUtils.isEmpty(productImageList)){
            entity.setCover( productImageList.get(0).getUrl());
        }
        affected += this.updateMaster(entity, false);

        //更新描述
       List<ProductDescription> productDescriptions = productDescriptionMapper.selectList(new QueryWrapper<ProductDescription>().eq("product_id",entity.getId()));
        ProductDescription productDescription = null;
       if (productDescriptions!=null&&productDescriptions.size()!=0){
           productDescription = new ProductDescription();
            productDescription = productDescriptions.get(0);
            productDescription.setDescription(entity.getDescription());
       }

        if(productDescription!=null){
            affected += productDescriptionService.updateMaster(productDescription,false);
        }else {
            productDescription = new ProductDescription();
            productDescription.setProductId(entity.getId());
            productDescription.setDescription(entity.getDescription());
            affected += productDescriptionService.createMaster(productDescription);
        }



        //更新封面
        affected += productImageMapper.delete(new QueryWrapper<ProductImage>().eq("product_id",entity.getId()));
        if(!CollectionUtils.isEmpty(productImageList)){
            for(ProductImage productImage : productImageList){
                productImage.setProductId(entity.getId());
                affected += productImageService.createMaster(productImage);
            }
        }
        //更新标签
        affected += frontProductTagRelationMapper.delete(new QueryWrapper<FrontProductTagRelation>().eq("product_id", entity.getId()));
        List<Long> tagIds = entity.getTagIds();
        if(!CollectionUtils.isEmpty(tagIds)){
            for(Long tagId : tagIds){
                FrontProductTagRelation frontProductTagRelation = new FrontProductTagRelation();
                frontProductTagRelation.setProductId(entity.getId());
                frontProductTagRelation.setTagId(tagId);
                affected += frontProductTagRelationService.createMaster(frontProductTagRelation);
            }
        }

        //保存分成比例
        List<ProductSettlementProportionRecord> productSettlementProportionList= entity.getProductSettlementProportionList();
        //调用方法配置 分成 扁平化
        productSettlementProportionList=
                productSettlementProportionService.setProductSettlementProportionSettingGroup
                        (productSettlementProportionList,entity.getId().intValue());
        for (ProductSettlementProportionRecord tpsp:productSettlementProportionList) {
            affected+= productSettlementProportionMapper.updateById(tpsp);
        }

        return affected;
    }

    @Override
    public Integer updateProductStatus(Long id, String status) {
        return frontProductMapper.updateById(new FrontProduct().setId(id).setStatus(status));
    }





    @Override
    public Integer createProductHasChild(List<FrontProductModel> frontProductModelList) {
        return null;
    }

    @Override
    public FrontProductModel getProductHasChild(Long id) {
        FrontProductModel frontProductModel =  queryFrontProductDao.findProductModelHasChildById(id);
        return frontProductModel;
    }

    @Override
    public List getProductPageHasChild(Page<FrontProductRecord> page, FrontProductRecord record, String search, String orderBy, Date startTime, Date endTime, Long supplierId, String supplierName) {
        return null;
    }

    @Override
    public Integer updateProductHasChild(FrontProductModel entity) {
        return null;
    }

    @Override
    public Integer deleteProductHasChild(Long id) {
        return null;
    }
}
