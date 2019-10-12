package com.jfeat.am.module.alliance.services.domain.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.alliance.services.domain.dao.QueryAllianceDao;
import com.jfeat.am.module.alliance.services.domain.model.AllianceRecord;
import com.jfeat.am.module.alliance.services.domain.service.AllianceService;
import com.jfeat.am.module.alliance.services.gen.crud.service.impl.CRUDAllianceServiceImpl;
import com.jfeat.am.module.alliance.services.gen.persistence.model.Alliance;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.rmi.ServerError;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */
@Service("allianceService")
public class AllianceServiceImpl extends CRUDAllianceServiceImpl implements AllianceService {
    @Resource
    QueryAllianceDao queryAllianceDao;

    @Override
    public List findAlliancePage(Page<AllianceRecord> page, AllianceRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryAllianceDao.findAlliancePage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }

    @Override
    public Integer changeStatus(Long id) {
        Alliance alliance = queryAllianceDao.selectById(id);
        if(alliance==null){
            throw new RuntimeException("该盟友不存在");
        }
        if(alliance.getAllianceStatus().equals(1)){
            alliance.setAllianceStatus(0);
        }else {
            alliance.setAllianceStatus(1);
        }
        return queryAllianceDao.updateById(alliance);
    }

    @Override
    public Integer changAmount(Long id, BigDecimal allianceStoreAmount) {
        Alliance alliance=queryAllianceDao.selectById(id);
        if(allianceStoreAmount==null){
            throw new RuntimeException("allianceStoreAmount 参数为空");
        }
        if(alliance==null){
            throw new RuntimeException("该盟友不存在");
        }
        alliance.setAllianceStoreAmount(allianceStoreAmount);
        return queryAllianceDao.updateById(alliance);
    }

    @Override
    public Map<String,Object> findAllianceRecommendationDiagram(Long id) {
        Alliance alliance = queryAllianceDao.selectById(id);
        if(alliance==null){
            throw new RuntimeException("该盟友不存在");
        }
        Alliance up = queryAllianceDao.selectById(alliance.getInvitorAllianceId());
        List<Alliance> down = queryAllianceDao.selectList(new Condition().eq("invitor_alliance_id",id));
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("up",up);
        map.put("down",down);
        return map;
    }
}
