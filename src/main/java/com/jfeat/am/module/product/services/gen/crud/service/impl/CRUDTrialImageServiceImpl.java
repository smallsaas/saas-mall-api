package com.jfeat.am.module.product.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDTrialImageService;
import com.jfeat.am.module.product.services.gen.persistence.dao.TrialImageMapper;
import com.jfeat.am.module.product.services.gen.persistence.model.TrialImage;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDTrialImageService
 * @author Code Generator
 * @since 2019-08-02
 */

@Service
public class CRUDTrialImageServiceImpl extends CRUDServiceOnlyImpl<TrialImage> implements CRUDTrialImageService {







    @Resource
    protected TrialImageMapper trialImageMapper;

    @Override
    protected BaseMapper<TrialImage> getMasterMapper() {
         return trialImageMapper;
    }





}


