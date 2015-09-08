package com.dee.spring.messaging.integration.msgdriven;

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
        appCtx = new GenericXmlApplicationContext("/spring/integration/msgdriven/app-context.xml");

        SenderService senderService = appCtx.getBean("msgDrivenQueueSenderService", SenderService.class);

        Message message = new Message("Title msgDrivenQueueSenderService", "Content msgDrivenQueueSenderService");
        senderService.send(message);
    }
}
