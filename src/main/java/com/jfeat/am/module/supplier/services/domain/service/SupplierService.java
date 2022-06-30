package com.jfeat.am.module.supplier.services.domain.service;

import com.jfeat.am.module.supplier.services.domain.model.SupplierBindModel;
import com.jfeat.am.module.supplier.services.domain.model.SupplierModel;
import com.jfeat.am.module.supplier.services.gen.crud.service.CRUDSupplierService;
import com.jfeat.am.module.supplier.services.gen.persistence.model.Supplier;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vincent on 2017/10/19.
 */
public interface SupplierService extends CRUDSupplierService {
    @Transactional
    Supplier createOne(SupplierModel entity);

    SupplierModel getOne(Long id);

    @Transactional
    Integer deleteOne(Long id);

    String genAccountName(String name);

    Integer bindSupplier(SupplierBindModel supplierBindModel);

    Integer unBind(SupplierBindModel supplierBindModel);
}