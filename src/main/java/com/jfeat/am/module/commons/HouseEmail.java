package com.jfeat.am.module.commons;

import com.jfeat.am.module.taskQueue.services.domain.service.TaskQueueMassageService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * @description: 匠城小程序邮件发送工具类
 * @project: saas-mall-api
 * @version: 1.0
 * @date: 2023/3/28 14:39
 * @author: hhhhhtao
 */

@Component
public class HouseEmail {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(HouseEmail.class);

    /**
     * 邮件所需常量值定义
     */
    // 收件人列表
    private static final List<String> ADDRESSEE = new ArrayList<>(){
        {
            add("3080348136@qq.com");
            add("1152808759@qq.com");
        }
    };

    // 团购邮件内容模版
    private static final String GROUP_EMAIL_TEMPLATE =
            "【匠城回迁便民服务】团购订单通知：用户\"{userName}\"加入了\"{productName}\"团购，订购数量：{number}，联系电话：{phone}";

    @Resource
    TaskQueueMassageService taskQueueMassageService; // 消息队列服务

    /**
     * 重构邮件模版，将{key}替换为正式内容
     * @param contentMap 存储对应模版{key}中真正的值
     * @param template 邮件呢内容模版
     * @return
     */
    private String reconfigurationTemplate(Map<String, Object> contentMap,String template) {
        if (StringUtils.isBlank(template) || contentMap == null) return null;

        // 循环替换{key}为对应的值
        for (Map.Entry<String,Object> entry : contentMap.entrySet()) {
            template = template.replaceAll("\\{".concat(entry.getKey()).concat("\\}"),String.valueOf(entry.getValue()));
        }

        return template;
    }


    public void sendGroupOrderEmail() {
        // 封装内容
        Map<String,Object> contentMap = new HashMap<>();
        contentMap.put("userName","某某");
        contentMap.put("productName","港一门窗");
        contentMap.put("number",2);
        contentMap.put("phone","1234456");

        // 重构模版，替换真正的值
        String emailContent = this.reconfigurationTemplate(contentMap,GROUP_EMAIL_TEMPLATE);

        // 封装代办事项

    }

}
