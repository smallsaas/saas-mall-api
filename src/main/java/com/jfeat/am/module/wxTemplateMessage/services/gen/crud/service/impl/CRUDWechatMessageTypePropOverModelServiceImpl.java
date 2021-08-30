package com.jfeat.am.module.wxTemplateMessage.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.am.module.wxTemplateMessage.services.gen.persistence.model.WechatMessageTypeProp;
import com.jfeat.am.module.wxTemplateMessage.services.gen.persistence.dao.WechatMessageTypePropMapper;
import com.jfeat.am.module.wxTemplateMessage.services.gen.crud.service.CRUDWechatMessageTypePropOverModelService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDWechatMessageTypePropOverModelService
 * @author Code Generator
 * @since 2019-08-21
 */

@Service
public class CRUDWechatMessageTypePropOverModelServiceImpl  extends CRUDServiceOnlyImpl<WechatMessageTypeProp> implements CRUDWechatMessageTypePropOverModelService {







    @Resource
    protected WechatMessageTypePropMapper wechatMessageTypePropMapper;

    @Override
    protected BaseMapper<WechatMessageTypeProp> getMasterMapper() {
         return wechatMessageTypePropMapper;
    }





}


