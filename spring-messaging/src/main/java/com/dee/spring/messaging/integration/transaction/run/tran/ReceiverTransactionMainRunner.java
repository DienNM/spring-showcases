package com.dee.spring.messaging.integration.transaction.run.tran;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dee.spring.messaging.Message;
import com.dee.spring.messaging.ReceiverService;

/**
 * @author dien.nguyen
 **/

public class ReceiverTransactionMainRunner {
    static ApplicationContext appCtx;

    public static void main(String[] args) {
        appCtx = new GenericXmlApplicationContext("/spring/integration/transaction/non-transaction-app-context.xml");

        ReceiverService receiverService1 = appCtx.getBean("transactionQueueReceiverService", ReceiverService.class);
        System.out.println("Waiting for a message...");

        int count = 0;
        boolean receivedMessage = false;
        while (count < 5) {
            try {
                Thread.sleep(2000);
                count++;
            } catch (InterruptedException e) {
            }

            // Receive message
            Message receivedMessage1 = receiverService1.receive();
            if (receivedMessage1 != null) {
                receivedMessage = true;
            }
        }
        System.out.println("Received Message: " + receivedMessage);
    }
}
