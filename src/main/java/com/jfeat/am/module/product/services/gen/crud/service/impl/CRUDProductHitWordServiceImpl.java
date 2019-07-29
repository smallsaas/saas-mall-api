package com.jfeat.am.module.product.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductHitWord;
import com.jfeat.am.module.product.services.gen.persistence.dao.ProductHitWordMapper;
import com.jfeat.am.module.product.services.gen.crud.service.CRUDProductHitWordService;
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
 *CRUDProductHitWordService
 * @author Code Generator
 * @since 2019-07-25
 */

@Service
public class CRUDProductHitWordServiceImpl  extends CRUDServiceOnlyImpl<ProductHitWord> implements CRUDProductHitWordService {





        @Resource
        protected ProductHitWordMapper productHitWordMapper;

        @Override
        protected BaseMapper<ProductHitWord> getMasterMapper() {
                return productHitWordMapper;
        }







}


