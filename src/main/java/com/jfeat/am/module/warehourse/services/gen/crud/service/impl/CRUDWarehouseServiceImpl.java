package com.jfeat.am.module.warehourse.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.warehourse.services.gen.persistence.model.Warehouse;
import com.jfeat.am.module.warehourse.services.gen.persistence.dao.WarehouseMapper;
import com.jfeat.am.module.warehourse.services.gen.crud.service.CRUDWarehouseService;
import org.springframework.stereotype.Service;

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


