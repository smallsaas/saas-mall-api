package com.jfeat.am.module.store.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.store.services.gen.persistence.model.Warehouse;
import com.jfeat.am.module.store.services.gen.persistence.dao.WarehouseMapper;
import com.jfeat.am.module.store.services.gen.crud.service.CRUDWarehouseService;
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
 *CRUDWarehouseService
 * @author Code Generator
 * @since 2019-08-08
 */

@Service
public class CRUDWarehouseServiceImpl  extends CRUDServiceOnlyImpl<Warehouse> implements CRUDWarehouseService {





        @Resource
        protected WarehouseMapper warehouseMapper;

        @Override
        protected BaseMapper<Warehouse> getMasterMapper() {
                return warehouseMapper;
        }







}


