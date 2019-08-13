package com.jfeat.am.module.configmanagement.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.configmanagement.services.gen.persistence.model.ConfigGroup;
import com.jfeat.am.module.configmanagement.services.gen.persistence.dao.ConfigGroupMapper;
import com.jfeat.am.module.configmanagement.services.gen.persistence.dao.ConfigMapper;
import com.jfeat.am.module.configmanagement.services.gen.persistence.model.Config;
import com.jfeat.am.module.configmanagement.services.gen.crud.service.CRUDConfigGroupOverModelService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOverModelImpl;
import com.jfeat.am.module.configmanagement.services.gen.crud.model.ConfigGroupModel;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDConfigGroupOverModelService
 * @author Code Generator
 * @since 2019-08-13
 */

@Service
public class CRUDConfigGroupOverModelServiceImpl  extends CRUDServiceOverModelImpl<ConfigGroup,ConfigGroupModel> implements CRUDConfigGroupOverModelService {









    @Resource
    protected ConfigGroupMapper configGroupMapper;

    
    @Override
    protected BaseMapper<ConfigGroup> getMasterMapper() {
        return configGroupMapper;
    }

    @Override
    protected Class<ConfigGroup> masterClassName() {
        return ConfigGroup.class;
    }

    @Override
    protected Class<ConfigGroupModel> modelClassName() {
        return ConfigGroupModel.class;
    }




    
    @Resource
    private ConfigMapper configMapper;
        
    private final static String configFieldName = "group_id";
    
        private final static String configKeyName = "items";
    
    
    @Override
    protected String[] slaveFieldNames() {
        return new String[]{
                                             configKeyName
                             
                };
    }

    @Override
    protected FIELD onSlaveFieldItem(String field) {
                        if (field.compareTo(configKeyName) == 0) {
                FIELD _field = new FIELD();
            _field.setItemKeyName(field);
            _field.setItemFieldName(configFieldName);
            _field.setItemClassName(Config.class);
            _field.setItemMapper(configMapper);
                                    
            return _field;
        }
        
        throw new BusinessException(BusinessCode.BadRequest);
    }


    @Override
    protected String[] childFieldNames() {
        return new String[]{
                                };
    }

    @Override
    protected FIELD onChildFieldItem(String field) {
                
        throw new BusinessException(BusinessCode.BadRequest);
    }




}


