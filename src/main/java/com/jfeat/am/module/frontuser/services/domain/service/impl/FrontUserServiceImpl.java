package com.jfeat.am.module.frontuser.services.domain.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.frontuser.services.domain.dao.QueryFrontUserDao;
import com.jfeat.am.module.frontuser.services.domain.model.FrontUserRecord;
import com.jfeat.am.module.frontuser.services.domain.service.FrontUserService;
import com.jfeat.am.module.frontuser.services.gen.crud.service.impl.CRUDFrontUserServiceImpl;
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
@Service
public class FrontUserServiceImpl extends CRUDFrontUserServiceImpl implements FrontUserService {
    @Resource
    QueryFrontUserDao queryFrontUserDao;

    @Override
    public List findUserPage(Page<FrontUserRecord> page, FrontUserRecord record,
                             String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryFrontUserDao.findUserPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
