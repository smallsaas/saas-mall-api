package com.jfeat.am.module.order.services.domain.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.order.services.domain.dao.QueryOrderItemDao;
import com.jfeat.am.module.order.services.domain.model.OrderItemRecord;
import com.jfeat.am.module.order.services.domain.model.OrderModel;
import com.jfeat.am.module.order.services.domain.model.OrderRecord;
import com.jfeat.am.module.order.services.domain.service.OrderItemService;
import com.jfeat.am.module.order.services.domain.service.OrderService;
import com.jfeat.am.module.order.services.gen.crud.service.impl.CRUDOrderItemServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */
@Service("orderItemService")
public class OrderItemServiceImpl extends CRUDOrderItemServiceImpl implements OrderItemService {

    @Resource
    QueryOrderItemDao queryOrderItemDao;

    @Resource
    OrderService orderService;

    @Override
    public List findOrderItemPage(Page<OrderItemRecord> page, OrderItemRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryOrderItemDao.findOrderItemPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }

    @Override
    public Page<OrderItemRecord> listOrderItem(Page<OrderItemRecord> page, OrderItemRecord orderItemRecord) {

        return queryOrderItemDao.listOrderItem(page,orderItemRecord);
    }

    /**
     * 查询t_end_user表
     * @param userId 用户id
     * @return
     */
    @Override
    public HashMap<String,Objects> getUser(Integer userId) {
        return queryOrderItemDao.getUser(userId);
    }

    /**
     * 分页查询所有的商品订单
     *
     * @param page myBatisPlus分页对象
     * @return myBatisPlus分页对象
     */
    @Override
    public Page<OrderItemRecord> getOrderItemPage(Page<OrderItemRecord> page,Long productId) {
        return queryOrderItemDao.getOrderItemPage(page,productId);
    }

    /**
     * 分页-获取指定用户的商品订单
     *
     * @param page   分页对象
     * @param userId 用户id
     * @return 商品列表
     */
    @Override
    public Page<OrderItemRecord> getOrderItemPage(Page<OrderItemRecord> page, Integer userId) {
        return queryOrderItemDao.getOrderItemByUserIdPage(page,userId);
    }

    /**
     * 从已有订单表中获取商品分类
     *
     * @return
     */
    @Override
    public List<HashMap<String,Objects>> getProducts() {

        return queryOrderItemDao.getProducts();
    }

}
