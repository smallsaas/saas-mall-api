package com.jfeat.am.module.store.services.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zy on 2018/12/18.
 */
@Configuration
public class StoreDeleteConfig {
    public static final String STORE_DELETE_QUEUE = "store-delete-queue";
    public static final String DEFAULT_EXCHANGE = "";
    @Bean
    public Queue storeUpdateQueue() {
        return new Queue(STORE_DELETE_QUEUE);
    }
}
