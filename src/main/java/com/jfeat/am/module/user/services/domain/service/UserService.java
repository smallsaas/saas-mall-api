package com.jfeat.am.module.user.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.user.services.domain.model.UserRecord;
import com.jfeat.am.module.user.services.gen.crud.service.CRUDUserService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface UserService extends CRUDUserService{
    List findUserPage(Page<UserRecord> page, UserRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}