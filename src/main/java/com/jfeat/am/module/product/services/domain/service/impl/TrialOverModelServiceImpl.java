package com.jfeat.am.module.product.services.domain.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.dao.QueryTrialDao;
import com.jfeat.am.module.product.services.domain.model.TrialRecord;
import com.jfeat.am.module.product.services.domain.service.ProductService;
import com.jfeat.am.module.product.services.domain.service.TrialOverModelService;
import com.jfeat.am.module.product.services.gen.crud.model.TrialModel;
import com.jfeat.am.module.product.services.gen.crud.service.impl.CRUDTrialOverModelServiceImpl;
import com.jfeat.am.module.product.services.gen.persistence.dao.TrialImageMapper;
import com.jfeat.am.module.product.services.gen.persistence.model.Product;
import com.jfeat.am.module.product.services.gen.persistence.model.Trial;
import com.jfeat.am.module.product.services.gen.persistence.model.TrialImage;
import com.jfeat.crud.plus.CRUD;
import org.springframework.stereotype.Service;

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
    ProductService productService;
    @Resource
    TrialImageMapper trialImageMapper;

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
        Product product = productService.retrieveMaster(trial.getProductId());
        trialModel.setProduct(product);

        List<TrialImage> trialImageList= trialImageMapper.selectList(new EntityWrapper<TrialImage>().eq("trial_id", trial.getId()));
        trialModel.setItems(trialImageList);
        return trialModel;
    }
}
