package com.jfeat.am.module.product.services.domain.filter;

import com.jfeat.crud.plus.CRUDFilter;
import com.jfeat.am.module.product.services.gen.persistence.model.ProductImage;


/**
 * Created by Code Generator on 2019-07-25
 */
public class ProductImageFilter implements CRUDFilter<ProductImage> {

    private String[] ignoreFields = new String[]{};
    private String[] updateIgnoreFields = new String[]{};

    @Override
    public void filter(ProductImage entity, boolean insertOrUpdate) {

        //if insertOrUpdate is true,means for insert, do this
        if (insertOrUpdate){

            //then insertOrUpdate is false,means for update,do this
        }else {

        }

    }

    @Override
    public String[] ignore(boolean retrieveOrUpdate) {
        //if retrieveOrUpdate is true,means for retrieve ,do this
        if (retrieveOrUpdate){
            return ignoreFields;
            //then retrieveOrUpdate  if false ,means for update,do this
        }else {
            return updateIgnoreFields;
        }
    }
}
