package com.jfeat.am.module.order.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderStatistic;
import com.jfeat.am.module.order.services.gen.persistence.dao.OrderStatisticMapper;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDOrderStatisticService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDOrderStatisticService
 * @author Code Generator
 * @since 2019-07-31
 */

@Service
public class CRUDOrderStatisticServiceImpl  extends CRUDServiceOnlyImpl<OrderStatistic> implements CRUDOrderStatisticService {





        @Resource
        protected OrderStatisticMapper orderStatisticMapper;

        @Override
        protected BaseMapper<OrderStatistic> getMasterMapper() {
                return orderStatisticMapper;
        }







}

