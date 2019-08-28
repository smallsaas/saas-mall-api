package com.jfeat.am.module.frontproduct.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.dao.QueryProductCategoryPropertyDao;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductCategoryPropertyRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.ProductCategoryPropertyService;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.impl.CRUDProductCategoryPropertyServiceImpl;
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
@Service("productCategoryPropertyService")
public class ProductCategoryPropertyServiceImpl extends CRUDProductCategoryPropertyServiceImpl implements ProductCategoryPropertyService {
    @Resource
    QueryProductCategoryPropertyDao queryProductCategoryPropertyDao;

    @Override
    public List findProductCategoryPropertyPage(Page<ProductCategoryPropertyRecord> page, ProductCategoryPropertyRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryProductCategoryPropertyDao.findProductCategoryPropertyPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
