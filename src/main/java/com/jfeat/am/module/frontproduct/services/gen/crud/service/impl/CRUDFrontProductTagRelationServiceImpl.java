package com.jfeat.am.module.frontproduct.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDFrontProductTagRelationService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.FrontProductTagRelationMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProductTagRelation;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDFrontProductTagRelationService
 * @author Code Generator
 * @since 2019-07-25
 */

@Service
public class CRUDFrontProductTagRelationServiceImpl extends CRUDServiceOnlyImpl<FrontProductTagRelation> implements CRUDFrontProductTagRelationService {





        @Resource
        protected FrontProductTagRelationMapper frontProductTagRelationMapper;

        @Override
        protected BaseMapper<FrontProductTagRelation> getMasterMapper() {
                return frontProductTagRelationMapper;
        }







}


