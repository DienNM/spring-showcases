package com.dee.spring.messaging.integration.pool;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

/**
 * @author dien.nguyen
 **/

@Service("poolTopicReceiverListener")
public class PoolTopicReceiverListener implements MessageListener{

    @Autowired
    private MessageConverter messageConverter;
    
    @Override
    public void onMessage(Message message) {
        MapMessage mapMessage = (MapMessage) message;
        if(mapMessage != null) {
            try {
               com.dee.spring.messaging.Message buMessage = 
                       (com.dee.spring.messaging.Message) messageConverter.fromMessage(mapMessage);

               System.out.println("=======================================");
               System.out.println("Message from: msgDrivenQuenReceiverListener");
               System.out.println("Title: " + buMessage.getTitle());
               System.out.println("Message: " + buMessage.getMessage());
               
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
