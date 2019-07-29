package com.jfeat.am.module.product.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.dao.QueryProductTagDao;
import com.jfeat.am.module.product.services.domain.model.ProductTagRecord;
import com.jfeat.am.module.product.services.domain.service.ProductTagService;
import com.jfeat.am.module.product.services.gen.crud.service.impl.CRUDProductTagServiceImpl;
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
@Service("productTagService")
public class ProductTagServiceImpl extends CRUDProductTagServiceImpl implements ProductTagService {
    @Resource
    QueryProductTagDao queryProductTagDao;

    @Override
    public List findProductTagPage(Page<ProductTagRecord> page, ProductTagRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryProductTagDao.findProductTagPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
