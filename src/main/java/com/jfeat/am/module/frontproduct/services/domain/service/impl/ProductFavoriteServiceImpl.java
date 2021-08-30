package com.jfeat.am.module.frontproduct.services.domain.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.frontproduct.services.domain.dao.QueryProductFavoriteDao;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductFavoriteRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.ProductFavoriteService;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.impl.CRUDProductFavoriteServiceImpl;
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
@Service("productFavoriteService")
public class ProductFavoriteServiceImpl extends CRUDProductFavoriteServiceImpl implements ProductFavoriteService {
    @Resource
    QueryProductFavoriteDao queryProductFavoriteDao;

    @Override
    public List findProductFavoritePage(Page<ProductFavoriteRecord> page, ProductFavoriteRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryProductFavoriteDao.findProductFavoritePage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
