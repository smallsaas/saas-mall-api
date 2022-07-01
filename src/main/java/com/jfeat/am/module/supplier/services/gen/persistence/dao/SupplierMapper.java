package com.jfeat.am.module.supplier.services.gen.persistence.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.am.module.supplier.services.domain.model.SupplierModel;
import com.jfeat.am.module.supplier.services.gen.persistence.model.Supplier;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Code generator
 * @since 2022-05-19
 */
public interface SupplierMapper extends BaseMapper<Supplier> {

    SupplierModel getOne(@Param("id") Long id);
}
