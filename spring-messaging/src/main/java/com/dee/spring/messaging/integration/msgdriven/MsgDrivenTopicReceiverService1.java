package com.dee.spring.messaging.integration.msgdriven;

import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * @author dien.nguyen
 **/
@Service("msgDrivenTopicReceiverService1")
public class MsgDrivenTopicReceiverService1{
    
    public void receive(Map<String, String> map) {
        com.dee.spring.messaging.Message buMessage = new com.dee.spring.messaging.Message();
        buMessage.setTitle(map.get("title"));
        buMessage.setMessage(map.get("message"));
        
        System.out.println("=======================================");
        System.out.println("Message from: msgDrivenTopicReceiverService 1");
        System.out.println("Title: " + buMessage.getTitle());
        System.out.println("Message: " + buMessage.getMessage());
    }
    
}
