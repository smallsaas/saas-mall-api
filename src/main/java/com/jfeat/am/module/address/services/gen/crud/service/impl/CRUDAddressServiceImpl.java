package com.jfeat.am.module.address.services.gen.crud.service.impl;
// ServiceImpl start

            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.address.services.gen.persistence.model.Address;
import com.jfeat.am.module.address.services.gen.persistence.dao.AddressMapper;
import com.jfeat.am.module.address.services.gen.crud.service.CRUDAddressService;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDAddressService
 * @author Code generator
 * @since 2022-08-13
 */

@Service
public class CRUDAddressServiceImpl  extends CRUDServiceOnlyImpl<Address> implements CRUDAddressService {





        @Resource
        protected AddressMapper addressMapper;

        @Override
        protected BaseMapper<Address> getMasterMapper() {
                return addressMapper;
        }







}


