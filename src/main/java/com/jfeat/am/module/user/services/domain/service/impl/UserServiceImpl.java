package com.jfeat.am.module.user.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.user.services.domain.dao.QueryUserDao;
import com.jfeat.am.module.user.services.domain.model.UserRecord;
import com.jfeat.am.module.user.services.domain.service.UserService;
import com.jfeat.am.module.user.services.gen.crud.service.impl.CRUDUserServiceImpl;
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
@Service("userService")
public class UserServiceImpl extends CRUDUserServiceImpl implements UserService {
    @Resource
    QueryUserDao queryUserDao;

    @Override
    public List findUserPage(Page<UserRecord> page, UserRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryUserDao.findUserPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
