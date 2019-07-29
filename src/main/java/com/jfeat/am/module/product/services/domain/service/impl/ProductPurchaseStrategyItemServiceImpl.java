package com.jfeat.am.module.product.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.dao.QueryProductPurchaseStrategyItemDao;
import com.jfeat.am.module.product.services.domain.model.ProductPurchaseStrategyItemRecord;
import com.jfeat.am.module.product.services.domain.service.ProductPurchaseStrategyItemService;
import com.jfeat.am.module.product.services.gen.crud.service.impl.CRUDProductPurchaseStrategyItemServiceImpl;
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
@Service("productPurchaseStrategyItemService")
public class ProductPurchaseStrategyItemServiceImpl extends CRUDProductPurchaseStrategyItemServiceImpl implements ProductPurchaseStrategyItemService {
    @Resource
    QueryProductPurchaseStrategyItemDao queryProductPurchaseStrategyItemDao;

    @Override
    public List findProductPurchaseStrategyItemPage(Page<ProductPurchaseStrategyItemRecord> page, ProductPurchaseStrategyItemRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryProductPurchaseStrategyItemDao.findProductPurchaseStrategyItemPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
