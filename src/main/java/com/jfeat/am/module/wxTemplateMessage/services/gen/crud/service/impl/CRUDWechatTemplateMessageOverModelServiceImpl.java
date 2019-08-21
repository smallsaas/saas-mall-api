package com.jfeat.am.module.wxTemplateMessage.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.wxTemplateMessage.services.gen.persistence.model.WechatTemplateMessage;
import com.jfeat.am.module.wxTemplateMessage.services.gen.persistence.dao.WechatTemplateMessageMapper;
import com.jfeat.am.module.wxTemplateMessage.services.gen.persistence.dao.WechatMessageTypePropMapper;
import com.jfeat.am.module.wxTemplateMessage.services.gen.persistence.model.WechatMessageTypeProp;
import com.jfeat.am.module.wxTemplateMessage.services.gen.crud.service.CRUDWechatTemplateMessageOverModelService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOverModelImpl;
import com.jfeat.am.module.wxTemplateMessage.services.gen.crud.model.WechatTemplateMessageModel;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDWechatTemplateMessageOverModelService
 * @author Code Generator
 * @since 2019-08-21
 */

@Service
public class CRUDWechatTemplateMessageOverModelServiceImpl  extends CRUDServiceOverModelImpl<WechatTemplateMessage,WechatTemplateMessageModel> implements CRUDWechatTemplateMessageOverModelService {









    @Resource
    protected WechatTemplateMessageMapper wechatTemplateMessageMapper;

    
    @Override
    protected BaseMapper<WechatTemplateMessage> getMasterMapper() {
        return wechatTemplateMessageMapper;
    }

    @Override
    protected Class<WechatTemplateMessage> masterClassName() {
        return WechatTemplateMessage.class;
    }

    @Override
    protected Class<WechatTemplateMessageModel> modelClassName() {
        return WechatTemplateMessageModel.class;
    }




    
    @Resource
    private WechatMessageTypePropMapper wechatMessageTypePropMapper;
        
    private final static String wechatMessageTypePropFieldName = "message_id";
    
        private final static String wechatMessageTypePropKeyName = "items";
    
    
    @Override
    protected String[] slaveFieldNames() {
        return new String[]{
                                             wechatMessageTypePropKeyName
                             
                };
    }

    @Override
    protected FIELD onSlaveFieldItem(String field) {
                        if (field.compareTo(wechatMessageTypePropKeyName) == 0) {
                FIELD _field = new FIELD();
            _field.setItemKeyName(field);
            _field.setItemFieldName(wechatMessageTypePropFieldName);
            _field.setItemClassName(WechatMessageTypeProp.class);
            _field.setItemMapper(wechatMessageTypePropMapper);
                                    
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


