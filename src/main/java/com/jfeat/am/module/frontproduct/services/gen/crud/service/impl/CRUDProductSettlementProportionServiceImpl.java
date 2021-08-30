package com.jfeat.am.module.frontproduct.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductSettlementProportion;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.ProductSettlementProportionMapper;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDProductSettlementProportionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDProductSettlementProportionService
 * @author Code Generator
 * @since 2019-07-25
 */

@Service
public class CRUDProductSettlementProportionServiceImpl  extends CRUDServiceOnlyImpl<ProductSettlementProportion> implements CRUDProductSettlementProportionService {





        @Resource
        protected ProductSettlementProportionMapper productSettlementProportionMapper;

        @Override
        protected BaseMapper<ProductSettlementProportion> getMasterMapper() {
                return productSettlementProportionMapper;
        }







}


