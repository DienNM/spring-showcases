package com.dee.spring.messaging.integration.msgdriven;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

import com.dee.spring.messaging.Message;
import com.dee.spring.messaging.SenderService;

/**
 * @author dien.nguyen
 **/

@Service("msgDrivenQueueSenderService")
public class MsgDrivenQueueSenderService implements SenderService{
    
    @Autowired
    private JmsTemplate jmsTemplate;
    
    @Autowired
    private Destination queue;
    
    @Autowired
    private MessageConverter messageConverter;
    
    @Override
    public void send(final Message message) {
        jmsTemplate.send(queue, new MessageCreator() {
            @Override
            public javax.jms.Message createMessage(Session session) throws JMSException {
                return messageConverter.toMessage(message, session);
            }
        });
        
    }

}
