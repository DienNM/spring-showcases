package com.dee.spring.messaging.integration.msgdriven;

import org.springframework.stereotype.Service;

/**
 * @author dien.nguyen
 **/
@Service("msgDrivenTopicReceiverService")
public class MsgDrivenTopicReceiverService{
    
    public void receive(com.dee.spring.messaging.Message buMessage) {
        System.out.println("=======================================");
        System.out.println("Message from: msgDrivenTopicReceiverService");
        System.out.println("Title: " + buMessage.getTitle());
        System.out.println("Message: " + buMessage.getMessage());
    }
    
}
