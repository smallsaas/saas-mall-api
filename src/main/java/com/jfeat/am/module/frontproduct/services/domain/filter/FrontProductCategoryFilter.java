package com.jfeat.am.module.frontproduct.services.domain.filter;

import com.alibaba.fastjson.JSONObject;
import com.jfeat.crud.plus.CRUDFilter;
import com.jfeat.am.module.frontproduct.services.gen.persistence.model.FrontProductCategory;


/**
 * Created by Code Generator on 2019-07-25
 */
public class FrontProductCategoryFilter implements CRUDFilter<FrontProductCategory> {

    private String[] ignoreFields = new String[]{};
    private String[] updateIgnoreFields = new String[]{};
    public JSONObject result;
    @Override
    public void filter(FrontProductCategory entity, boolean insertOrUpdate) {

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

    public JSONObject result() {
        if(this.result==null){
            this.result=new JSONObject();
        }
        return this.result;
    }
}
