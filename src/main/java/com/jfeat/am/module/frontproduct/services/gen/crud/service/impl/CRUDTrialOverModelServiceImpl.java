package com.jfeat.am.module.frontproduct.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.Trial;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.TrialMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.TrialImageMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.TrialImage;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDTrialOverModelService;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOverModelImpl;
import com.jfeat.am.module.frontproduct.services.gen.crud.model.TrialModel;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDTrialOverModelService
 * @author Code Generator
 * @since 2019-08-02
 */

@Service
public class CRUDTrialOverModelServiceImpl  extends CRUDServiceOverModelImpl<Trial,TrialModel> implements CRUDTrialOverModelService {









    @Resource
    protected TrialMapper trialMapper;

    
    @Override
    protected BaseMapper<Trial> getMasterMapper() {
        return trialMapper;
    }

    @Override
    protected Class<Trial> masterClassName() {
        return Trial.class;
    }

    @Override
    protected Class<TrialModel> modelClassName() {
        return TrialModel.class;
    }




    
    @Resource
    private TrialImageMapper trialImageMapper;
        
    private final static String trialImageFieldName = "trial_id";
    
        private final static String trialImageKeyName = "items";
    
    
    @Override
    protected String[] slaveFieldNames() {
        return new String[]{
                                             trialImageKeyName
                             
                };
    }

    @Override
    protected FIELD onSlaveFieldItem(String field) {
                        if (field.compareTo(trialImageKeyName) == 0) {
                FIELD _field = new FIELD();
            _field.setItemKeyName(field);
            _field.setItemFieldName(trialImageFieldName);
            _field.setItemClassName(TrialImage.class);
            _field.setItemMapper(trialImageMapper);
                                    
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


