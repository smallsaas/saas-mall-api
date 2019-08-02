package com.jfeat.am.module.order.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.order.services.gen.persistence.model.TrialApplication;
import com.jfeat.am.module.order.services.gen.persistence.dao.TrialApplicationMapper;
import com.jfeat.am.module.order.services.gen.crud.service.CRUDTrialApplicationService;
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


