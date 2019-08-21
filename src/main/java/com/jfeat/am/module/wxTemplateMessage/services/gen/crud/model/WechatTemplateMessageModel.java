package com.jfeat.am.module.wxTemplateMessage.services.gen.crud.model;

import java.util.List;
import com.jfeat.am.module.wxTemplateMessage.services.gen.persistence.model.WechatMessageTypeProp;
import com.jfeat.am.module.wxTemplateMessage.services.gen.persistence.model.WechatTemplateMessage;

/**
 * Created by Code Generator on 2019-08-21
 */
public class WechatTemplateMessageModel extends WechatTemplateMessage{
    private List<WechatMessageTypeProp> items;

    public List<WechatMessageTypeProp> getItems() {
        return this.items;
    }

    public void setItems(List<WechatMessageTypeProp> items) {
        this.items = items;
    }
}
