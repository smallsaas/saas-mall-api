package com.jfeat.am.module.frontproduct.services.gen.crud.service.impl;
// ServiceImpl start

            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.ProductItem;
import com.jfeat.am.module.frontproduct.services.gen.persistence.dao.ProductItemMapper;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.CRUDProductItemService;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDProductItemService
 * @author Code generator
 * @since 2022-09-20
 */

@Service
public class CRUDProductItemServiceImpl  extends CRUDServiceOnlyImpl<ProductItem> implements CRUDProductItemService {





        @Resource
        protected ProductItemMapper productItemMapper;

        @Override
        protected BaseMapper<ProductItem> getMasterMapper() {
                return productItemMapper;
        }







}


