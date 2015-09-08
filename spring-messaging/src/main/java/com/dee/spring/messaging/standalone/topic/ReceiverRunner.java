package com.dee.spring.messaging.standalone.topic;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dee.spring.messaging.Message;
import com.dee.spring.messaging.ReceiverService;

/**
 * @author dien.nguyen
 **/

public class ReceiverRunner {
    
    static ApplicationContext appCtx;
    
    public static void main(String[] args) {
        System.out.println("Receiver starts...");
        
        appCtx = new GenericXmlApplicationContext("/spring/standalone/topic/app-context.xml");
        
        ReceiverService receiverService1 = appCtx.getBean("standaloneTopicReceiverService", ReceiverService.class);
        
        boolean received = false;
        while(!received) {
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            
            Message receivedMessage1 = receiverService1.receive();
            received = receivedMessage1 != null && receivedMessage1 != null;
            if(received) {
                Assert.assertNotNull(receivedMessage1);
                Assert.assertEquals("Title standaloneTopicSenderService", receivedMessage1.getTitle());
                Assert.assertEquals("Content standaloneTopicSenderService", receivedMessage1.getMessage());
                
                System.out.println("Title: " + receivedMessage1.getTitle() + ", Message: " + receivedMessage1.getMessage());
                System.out.println(receivedMessage1.getMessage());
            }
        }
    }
}
