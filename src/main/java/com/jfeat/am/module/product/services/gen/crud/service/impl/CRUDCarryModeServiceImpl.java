package com.jfeat.am.module.product.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.product.services.gen.persistence.model.CarryMode;
import com.jfeat.am.module.product.services.gen.persistence.dao.CarryModeMapper;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDCarryModeService;
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


