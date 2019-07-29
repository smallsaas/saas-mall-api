package com.jfeat.am.module.product.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.dao.QueryProductImageDao;
import com.jfeat.am.module.product.services.domain.model.ProductImageRecord;
import com.jfeat.am.module.product.services.domain.service.ProductImageService;
import com.jfeat.am.module.product.services.gen.crud.service.impl.CRUDProductImageServiceImpl;
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
@Service("productImageService")
public class ProductImageServiceImpl extends CRUDProductImageServiceImpl implements ProductImageService {
    @Resource
    QueryProductImageDao queryProductImageDao;

    @Override
    public List findProductImagePage(Page<ProductImageRecord> page, ProductImageRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryProductImageDao.findProductImagePage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
