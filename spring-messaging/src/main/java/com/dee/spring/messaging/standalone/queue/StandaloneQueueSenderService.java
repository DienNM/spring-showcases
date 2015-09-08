package com.dee.spring.messaging.standalone.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dee.spring.messaging.Message;
import com.dee.spring.messaging.SenderService;

/**
 * @author dien.nguyen
 **/

@Service("standaloneQueueSenderService")
public class StandaloneQueueSenderService implements SenderService {
    
    @Autowired
    private ConnectionFactory jmsConnectionFactory;
    
    @Autowired
    private Destination queue;
    
    @Override
    public void send(Message message) {
        Connection conn = null;
        try {
            conn = jmsConnectionFactory.createConnection();
            Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            
            MessageProducer producer = session.createProducer(queue);
            MapMessage mapMessage = session.createMapMessage();
            mapMessage.setString("title", message.getTitle());
            mapMessage.setString("message", message.getMessage());
            
            producer.send(mapMessage);
            session.close();
            
        } catch(JMSException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (JMSException e) {
            }
        }
    }

}
