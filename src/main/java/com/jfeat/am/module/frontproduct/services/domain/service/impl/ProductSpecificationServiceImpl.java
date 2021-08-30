package com.jfeat.am.module.frontproduct.services.domain.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.frontproduct.services.domain.dao.QueryProductSpecificationDao;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductSpecificationRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.ProductSpecificationService;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.impl.CRUDProductSpecificationServiceImpl;
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
@Service("productSpecificationService")
public class ProductSpecificationServiceImpl extends CRUDProductSpecificationServiceImpl implements ProductSpecificationService {
    @Resource
    QueryProductSpecificationDao queryProductSpecificationDao;

    @Override
    public List findProductSpecificationPage(Page<ProductSpecificationRecord> page, ProductSpecificationRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryProductSpecificationDao.findProductSpecificationPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
