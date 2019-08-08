package com.jfeat.am.module.store.services.mq;

import com.alibaba.fastjson.JSONObject;
import com.jfeat.am.core.util.JsonKit;
import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zy on 2018/12/18.
 */
@Component
public class StoreDeleteSender {
    private static final Logger logger = LoggerFactory.getLogger(StoreDeleteSender.class);
    public static final String MESSAGE_TYPE = "Store.DELETE";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendDeleteMessage(List<String> codes) {
        if(codes != null && !codes.isEmpty()) {
            JSONObject msg = new JSONObject();
            msg.put("type", MESSAGE_TYPE);
            msg.put("data", codes);
            String jsonMessage = JsonKit.toJson(msg);
            logger.debug("send message to mq {}, msg = {}", StoreDeleteConfig.STORE_DELETE_QUEUE, jsonMessage);
            rabbitTemplate.convertAndSend(StoreDeleteConfig.STORE_DELETE_QUEUE, SerializationUtils.serialize(jsonMessage));
        }
    }
}

