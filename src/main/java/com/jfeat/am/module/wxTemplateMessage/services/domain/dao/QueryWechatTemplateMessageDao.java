package com.jfeat.am.module.wxTemplateMessage.services.domain.dao;

import com.jfeat.am.module.wxTemplateMessage.services.domain.model.WechatTemplateMessageRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.wxTemplateMessage.services.gen.persistence.model.WechatTemplateMessage;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-08-21
 */
public interface QueryWechatTemplateMessageDao extends BaseMapper<WechatTemplateMessage> {
    List<WechatTemplateMessageRecord> findWechatTemplateMessagePage(Page<WechatTemplateMessageRecord> page, @Param("record") WechatTemplateMessageRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}