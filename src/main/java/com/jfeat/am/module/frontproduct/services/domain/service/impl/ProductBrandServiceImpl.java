package com.jfeat.am.module.frontproduct.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.dao.QueryProductBrandDao;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductBrandRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.ProductBrandService;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.impl.CRUDProductBrandServiceImpl;
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
@Service("productBrandService")
public class ProductBrandServiceImpl extends CRUDProductBrandServiceImpl implements ProductBrandService {
    @Resource
    QueryProductBrandDao queryProductBrandDao;

    @Override
    public List findProductBrandPage(Page<ProductBrandRecord> page, ProductBrandRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryProductBrandDao.findProductBrandPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
