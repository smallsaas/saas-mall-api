package com.jfeat.am.module.frontproduct.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDFrontProductTagService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.FrontProductTagMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProductTag;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDFrontProductTagService
 * @author Code Generator
 * @since 2019-07-25
 */

@Service
public class CRUDFrontProductTagServiceImpl extends CRUDServiceOnlyImpl<FrontProductTag> implements CRUDFrontProductTagService {





        @Resource
        protected FrontProductTagMapper frontProductTagMapper;

        @Override
        protected BaseMapper<FrontProductTag> getMasterMapper() {
                return frontProductTagMapper;
        }







}


