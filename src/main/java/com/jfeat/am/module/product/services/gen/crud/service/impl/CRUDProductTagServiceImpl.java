package com.jfeat.am.module.product.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductTag;
import com.jfeat.am.module.product.services.gen.persistence.dao.ProductTagMapper;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDProductTagService;
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
 *CRUDProductTagService
 * @author Code Generator
 * @since 2019-07-25
 */

@Service
public class CRUDProductTagServiceImpl  extends CRUDServiceOnlyImpl<ProductTag> implements CRUDProductTagService {





        @Resource
        protected ProductTagMapper productTagMapper;

        @Override
        protected BaseMapper<ProductTag> getMasterMapper() {
                return productTagMapper;
        }







}


