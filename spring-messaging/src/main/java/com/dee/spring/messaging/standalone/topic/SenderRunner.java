package com.dee.spring.messaging.standalone.topic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dee.spring.messaging.Message;
import com.dee.spring.messaging.SenderService;

/**
 * @author dien.nguyen
 **/

public class SenderRunner {
    
    static ApplicationContext appCtx;
    
    public static void main(String[] args) {
        appCtx = new GenericXmlApplicationContext("/spring/standalone/topic/app-context.xml");
        
        SenderService senderService = appCtx.getBean("standaloneTopicSenderService", SenderService.class);
        Message message = new Message("Title standaloneTopicSenderService", "Content standaloneTopicSenderService");
        senderService.send(message);
    }
}
