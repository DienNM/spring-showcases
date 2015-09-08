package com.dee.spring.messaging.integration.transaction;

import javax.jms.Destination;
import javax.jms.MapMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

import com.dee.spring.messaging.Message;
import com.dee.spring.messaging.ReceiverService;


/**
 * @author dien.nguyen
 **/

@Service("transactionQueueReceiverService")
@Scope("prototype")
public class TransactionQueueReceiverService implements ReceiverService{
    
    @Autowired
    private JmsTemplate jmsTemplate;
    
    @Autowired
    private Destination queue;
    
    @Autowired
    private MessageConverter messageConverter;
    
    private String id;
    
    @Override
    public Message receive() {
        MapMessage mapMessage = (MapMessage) jmsTemplate.receive(queue);
        if(mapMessage != null) {
            try {
               return (Message) messageConverter.fromMessage(mapMessage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }


}
