package com.dee.spring.messaging.integration.msgdriven;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

/**
 * @author dien.nguyen
 **/

@Service("msgDrivenQuenReceiverService")
public class MsgDrivenQuenReceiverService implements MessageListener{

    @Autowired
    private MessageConverter messageConverter;
    
    @Override
    public void onMessage(Message message) {
        MapMessage mapMessage = (MapMessage) message;
        if(mapMessage != null) {
            try {
               com.dee.spring.messaging.Message buMessage = 
                       (com.dee.spring.messaging.Message) messageConverter.fromMessage(mapMessage);
               
               System.out.println("Title: " + buMessage.getTitle());
               System.out.println("Message: " + buMessage.getMessage());
               
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
