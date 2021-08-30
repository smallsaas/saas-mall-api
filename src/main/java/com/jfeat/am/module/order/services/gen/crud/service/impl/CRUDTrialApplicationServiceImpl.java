package com.jfeat.am.module.order.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.am.module.order.services.gen.persistence.model.TrialApplication;
import com.jfeat.am.module.order.services.gen.persistence.dao.TrialApplicationMapper;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDTrialApplicationService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDTrialApplicationService
 * @author Code Generator
 * @since 2019-08-02
 */

@Service
public class CRUDTrialApplicationServiceImpl  extends CRUDServiceOnlyImpl<TrialApplication> implements CRUDTrialApplicationService {





        @Resource
        protected TrialApplicationMapper trialApplicationMapper;

        @Override
        protected BaseMapper<TrialApplication> getMasterMapper() {
                return trialApplicationMapper;
        }







}


