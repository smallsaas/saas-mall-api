package com.jfeat.am.module.product.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.dao.QueryProductPurchaseStrategyRelationDao;
import com.jfeat.am.module.product.services.domain.model.ProductPurchaseStrategyRelationRecord;
import com.jfeat.am.module.product.services.domain.service.ProductPurchaseStrategyRelationService;
import com.jfeat.am.module.product.services.gen.crud.service.impl.CRUDProductPurchaseStrategyRelationServiceImpl;
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
@Service("productPurchaseStrategyRelationService")
public class ProductPurchaseStrategyRelationServiceImpl extends CRUDProductPurchaseStrategyRelationServiceImpl implements ProductPurchaseStrategyRelationService {
    @Resource
    QueryProductPurchaseStrategyRelationDao queryProductPurchaseStrategyRelationDao;

    @Override
    public List findProductPurchaseStrategyRelationPage(Page<ProductPurchaseStrategyRelationRecord> page, ProductPurchaseStrategyRelationRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryProductPurchaseStrategyRelationDao.findProductPurchaseStrategyRelationPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
