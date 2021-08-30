package com.jfeat.am.module.order.services.domain.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.order.services.domain.dao.QueryExpressDao;
import com.jfeat.am.module.order.services.domain.model.ExpressRecord;
import com.jfeat.am.module.order.services.domain.service.ExpressService;
import com.jfeat.am.module.order.services.gen.crud.service.impl.CRUDExpressServiceImpl;
import com.jfeat.am.module.order.services.gen.persistence.model.Express;
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
@Service("expressService")
public class ExpressServiceImpl extends CRUDExpressServiceImpl implements ExpressService {
    @Resource
    QueryExpressDao queryExpressDao;

    @Override
    public List findExpressPage(Page<ExpressRecord> page, ExpressRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryExpressDao.findExpressPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }

    @Override
    public Integer updateIsDefault() {
        Integer result=0;
        Express entity=new Express();
        entity.setIsDefault(0);
        result=queryExpressDao.update(entity,new QueryWrapper<Express>().eq("is_default",1));
        return result;
    }
}
