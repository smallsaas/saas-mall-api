package com.jfeat.am.module.wxTemplateMessage.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.wxTemplateMessage.services.domain.model.WechatTemplateMessageRecord;
import com.jfeat.am.module.wxTemplateMessage.services.gen.crud.service.CRUDWechatTemplateMessageOverModelService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface WechatTemplateMessageOverModelService extends CRUDWechatTemplateMessageOverModelService{
    List findWechatTemplateMessagePage(Page<WechatTemplateMessageRecord> page, WechatTemplateMessageRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}