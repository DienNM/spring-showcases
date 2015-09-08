package com.dee.spring.messaging.integration.queue;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dee.spring.messaging.Message;
import com.dee.spring.messaging.ReceiverService;
import com.dee.spring.messaging.SenderService;

/**
 * @author dien.nguyen
 **/

public class MainRunner {
    static ApplicationContext appCtx;

    public static void main(String[] args) {
        appCtx = new GenericXmlApplicationContext("/spring/integration/queue/app-context.xml");

        SenderService senderService = appCtx.getBean("integrationQueueSenderService", SenderService.class);

        Message message = new Message("Title integrationQueueSenderService", "Content integrationQueueSenderService");
        senderService.send(message);

        // Only one Receiver can get message.
        ReceiverService receiverService1 = appCtx.getBean("integrationQueueReceiverService", ReceiverService.class);
        receiverService1.setId("ID1");

        ReceiverService receiverService2 = appCtx.getBean("integrationQueueReceiverService", ReceiverService.class);
        receiverService2.setId("ID2");

        Assert.assertNotEquals(receiverService1.getId(), receiverService2.getId());

        // Receive message
        Message receivedMessage1 = receiverService1.receive();
        Assert.assertNotNull(receivedMessage1);
        Assert.assertEquals("Title integrationQueueSenderService", receivedMessage1.getTitle());
        Assert.assertEquals("Content integrationQueueSenderService", receivedMessage1.getMessage());

        Message receivedMessage2 = receiverService2.receive();
        Assert.assertNull(receivedMessage2);
    }
}
