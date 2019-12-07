package com.jfeat.am.module.frontproduct.services.domain.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.frontproduct.services.domain.dao.QueryProductSettlementProportionDao;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductProportionModel;
import com.jfeat.am.module.frontproduct.services.domain.model.ProductSettlementProportionRecord;
import com.jfeat.am.module.frontproduct.services.domain.service.ProductSettlementProportionService;
import com.jfeat.am.module.frontproduct.services.gen.crud.service.impl.CRUDProductSettlementProportionServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */
@Service("productSettlementProportionService")
public class ProductSettlementProportionServiceImpl extends CRUDProductSettlementProportionServiceImpl implements ProductSettlementProportionService {
    @Resource
    QueryProductSettlementProportionDao queryProductSettlementProportionDao;

    @Override
    public List findProductSettlementProportionPage(Page<ProductSettlementProportionRecord> page, ProductSettlementProportionRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryProductSettlementProportionDao.findProductSettlementProportionPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }



    //返回 分成配置 fixedvalue 固定值 percentage 百分比
    @Override
    public List<ProductSettlementProportionRecord> getProductSettlementProportionSettingGroup(){
         List<ProductSettlementProportionRecord> settingGroup = new ArrayList<>();
        ProductSettlementProportionRecord setting=new ProductSettlementProportionRecord();

        //盟友',       'ALLIANCE',  '{\"fixedvalue\":false,\"percentage\":true,\
        setting=new ProductSettlementProportionRecord();
        setting.setName("盟友");setting.setType("ALLIANCE");
        setting.setFixedvalue(false);setting.setPercentage(true);
        setting.setId(100L);
        setting.setLevel(0);
        setting.setRewardType("%");
        settingGroup.add(setting);
        //股东',      'STOCKHOLDER', '{\"fixedvalue\":false,\"percentage\":true,
        setting=new ProductSettlementProportionRecord();
        setting.setName("股东");setting.setType("STOCKHOLDER");
        setting.setFixedvalue(false);setting.setPercentage(true);
        setting.setId(101L);
        setting.setLevel(0);
        setting.setRewardType("%");
        settingGroup.add(setting);

        //皇冠商',     'CROWN', '{\"fixedvalue\":true,\"percentage\":false,\
        setting=new ProductSettlementProportionRecord();
        setting.setName("皇冠商");setting.setType("CROWN");
        setting.setFixedvalue(true);setting.setPercentage(false);
        setting.setId(102L);
        setting.setLevel(0);
        setting.setRewardType("元");
        settingGroup.add(setting);
        //一星经销商', 'PARTNER',    '{\"fixedvalue\":true,\"percentage\":false
         setting=new ProductSettlementProportionRecord();
        setting.setName("一星经销商");setting.setType("PARTNER");
        setting.setFixedvalue(true);setting.setPercentage(false);
        setting.setId(103L);
        setting.setLevel(1);
        setting.setRewardType("元");
        settingGroup.add(setting);
        //二星经销商', 'PARTNER', '{\"fixedvalue\":true,\"percentage\":false,\
        setting=new ProductSettlementProportionRecord();
        setting.setName("二星经销商");setting.setType("PARTNER");
        setting.setFixedvalue(true);setting.setPercentage(false);
        setting.setId(104L);
        setting.setLevel(2);
        setting.setRewardType("元");
        settingGroup.add(setting);
        //三星经销商', 'PARTNER',    '{\"fixedvalue\":true,\"percentage\":false
        setting=new ProductSettlementProportionRecord();
        setting.setName("三星经销商");setting.setType("PARTNER");
        setting.setFixedvalue(true);setting.setPercentage(false);
        setting.setId(105L);
        setting.setLevel(3);
        setting.setRewardType("元");
        settingGroup.add(setting);
        //四星经销商', 'PARTNER', '{\"fixedvalue\":true,\"percentage\":false,\
        setting=new ProductSettlementProportionRecord();
        setting.setName("四星经销商");setting.setType("PARTNER");
        setting.setFixedvalue(true);setting.setPercentage(false);
        setting.setId(106L);
        setting.setLevel(4);
        setting.setRewardType("元");
        settingGroup.add(setting);
        //五星经销商', 'PARTNER', '{\"fixedvalue\":true,\"percentage\":false,\
        setting=new ProductSettlementProportionRecord();
        setting.setName("五星经销商");setting.setType("PARTNER");
        setting.setFixedvalue(true);setting.setPercentage(false);
        setting.setId(107L);
        setting.setLevel(5);
        setting.setRewardType("元");
        settingGroup.add(setting);
        //六星经销商', 'PARTNER',  '{\"fixedvalue\":true,\"percentage\":false,\
        setting=new ProductSettlementProportionRecord();
        setting.setName("六星经销商");setting.setType("PARTNER");
        setting.setFixedvalue(true);setting.setPercentage(false);
        setting.setId(108L);
        setting.setLevel(6);
        setting.setRewardType("元");
        settingGroup.add(setting);


        return settingGroup;
    }

    //  处理前端得到的对象 转成需要存入对象      将元素组成需要的字符串
    @Override
    public List<ProductSettlementProportionRecord> setProductSettlementProportionSettingGroup
            (List<ProductSettlementProportionRecord> settingGroup,Integer productId){
        for (ProductSettlementProportionRecord productSettlementProportionRecord:settingGroup) {
            productSettlementProportionRecord.setProductId(productId);

            ProductProportionModel productProportionModel=new ProductProportionModel();
            productProportionModel.setFixedvalue(productSettlementProportionRecord.isFixedvalue());
            productProportionModel.setPercentage(productSettlementProportionRecord.isPercentage());
            productProportionModel.setValue(productSettlementProportionRecord.getValue());

            String proportion=JSONObject.toJSONString(productProportionModel);
            productSettlementProportionRecord.setProportion(proportion);
        }
        return settingGroup;
    }

    //  处理sql得到的对象 转成需要传给前端的对象      将元素组成需要的字符串
    @Override
    public List<ProductSettlementProportionRecord> reSetProductSettlementProportionSettingGroup
    (List<ProductSettlementProportionRecord> settingGroup){
        for (ProductSettlementProportionRecord productSettlementProportionRecord:settingGroup) {
            JSONObject json =JSONObject.parseObject(productSettlementProportionRecord.getProportion());
            ProductProportionModel productProportionModel=JSONObject.toJavaObject(json,ProductProportionModel.class);
            productSettlementProportionRecord.setFixedvalue(productProportionModel.isFixedvalue());
            productSettlementProportionRecord.setPercentage(productProportionModel.isPercentage());
            productSettlementProportionRecord.setValue(productProportionModel.getValue());
            //设置单位
            if(productProportionModel.isFixedvalue()){
                productSettlementProportionRecord.setRewardType("元");
            }else  productSettlementProportionRecord.setRewardType("%");

        }

        return settingGroup;
    }




}
