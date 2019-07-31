package com.jfeat.am.module.order.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.order.services.domain.dao.QueryOrderItemRewardDao;
import com.jfeat.am.module.order.services.domain.model.OrderItemRewardRecord;
import com.jfeat.am.module.order.services.domain.service.OrderItemRewardService;
import com.jfeat.am.module.order.services.gen.crud.service.impl.CRUDOrderItemRewardServiceImpl;
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
@Service("orderItemRewardService")
public class OrderItemRewardServiceImpl extends CRUDOrderItemRewardServiceImpl implements OrderItemRewardService {
    @Resource
    QueryOrderItemRewardDao queryOrderItemRewardDao;

    @Override
    public List findOrderItemRewardPage(Page<OrderItemRewardRecord> page, OrderItemRewardRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryOrderItemRewardDao.findOrderItemRewardPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
