package com.jfeat.am.module.configmanagement.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.configmanagement.services.gen.persistence.model.Config;
import com.jfeat.am.module.configmanagement.services.gen.persistence.dao.ConfigMapper;
import com.jfeat.am.module.configmanagement.services.gen.persistence.dao.ConfigMapper;
import com.jfeat.am.module.configmanagement.services.gen.persistence.model.Config;
import com.jfeat.am.module.configmanagement.services.gen.crud.service.CRUDConfigOverModelService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDConfigOverModelService
 * @author Code Generator
 * @since 2019-08-13
 */

@Service
public class CRUDConfigOverModelServiceImpl  extends CRUDServiceOnlyImpl<Config> implements CRUDConfigOverModelService {







    @Resource
    protected ConfigMapper configMapper;

    @Override
    protected BaseMapper<Config> getMasterMapper() {
         return configMapper;
    }





}


