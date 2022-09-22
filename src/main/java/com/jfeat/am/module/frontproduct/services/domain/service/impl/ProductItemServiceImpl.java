package com.jfeat.am.module.frontproduct.services.domain.service.impl;
import com.jfeat.am.module.frontproduct.services.domain.service.ProductItemService;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.impl.CRUDProductItemServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */

@Service("productItemService")
public class ProductItemServiceImpl extends CRUDProductItemServiceImpl implements ProductItemService {

    @Override
    protected String entityName() {
        return "ProductItem";
    }


                            }
