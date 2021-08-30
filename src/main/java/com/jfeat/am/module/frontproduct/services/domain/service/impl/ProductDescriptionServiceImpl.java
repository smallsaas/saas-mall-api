package com.jfeat.am.module.frontproduct.services.domain.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.frontproduct.services.domain.dao.QueryProductDescriptionDao;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductDescriptionRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.ProductDescriptionService;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.impl.CRUDProductDescriptionServiceImpl;
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
@Service("productDescriptionService")
public class ProductDescriptionServiceImpl extends CRUDProductDescriptionServiceImpl implements ProductDescriptionService {
    @Resource
    QueryProductDescriptionDao queryProductDescriptionDao;

    @Override
    public List findProductDescriptionPage(Page<ProductDescriptionRecord> page, ProductDescriptionRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryProductDescriptionDao.findProductDescriptionPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
