package com.jfeat.am.module.alliance.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.alliance.services.domain.dao.QueryAllianceDao;
import com.jfeat.am.module.alliance.services.domain.model.AllianceRecord;
import com.jfeat.am.module.alliance.services.domain.service.AllianceService;
import com.jfeat.am.module.alliance.services.gen.crud.service.impl.CRUDAllianceServiceImpl;
import com.jfeat.am.module.alliance.services.gen.persistence.model.Alliance;
import org.springframework.stereotype.Service;

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



    public Integer changeStatus(Long id){

        Alliance alliance = allianceMapper.selectById(id);
        Integer allianceStatus = alliance.getAllianceStatus();
        if(allianceStatus.equals(1)){
            alliance.setAllianceStatus(0);
        }else {
            alliance.setAllianceStatus(1);
        }
        return  allianceMapper.updateById(alliance);

    }
}
