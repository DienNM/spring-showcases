package com.dee.spring.messaging.integration.transaction.run.tran;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dee.spring.messaging.Message;
import com.dee.spring.messaging.SenderService;

/**
 * @author dien.nguyen
 **/

public class SenderTransactionMainRunner {
    static ApplicationContext appCtx;

    public static void main(String[] args) {
        appCtx = new GenericXmlApplicationContext("/spring/integration/transaction/app-context.xml");

        SenderService senderService = appCtx.getBean("transactionQueueSenderService", SenderService.class);

        Message message = new Message("Title transactionQueueSenderService", "Content transactionQueueSenderService");
        senderService.send(message);
    }
}
