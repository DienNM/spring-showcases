package com.dee.spring.messaging.integration.transaction.run.nontran;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jms.JmsException;

import com.dee.spring.messaging.Message;
import com.dee.spring.messaging.SenderService;

/**
 * @author dien.nguyen
 **/

public class SerderNonTransactionMainRunner {
    static ApplicationContext appCtx;

    public static void main(String[] args) {
        appCtx = new GenericXmlApplicationContext("/spring/integration/transaction/non-transaction-app-context.xml");

        SenderService senderService = appCtx.getBean("nonTransactionQueueSenderService", SenderService.class);

        Message message = new Message("Title nonTransactionQueueSenderService", "Content nonTransactionQueueSenderService");

        try {
            senderService.send(message);
            Assert.fail();
        } catch (JmsException e) {
            System.out.println("Error during sending messages...");
        }
    }
}
