package com.jfeat.am.module.frontproduct.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.InclPostageProviso;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.InclPostageProvisoMapper;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDInclPostageProvisoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDInclPostageProvisoService
 * @author Code Generator
 * @since 2019-07-31
 */

@Service
public class CRUDInclPostageProvisoServiceImpl  extends CRUDServiceOnlyImpl<InclPostageProviso> implements CRUDInclPostageProvisoService {





        @Resource
        protected InclPostageProvisoMapper inclPostageProvisoMapper;

        @Override
        protected BaseMapper<InclPostageProviso> getMasterMapper() {
                return inclPostageProvisoMapper;
        }







}


