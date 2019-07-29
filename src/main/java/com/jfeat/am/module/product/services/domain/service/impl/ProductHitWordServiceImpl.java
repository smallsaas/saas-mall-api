package com.jfeat.am.module.product.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.product.services.domain.dao.QueryProductHitWordDao;
import com.jfeat.am.module.product.services.domain.model.ProductHitWordRecord;
import com.jfeat.am.module.product.services.domain.service.ProductHitWordService;
import com.jfeat.am.module.product.services.gen.crud.service.impl.CRUDProductHitWordServiceImpl;
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
@Service("productHitWordService")
public class ProductHitWordServiceImpl extends CRUDProductHitWordServiceImpl implements ProductHitWordService {
    @Resource
    QueryProductHitWordDao queryProductHitWordDao;

    @Override
    public List findProductHitWordPage(Page<ProductHitWordRecord> page, ProductHitWordRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryProductHitWordDao.findProductHitWordPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
