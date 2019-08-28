package com.jfeat.am.module.frontproduct.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.dao.QueryProductPropertyDao;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductPropertyRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.ProductPropertyService;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.impl.CRUDProductPropertyServiceImpl;
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
@Service("productPropertyService")
public class ProductPropertyServiceImpl extends CRUDProductPropertyServiceImpl implements ProductPropertyService {
    @Resource
    QueryProductPropertyDao queryProductPropertyDao;

    @Override
    public List findProductPropertyPage(Page<ProductPropertyRecord> page, ProductPropertyRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryProductPropertyDao.findProductPropertyPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
