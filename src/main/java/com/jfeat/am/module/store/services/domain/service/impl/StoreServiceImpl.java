package com.jfeat.am.module.store.services.domain.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.module.store.services.crud.service.impl.CRUDStoreServiceImpl;
import com.jfeat.am.module.store.services.definition.StoreStatus;
import com.jfeat.am.module.store.services.domain.dao.QueryStoreDao;
import com.jfeat.am.module.store.services.domain.model.StoreModel;
import com.jfeat.am.module.store.services.domain.model.StoreRecord;
import com.jfeat.am.module.store.services.domain.service.StoreService;
import com.jfeat.am.module.store.services.mq.StoreUpdateSender;
import com.jfeat.am.module.store.services.persistence.dao.StoreMapper;
import com.jfeat.am.module.store.services.persistence.model.Store;
import com.jfeat.images.services.domain.service.StockImagesService;
import com.jfeat.images.services.persistence.model.StockImages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */
@Service
public class StoreServiceImpl extends CRUDStoreServiceImpl implements StoreService {
    private final Logger logger = LoggerFactory.getLogger(StoreServiceImpl.class);
    @Resource
    QueryStoreDao queryStoreDao;
    @Resource
    StoreMapper storeMapper;
    @Resource
    StockImagesService stockImagesService;
    @Resource
    StoreUpdateSender storeUpdateSender;

    @Override
    public StoreRecord findStoreInfo(Long id, BigDecimal latitude, BigDecimal longitude) {
        return queryStoreDao.findStoreInfo(id, latitude, longitude);
    }


    /**
     * create store include images
     */
    @Transactional
    public Integer createStore(StoreModel entity) {
        Integer affected = 0;
        if (entity.getImages() == null && entity.getImages().size() == 0) {
            throw new BusinessException(4000, "请为该店铺上传至少一张图片!");
        }
        entity.setAvatar(entity.getImages().get(0).getUrl());
        entity.setStatus(StoreStatus.BUSINESS.toString());
//        affected += storeMapper.insert(entity);
        affected += this.createMaster(entity);
        List<StockImages> images = entity.getImages();
        for (StockImages image : images) {
            image.setStockId(entity.getId());
            image.setStockType(entity.getType());
        }
        affected += stockImagesService.uploadImages(images);
        return affected;
    }

    /**
     * update Store
     */
    @Transactional
    public Integer updateStore(Long id, StoreModel entity) {
        Integer affected = 0;
        entity.setId(id);
        if (entity.getImages() == null || entity.getImages().size() == 0) {
            throw new BusinessException(4000, "请为该店铺上传至少一张图片!");
        }
        for (StockImages image : entity.getImages()) {
            image.setStockId(entity.getId());
            image.setStockType("Store");
        }
        Store oldStoreData = storeMapper.selectById(entity);
        affected += stockImagesService.updateImage(id, "Store", entity.getImages());
        affected += storeMapper.updateById(entity);

        /**
         * send message
         **/
        if(affected > 0) {
            if(entity.getName() != null && !entity.getName().equals(oldStoreData.getName())
                    || entity.getCode() != null && !entity.getCode().equals(oldStoreData.getCode())) {
                JSONObject data = new JSONObject();
                data.put("id", entity.getId());
                data.put("oldCode", oldStoreData.getCode());
                data.put("name", entity.getName());
                data.put("code", entity.getCode());
                JSONObject msg = new JSONObject();
                msg.put("type", StoreUpdateSender.MESSAGE_TYPE);
                msg.put("data", data);
                try {
                    storeUpdateSender.send(msg);
                } catch (JsonProcessingException e) {
                    logger.error("send message error! \n", e.getMessage());
                }
            }
        }
        return affected;
    }

}
