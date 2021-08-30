package com.jfeat.am.module.wxTemplateMessage.services.domain.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.wxTemplateMessage.services.domain.dao.QueryWechatMessageTypePropDao;
import com.jfeat.am.module.wxTemplateMessage.services.domain.model.WechatMessageTypePropRecord;
import com.jfeat.am.module.wxTemplateMessage.services.domain.service.WechatMessageTypePropService;
import com.jfeat.am.module.wxTemplateMessage.services.gen.crud.service.impl.CRUDWechatMessageTypePropOverModelServiceImpl;
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
@Service("wechatMessageTypePropService")
public class WechatMessageTypePropServiceImpl extends CRUDWechatMessageTypePropOverModelServiceImpl implements WechatMessageTypePropService {
    @Resource
    QueryWechatMessageTypePropDao queryWechatMessageTypePropDao;

    @Override
    public List findWechatMessageTypePropPage(Page<WechatMessageTypePropRecord> page, WechatMessageTypePropRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryWechatMessageTypePropDao.findWechatMessageTypePropPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
