package com.jfeat.am.module.wxTemplateMessage.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.wxTemplateMessage.services.domain.dao.QueryWechatTemplateMessageDao;
import com.jfeat.am.module.wxTemplateMessage.services.domain.model.WechatTemplateMessageRecord;
import com.jfeat.am.module.wxTemplateMessage.services.domain.service.WechatTemplateMessageOverModelService;
import com.jfeat.am.module.wxTemplateMessage.services.gen.crud.service.impl.CRUDWechatTemplateMessageOverModelServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */
@Service("wechatTemplateMessageService")
public class WechatTemplateMessageOverModelServiceImpl extends CRUDWechatTemplateMessageOverModelServiceImpl implements WechatTemplateMessageOverModelService {
    @Resource
    QueryWechatTemplateMessageDao queryWechatTemplateMessageDao;

    @Override
    public List findWechatTemplateMessagePage(Page<WechatTemplateMessageRecord> page, WechatTemplateMessageRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryWechatTemplateMessageDao.findWechatTemplateMessagePage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
