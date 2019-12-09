package com.jfeat.am.module.frontproduct.services.domain.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.dao.QueryFareTemplateDao;
import com.jfeat.am.module.frontproduct.services.domain.model.FareTemplateModel;
import com.jfeat.am.module.frontproduct.services.domain.model.FareTemplatePcd;
import com.jfeat.am.module.frontproduct.services.domain.model.FareTemplateRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.CarryModeService;
import com.jfeat.am.module.frontproduct.services.domain.service.FareTemplateService;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.impl.CRUDFareTemplateServiceImpl;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.CarryModeMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.CarryMode;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FareTemplate;
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
@Service("fareTemplateService")
public class FareTemplateServiceImpl extends CRUDFareTemplateServiceImpl implements FareTemplateService {
    @Resource
    QueryFareTemplateDao queryFareTemplateDao;
    @Resource
    CarryModeService carryModeService;
    @Resource
    CarryModeMapper carryModeMapper;

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
        List<CarryMode> carryModeList = entity.getItems();
        if(!CollectionUtils.isEmpty(carryModeList)){
            for(CarryMode carryMode : carryModeList){
                carryMode.setFareId(entity.getId());
                affected += carryModeService.createMaster(carryMode);
            }
        }
        return affected;
    }

    @Override
    public FareTemplateModel getFareTemplate(Long id) {
        FareTemplate fareTemplate = this.retrieveMaster(id);
        FareTemplateModel fareTemplateModel = CRUD.castObject(fareTemplate, FareTemplateModel.class);
        List<CarryMode> carryModeList = carryModeMapper.selectList(new EntityWrapper<CarryMode>().eq("fare_id", id));
        fareTemplateModel.setItems(carryModeList);
        return fareTemplateModel;
    }

    @Override
    @Transactional
    public Integer updateFareTemplate(FareTemplateModel entity) {
        int affected = 0;
        affected += this.updateMaster(entity,false);

        affected += carryModeMapper.delete(new EntityWrapper<CarryMode>().eq("fare_id",entity.getId()));
        List<CarryMode> carryModeList = entity.getItems();
        if(!CollectionUtils.isEmpty(carryModeList)){
            for(CarryMode carryMode : carryModeList){
                carryMode.setFareId(entity.getId());
                affected += carryModeService.createMaster(carryMode);
            }
        }
        return affected;
    }

    @Override
    public List<FareTemplatePcd> ShopAddrToShopAddrList(String shopAddr,String addrIds,Long id) {

        String addrs[]= shopAddr.split(",");
        String ids[]= addrIds.split(",");
        List<FareTemplatePcd> fareTemplatePcdList=new ArrayList<>();
        //todo if ids ==null
        if(addrs!=null&&addrs.length>0){
            for (int i=0;i<addrs.length;i++) {
                FareTemplatePcd fareTemplatePcd=new FareTemplatePcd();
                fareTemplatePcd.setName(addrs[i]);
                fareTemplatePcd.setId(Long.parseLong(ids[i]));
                fareTemplatePcdList.add(fareTemplatePcd);

            }
        }


        return fareTemplatePcdList;
    }


    @Override
    public FareTemplate ShopAddrListToShopAddr(List<FareTemplatePcd> shopAddrList) {
        StringBuilder shopAddr=null;
        StringBuilder addrIds=null;
        //拼接字符串 广东,广东-广州
        if(shopAddrList!=null&&shopAddrList.size()>0){
            for (FareTemplatePcd fareTemplatePcd:shopAddrList) {
                shopAddr.append(fareTemplatePcd.getName());
                shopAddr.append(",");
                addrIds.append(fareTemplatePcd.getId());
                addrIds.append(",");
            }
            //大于1 去掉尾部“，”
            if(shopAddrList.size()>1){
                shopAddr.deleteCharAt(shopAddr.length()-1);
                addrIds.deleteCharAt(shopAddr.length()-1);
            }

        }
        //封装对象返回
        FareTemplate fareTemplate=new FareTemplate();
        fareTemplate.setAddrids(addrIds.toString());
        fareTemplate.setShopAddr(shopAddr.toString());

        return fareTemplate;
    }
}
