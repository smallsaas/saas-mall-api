package com.jfeat.am.module.frontuser.services.domain.filter;

import com.jfeat.am.module.frontuser.services.gen.persistence.model.FrontUser;
import com.jfeat.crud.plus.CRUDFilter;


/**
 * Created by Code Generator on 2019-08-22
 */
public class FrontUserFilter implements CRUDFilter<FrontUser> {

    private String[] ignoreFields = new String[]{};
    private String[] updateIgnoreFields = new String[]{};

    @Override
    public void filter(FrontUser entity, boolean insertOrUpdate) {

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
