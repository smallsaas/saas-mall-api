package com.jfeat.am.module.wxTemplateMessage.services.domain.dao;

import com.jfeat.am.module.wxTemplateMessage.services.domain.model.WechatMessageTypePropRecord;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.wxTemplateMessage.services.gen.persistence.model.WechatMessageTypeProp;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-08-21
 */
public interface QueryWechatMessageTypePropDao extends BaseMapper<WechatMessageTypeProp> {
    List<WechatMessageTypePropRecord> findWechatMessageTypePropPage(Page<WechatMessageTypePropRecord> page, @Param("record") WechatMessageTypePropRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}