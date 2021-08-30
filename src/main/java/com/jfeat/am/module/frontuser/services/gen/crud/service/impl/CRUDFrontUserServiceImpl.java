package com.jfeat.am.module.frontuser.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.am.module.frontuser.services.gen.crud.service.CRUDFrontUserService;
import com.jfeat.am.module.frontuser.services.gen.persistence.dao.FrontUserMapper;
import com.jfeat.am.module.frontuser.services.gen.persistence.model.FrontUser;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDFrontUserService
 * @author Code Generator
 * @since 2019-08-22
 */

@Service
public class CRUDFrontUserServiceImpl extends CRUDServiceOnlyImpl<FrontUser> implements CRUDFrontUserService {





        @Resource
        protected FrontUserMapper frontUserMapper;

        @Override
        protected BaseMapper<FrontUser> getMasterMapper() {
                return frontUserMapper;
        }







}


