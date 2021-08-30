package com.jfeat.am.module.frontproduct.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FareTemplate;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.FareTemplateMapper;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDFareTemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDFareTemplateService
 * @author Code Generator
 * @since 2019-07-31
 */

@Service
public class CRUDFareTemplateServiceImpl  extends CRUDServiceOnlyImpl<FareTemplate> implements CRUDFareTemplateService {





        @Resource
        protected FareTemplateMapper fareTemplateMapper;

        @Override
        protected BaseMapper<FareTemplate> getMasterMapper() {
                return fareTemplateMapper;
        }







}


