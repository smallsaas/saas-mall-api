package com.jfeat.am.module.product.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.dao.QueryProductTagRelationDao;
import com.jfeat.am.module.product.services.domain.model.ProductTagRelationRecord;
import com.jfeat.am.module.product.services.domain.service.ProductTagRelationService;
import com.jfeat.am.module.product.services.gen.crud.service.impl.CRUDProductTagRelationServiceImpl;
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
@Service("productTagRelationService")
public class ProductTagRelationServiceImpl extends CRUDProductTagRelationServiceImpl implements ProductTagRelationService {
    @Resource
    QueryProductTagRelationDao queryProductTagRelationDao;

    @Override
    public List findProductTagRelationPage(Page<ProductTagRelationRecord> page, ProductTagRelationRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryProductTagRelationDao.findProductTagRelationPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
