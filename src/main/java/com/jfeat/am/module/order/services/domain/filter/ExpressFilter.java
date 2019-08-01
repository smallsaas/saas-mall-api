package com.jfeat.am.module.order.services.domain.filter;

import com.jfeat.crud.plus.CRUDFilter;
import com.jfeat.am.module.order.services.gen.persistence.model.Express;


/**
 * Created by Code Generator on 2019-08-01
 */
public class ExpressFilter implements CRUDFilter<Express> {

    private String[] ignoreFields = new String[]{};
    private String[] updateIgnoreFields = new String[]{};

    @Override
    public void filter(Express entity, boolean insertOrUpdate) {

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
