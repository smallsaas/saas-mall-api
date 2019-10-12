package com.jfeat.am.module.alliance.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.alliance.services.gen.persistence.model.Alliance;
import com.jfeat.am.module.alliance.services.gen.persistence.dao.AllianceMapper;
import com.jfeat.am.module.alliance.services.gen.crud.service.CRUDAllianceService;
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
 *CRUDAllianceService
 * @author Code Generator
 * @since 2019-10-12
 */

@Service
public class CRUDAllianceServiceImpl  extends CRUDServiceOnlyImpl<Alliance> implements CRUDAllianceService {





        @Resource
        protected AllianceMapper allianceMapper;

        @Override
        protected BaseMapper<Alliance> getMasterMapper() {
                return allianceMapper;
        }







}


