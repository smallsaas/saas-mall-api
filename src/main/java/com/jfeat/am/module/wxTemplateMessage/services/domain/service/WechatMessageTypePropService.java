package com.jfeat.am.module.wxTemplateMessage.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.wxTemplateMessage.services.domain.model.WechatMessageTypePropRecord;
import com.jfeat.am.module.wxTemplateMessage.services.gen.crud.service.CRUDWechatMessageTypePropOverModelService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface WechatMessageTypePropService extends CRUDWechatMessageTypePropOverModelService{
    List findWechatMessageTypePropPage(Page<WechatMessageTypePropRecord> page, WechatMessageTypePropRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}