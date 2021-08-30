package com.jfeat.am.module.frontproduct.services.domain.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.frontproduct.services.domain.dao.QueryTrialDao;
import com.jfeat.am.module.frontproduct.services.domain.model.TrialRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.FrontProductService;
import com.jfeat.am.module.frontproduct.services.domain.service.TrialImageService;
import com.jfeat.am.module.frontproduct.services.domain.service.TrialOverModelService;
import com.jfeat.am.module.frontproduct.services.gen.crud.model.TrialModel;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.impl.CRUDTrialOverModelServiceImpl;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.TrialImageMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProduct;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.Trial;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.TrialImage;
import com.jfeat.crud.plus.CRUD;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */
@Service("trialService")
public class TrialOverModelServiceImpl extends CRUDTrialOverModelServiceImpl implements TrialOverModelService {
    @Resource
    QueryTrialDao queryTrialDao;
    @Resource
    FrontProductService frontProductService;
    @Resource
    TrialImageMapper trialImageMapper;
    @Resource
    TrialImageService trialImageService;

    @Override
    public List findTrialPage(Page<TrialRecord> page, TrialRecord record,
                              String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryTrialDao.findTrialPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }

    @Override
    public Integer updateTrialStatus(Long id, Integer status) {
        return trialMapper.updateById(new Trial().setId(id).setEnabled(status));
    }

    @Override
    public TrialModel getTrial(Long id) {
        Trial trial = this.retrieveMaster(id);
        TrialModel trialModel = CRUD.castObject(trial, TrialModel.class);
        FrontProduct frontProduct = frontProductService.retrieveMaster(trial.getProductId());
        trialModel.setFrontProduct(frontProduct);

        List<TrialImage> trialImageList= trialImageMapper.selectList(new QueryWrapper<TrialImage>().eq("trial_id", trial.getId()));
        trialModel.setItems(trialImageList);
        return trialModel;
    }

    @Override
    public Integer createTrial(TrialModel entity) {
        Integer affected = 0;
        affected += this.createMaster(entity);
        List<TrialImage> items = entity.getItems();
        if(!CollectionUtils.isEmpty(items)){
            for (TrialImage trialImage : items){
                trialImage.setTrialId(entity.getId());
                affected += trialImageService.createMaster(trialImage);
            }
        }
        return affected;
    }
}
