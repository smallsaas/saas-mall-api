package com.jfeat.am.module.configmanagement.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.configmanagement.services.gen.persistence.model.MallConfigGroup;
import com.jfeat.am.module.configmanagement.services.gen.persistence.dao.MallConfigGroupMapper;
import com.jfeat.am.module.configmanagement.services.gen.persistence.dao.ConfigMapper;
import com.jfeat.am.module.configmanagement.services.gen.persistence.model.Config;
import com.jfeat.am.module.configmanagement.services.gen.crud.service.CRUDConfigGroupOverModelService;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOverModelImpl;
import com.jfeat.am.module.configmanagement.services.gen.crud.model.MallConfigGroupModel;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDConfigGroupOverModelService
 * @author Code Generator
 * @since 2019-08-13
 */

@Service
public class CRUDConfigGroupOverModelServiceImpl  extends CRUDServiceOverModelImpl<MallConfigGroup,MallConfigGroupModel> implements CRUDConfigGroupOverModelService {









    @Resource
    protected MallConfigGroupMapper mallConfigGroupMapper;

    
    @Override
    protected BaseMapper<MallConfigGroup> getMasterMapper() {
        return mallConfigGroupMapper;
    }

    @Override
    protected Class<MallConfigGroup> masterClassName() {
        return MallConfigGroup.class;
    }

    @Override
    protected Class<MallConfigGroupModel> modelClassName() {
        return MallConfigGroupModel.class;
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


