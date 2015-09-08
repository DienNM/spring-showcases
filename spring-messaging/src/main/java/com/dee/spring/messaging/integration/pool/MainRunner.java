package com.dee.spring.messaging.integration.pool;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dee.spring.messaging.Message;
import com.dee.spring.messaging.SenderService;

/**
 * @author dien.nguyen
 **/

public class MainRunner {
    static ApplicationContext appCtx;

    public static void main(String[] args) {
        appCtx = new GenericXmlApplicationContext("/spring/integration/pool/app-context.xml");

        SenderService senderService = appCtx.getBean("poolTopicSenderService", SenderService.class);

        Message message = new Message("Title poolTopicSenderService", "Content poolTopicSenderService");
        senderService.send(message);
        
        System.out.println("Sent a message");
    }
}
