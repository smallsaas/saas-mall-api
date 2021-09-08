package com.jfeat.am.module.order.services.domain.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.configmanagement.services.gen.persistence.dao.ConfigMapper;
import com.jfeat.am.module.configmanagement.services.gen.persistence.model.Config;
import com.jfeat.am.module.order.services.domain.dao.QueryExpressDao;
import com.jfeat.am.module.order.services.domain.model.ExpressInfo;
import com.jfeat.am.module.order.services.domain.model.ExpressRecord;
import com.jfeat.am.module.order.services.domain.service.ExpressService;
import com.jfeat.am.module.order.services.domain.util.HttpUtil;
import com.jfeat.am.module.order.services.gen.crud.service.impl.CRUDExpressServiceImpl;
import com.jfeat.am.module.order.services.gen.persistence.model.Express;
import com.jfeat.crud.base.util.StrKit;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */
@Service("expressService")
public class ExpressServiceImpl extends CRUDExpressServiceImpl implements ExpressService {
    @Resource
    QueryExpressDao queryExpressDao;
    @Resource
    HttpUtil httpUtil;

    @Resource
    ConfigMapper configMapper;
    private static final String EXPRESS_URL = "http://poll.kuaidi100.com/poll/query.do";
    //private static final String EXPRESS_URL = "http://localhost:8080/api/crud/test";

    private static final String EXPRESS_CUSTOMER = "express.customer";
    private static final String EXPRESS_KEY = "express.key";

    Config getKey(String key){
        QueryWrapper wrapper = new QueryWrapper<>().eq("key_name", key);
        Config config = configMapper.selectOne(wrapper);
        return config;
    }

    @Override
    public List findExpressPage(Page<ExpressRecord> page, ExpressRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryExpressDao.findExpressPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }

    @Override
    public Integer updateIsDefault() {
        Integer result=0;
        Express entity=new Express();
        entity.setIsDefault(0);
        result=queryExpressDao.update(entity,new QueryWrapper<Express>().eq("is_default",1));
        return result;
    }


    @Override
    public ExpressInfo queryExpress(String comCode, String number) {

        JSONObject param = new JSONObject();
        param.put("com", comCode);
        param.put("num", number);
        String key = getKey(EXPRESS_KEY).getValue();
        String customer = getKey(EXPRESS_CUSTOMER).getValue();
        String data = param.toJSONString() + key + customer;
        String sign = MD5.encode(data);
        //封装请求
       /* JSONObject params = new JSONObject();*/
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("customer", customer);
        params.add("sign", sign);
        params.add("param", param.toJSONString());

        JSONObject jsonObject = httpUtil.getResponse(EXPRESS_URL, HttpMethod.POST,params);
        //ExpressInfo expressInfo = HttpKit.postForm(EXPRESS_URL, params, ExpressInfo.class);
        String com = jsonObject.getString("com");
        String status = jsonObject.getString("status");
        String company = expressMapper.getExpressCompany(com);
        String returnCode = jsonObject.getString("returnCode");
        JSONArray dataList = jsonObject.getJSONArray("data");
        List<ExpressInfo.Data> dataBody = dataList.toJavaList(ExpressInfo.Data.class);
        ExpressInfo expressInfo = new ExpressInfo();
        expressInfo.setMessage(jsonObject.getString("message"));
        expressInfo.setComcontact(jsonObject.getString("comcontact"));
        expressInfo.setCom(com);
        expressInfo.setCompany(company);
        expressInfo.setReturnCode(returnCode);
        expressInfo.setData(dataBody);
        if (StrKit.notBlank(returnCode)) {
            expressInfo.setStatus("2");
        }
        if ("200".equals(status)) {
            expressInfo.setStatus("1");
        }
        return expressInfo;
    }



    public static class MD5 {
        // 获得MD5摘要算法的 MessageDigest 对象
        private static MessageDigest _mdInst = null;
        private static char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        private static MessageDigest getMdInst() {
            if (_mdInst == null) {
                try {
                    _mdInst = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
            return _mdInst;
        }

        public final static String encode(String s) {
            try {
                byte[] btInput = s.getBytes();
                // 使用指定的字节更新摘要
                getMdInst().update(btInput);
                // 获得密文
                byte[] md = getMdInst().digest();
                // 把密文转换成十六进制的字符串形式
                int j = md.length;
                char str[] = new char[j * 2];
                int k = 0;
                for (int i = 0; i < j; i++) {
                    byte byte0 = md[i];
                    str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                    str[k++] = hexDigits[byte0 & 0xf];
                }
                return new String(str);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

}
