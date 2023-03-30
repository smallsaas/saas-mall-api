package com.jfeat.am.module.commons;

import com.jfeat.am.core.jwt.JWTKit;
import com.jfeat.am.module.order.services.domain.model.OrderItemRecord;
import com.jfeat.am.module.order.services.domain.model.OrderRecord;
import com.jfeat.am.module.order.services.domain.model.RequestOrder;
import com.jfeat.am.module.task.services.crud.service.SnpoolService;
import com.jfeat.am.module.task.services.crud.service.WorkTaskService;
import com.jfeat.am.module.task.services.domain.model.WorkTaskModel;
import com.jfeat.am.module.taskQueue.services.domain.service.TaskQueueMassageService;
import com.jfeat.am.module.taskQueue.services.domain.service.TaskQueueService;
import com.jfeat.am.module.taskQueue.services.gen.persistence.model.TaskQueue;
import com.jfeat.users.account.services.gen.persistence.dao.UserAccountMapper;
import com.jfeat.users.account.services.gen.persistence.model.UserAccount;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * @description: 匠城小程序邮件发送类，有很多的服务已不知道具体作用是什么，只是需要使用的方法要用到，所以继续使用
 * @project: saas-mall-api
 * @version: 1.0
 * @date: 2023/3/28 14:39
 * @author: hhhhhtao
 */

@Component
public class HouseEmail {

    @Resource
    TaskQueueMassageService taskQueueMassageService; // 消息队列消息服务

    @Resource
    TaskQueueService taskQueueService; // 消息队列服务

    @Resource
    WorkTaskService workTaskService;

    @Resource
    SnpoolService snpoolService;

    @Resource
    UserAccountMapper userAccountMapper; // 用户信息mapper，在此处调用mapper并不规范，但是需要跟着之前的业务走

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(HouseEmail.class);

    /**
     * 邮件所需常量值定义
     */
    // 收件人列表
    private static final List<String> ADDRESSEES = new ArrayList<>(){
        {
            add("3080348136@qq.com");
            add("2237692@qq.com");
        }
    };

    // 团购邮件内容模版
    private static final String GROUP_EMAIL_TEMPLATE =
            "【匠城回迁便民服务-团购订单通知】用户：{userName}，联系电话：{phone}，加入了{productName}团购，订购数量：{number}";

    // 任务类型：团购任务
    private static final String QUEUE_HOUSE_GROUP = "QUEUE_HOUSE_GROUP";

    // 任务名
    private static final String TASK_NAME = "团购订单";

    // 用于控制知否使用kafka发送消息
    private static final Boolean KAFKA = true;

    // 业务不清楚，猜想这应该是过期时间，获取当前时间，然后7天后过期
    private static final int DEADLINE_DAY = 7;

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

    /**
     * 封装消息队列任务对象，并写入数据库
     * @param queueName 任务类型
     * @param taskName 任务名
     * @param emailContent 邮件内容
     * @param userId 请求的用户id
     * @param addressees 邮件收件人邮箱列表
     * @return 消息队列任务对象
     */
    private WorkTaskModel saveWorkTask(String queueName,String taskName,String emailContent,Long userId,List<String> addressees) {
        // 查询消息队列信息
        TaskQueue taskQueue = taskQueueService.getTaskQueueByName(queueName);

        //
        WorkTaskModel workTaskModel = new WorkTaskModel();
        // 接手项目后，此处报错，task表中并没有这个字段，因为之后的方法也有使用该值，所以先在表上添加
        workTaskModel.setQueueId(taskQueue.getId());
        // task表中priority不允许为空，优先级 0 1 2 从低到高，目前并不知道优先级的含义，此处先行使用2
        workTaskModel.setPriority(2);
        workTaskModel.setTaskName(taskName);
        workTaskModel.setTaskNumber(snpoolService.getSerial("TD"));
        workTaskModel.setToEmailAddressList(addressees);
        workTaskModel.setDesc(emailContent);
        workTaskModel.setTaskType("TODO");
        workTaskModel.setStartTime(new Date());
        // 到期时间
        workTaskModel.setDeadline(setDate(new Date(), DEADLINE_DAY));
        // 关闭时间
        workTaskModel.setCloseTime(setDate(new Date(), DEADLINE_DAY));

        // 获取用户信息
        UserAccount userAccount = userAccountMapper.selectById(userId);
        //
        workTaskService.createMasterByStaff(workTaskModel,userAccount,true);

        //
        return workTaskModel;
    }

    /**
     * 设定时间
     * @param date 当前的日期时间
     * @param day 要增加的天数
     * @return 当前时间 + 增加天数
     */
    private Date setDate(Date date,int day) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,day);
        date=calendar.getTime();
        return date;
    }

    /**
     * 发送团购订单邮件
     * @param  订单
     */
    public void sendGroupOrderEmail(RequestOrder order) {
        // 获取当前请求用户的Id
        Long userId = JWTKit.getUserId();
        // 获取用户信息
        UserAccount userAccount = userAccountMapper.selectById(userId);

        // 目前的团购一个订单只能有一个商品，比起修改原有的代码，暂时写死获取数组的第一个商品
        OrderItemRecord orderItem = order.getItems().get(0);

        new Thread(() -> {
            // 封装内容
            Map<String,Object> contentMap = new HashMap<>();
            contentMap.put("userName",StringUtils.isNotBlank(userAccount.getName()) ? userAccount.getName() : "-");
            contentMap.put("productName",StringUtils.isNotBlank(orderItem.getProductName()) ? orderItem.getProductName() : "-");
            contentMap.put("number",orderItem.getQuantity() != null ? orderItem.getQuantity() : 0);
            contentMap.put("phone",StringUtils.isNotBlank(userAccount.getPhone()) ? userAccount.getPhone() : "-");

            // 重构模版，替换真正的值
            String emailContent = this.reconfigurationTemplate(contentMap,GROUP_EMAIL_TEMPLATE);

            // 封装代办事项
            WorkTaskModel workTaskModel = this.saveWorkTask(QUEUE_HOUSE_GROUP,TASK_NAME,emailContent,userId,ADDRESSEES);

            // 发送邮件
            taskQueueMassageService.taskQueueMessageControl(workTaskModel,KAFKA);
        }).start();
    }



}
