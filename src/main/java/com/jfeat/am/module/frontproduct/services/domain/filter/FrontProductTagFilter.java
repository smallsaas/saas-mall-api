package com.jfeat.am.module.frontproduct.services.domain.filter;

import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProductTag;
import com.jfeat.crud.plus.CRUDFilter;


/**
 * Created by Code Generator on 2019-07-25
 */
public class FrontProductTagFilter implements CRUDFilter<FrontProductTag> {

    private String[] ignoreFields = new String[]{};
    private String[] updateIgnoreFields = new String[]{};

    @Override
    public void filter(FrontProductTag entity, boolean insertOrUpdate) {

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