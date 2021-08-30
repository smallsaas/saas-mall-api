package com.jfeat.am.module.frontproduct.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDCarryModeService;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.CarryModeMapper;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.CarryMode;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDCarryModeService
 * @author Code Generator
 * @since 2019-08-01
 */

@Service
public class CRUDCarryModeServiceImpl  extends CRUDServiceOnlyImpl<CarryMode> implements CRUDCarryModeService {





        @Resource
        protected CarryModeMapper carryModeMapper;

        @Override
        protected BaseMapper<CarryMode> getMasterMapper() {
                return carryModeMapper;
        }







}


