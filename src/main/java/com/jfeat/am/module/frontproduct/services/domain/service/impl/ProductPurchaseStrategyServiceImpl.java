package com.jfeat.am.module.frontproduct.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.dao.QueryProductPurchaseStrategyDao;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductPurchaseStrategyRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.ProductPurchaseStrategyService;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.impl.CRUDProductPurchaseStrategyServiceImpl;
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
@Service("productPurchaseStrategyService")
public class ProductPurchaseStrategyServiceImpl extends CRUDProductPurchaseStrategyServiceImpl implements ProductPurchaseStrategyService {
    @Resource
    QueryProductPurchaseStrategyDao queryProductPurchaseStrategyDao;

    @Override
    public List findProductPurchaseStrategyPage(Page<ProductPurchaseStrategyRecord> page, ProductPurchaseStrategyRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryProductPurchaseStrategyDao.findProductPurchaseStrategyPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
