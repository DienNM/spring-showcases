package com.dee.spring.messaging.integration.transaction;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dee.spring.messaging.Message;
import com.dee.spring.messaging.SenderService;

/**
 * @author dien.nguyen
 **/

@Service("transactionQueueSenderService")
public class TransactionQueueSenderService implements SenderService{
    
    @Autowired
    private JmsTemplate jmsTemplate;
    
    @Autowired
    private Destination queue;
    
    @Autowired
    private MessageConverter messageConverter;
    
    @Override
    @Transactional
    public void send(final Message message) {
        jmsTemplate.send(queue, new MessageCreator() {
            @Override
            public javax.jms.Message createMessage(Session session) throws JMSException {
                return messageConverter.toMessage(message, session);
            }
        });
        jmsTemplate.send(queue, new MessageCreator() {
            @Override
            public javax.jms.Message createMessage(Session session) throws JMSException {
                throw new JMSException("Something Wrong");
            }
        });
        
    }

}
