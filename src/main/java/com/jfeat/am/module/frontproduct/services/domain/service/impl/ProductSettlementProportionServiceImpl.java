package com.jfeat.am.module.frontproduct.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.dao.QueryProductSettlementProportionDao;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductSettlementProportionRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.ProductSettlementProportionService;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.impl.CRUDProductSettlementProportionServiceImpl;
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
@Service("productSettlementProportionService")
public class ProductSettlementProportionServiceImpl extends CRUDProductSettlementProportionServiceImpl implements ProductSettlementProportionService {
    @Resource
    QueryProductSettlementProportionDao queryProductSettlementProportionDao;

    @Override
    public List findProductSettlementProportionPage(Page<ProductSettlementProportionRecord> page, ProductSettlementProportionRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryProductSettlementProportionDao.findProductSettlementProportionPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
