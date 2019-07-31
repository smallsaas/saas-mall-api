package com.jfeat.am.module.product.services.domain.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.dao.QueryFareTemplateDao;
import com.jfeat.am.module.product.services.domain.model.FareTemplateModel;
import com.jfeat.am.module.product.services.domain.model.FareTemplateRecord;
import com.jfeat.am.module.product.services.domain.service.FareTemplateService;
import com.jfeat.am.module.product.services.domain.service.InclPostageProvisoService;
import com.jfeat.am.module.product.services.gen.crud.service.impl.CRUDFareTemplateServiceImpl;
import com.jfeat.am.module.product.services.gen.persistence.dao.InclPostageProvisoMapper;
import com.jfeat.am.module.product.services.gen.persistence.model.FareTemplate;
import com.jfeat.am.module.product.services.gen.persistence.model.InclPostageProviso;
import com.jfeat.crud.plus.CRUD;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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
@Service("fareTemplateService")
public class FareTemplateServiceImpl extends CRUDFareTemplateServiceImpl implements FareTemplateService {
    @Resource
    QueryFareTemplateDao queryFareTemplateDao;
    @Resource
    InclPostageProvisoService inclPostageProvisoService;
    @Resource
    InclPostageProvisoMapper inclPostageProvisoMapper;

    @Override
    public List findFareTemplatePage(Page<FareTemplateRecord> page, FareTemplateRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryFareTemplateDao.findFareTemplatePage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }

    @Override
    @Transactional
    public Integer createFareTemplate(FareTemplateModel entity) {
        int affected = 0;
        affected += this.createMaster(entity);
        List<InclPostageProviso> inclPostageProvisoList = entity.getInclPostageProvisoList();
        if(!CollectionUtils.isEmpty(inclPostageProvisoList)){
            for(InclPostageProviso inclPostageProviso : inclPostageProvisoList){
                inclPostageProviso.setFareId(entity.getId());
                affected += inclPostageProvisoService.createMaster(inclPostageProviso);
            }
        }
        return affected;
    }

    @Override
    public FareTemplateModel getFareTemplate(Long id) {
        FareTemplate fareTemplate = this.retrieveMaster(id);
        FareTemplateModel fareTemplateModel = CRUD.castObject(fareTemplate, FareTemplateModel.class);
        List<InclPostageProviso> inclPostageProvisoList = inclPostageProvisoMapper.selectList(new EntityWrapper<InclPostageProviso>().eq("fare_id", id));
        fareTemplateModel.setInclPostageProvisoList(inclPostageProvisoList);
        return fareTemplateModel;
    }

    @Override
    @Transactional
    public Integer updateFareTemplate(FareTemplateModel entity) {
        int affected = 0;
        affected += this.updateMaster(entity,false);

        affected += inclPostageProvisoMapper.delete(new EntityWrapper<InclPostageProviso>().eq("fare_id",entity.getId()));
        List<InclPostageProviso> inclPostageProvisoList = entity.getInclPostageProvisoList();
        if(!CollectionUtils.isEmpty(inclPostageProvisoList)){
            for(InclPostageProviso inclPostageProviso : inclPostageProvisoList){
                inclPostageProviso.setFareId(entity.getId());
                affected += inclPostageProvisoService.createMaster(inclPostageProviso);
            }
        }
        return affected;
    }
}
