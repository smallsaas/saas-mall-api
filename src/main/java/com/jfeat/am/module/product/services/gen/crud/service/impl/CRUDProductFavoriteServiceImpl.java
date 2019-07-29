package com.jfeat.am.module.product.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductFavorite;
import com.jfeat.am.module.product.services.gen.persistence.dao.ProductFavoriteMapper;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDProductFavoriteService;
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
 *CRUDProductFavoriteService
 * @author Code Generator
 * @since 2019-07-25
 */

@Service
public class CRUDProductFavoriteServiceImpl  extends CRUDServiceOnlyImpl<ProductFavorite> implements CRUDProductFavoriteService {





        @Resource
        protected ProductFavoriteMapper productFavoriteMapper;

        @Override
        protected BaseMapper<ProductFavorite> getMasterMapper() {
                return productFavoriteMapper;
        }







}


