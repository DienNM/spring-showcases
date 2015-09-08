package com.dee.spring.messaging.standalone.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.dee.spring.messaging.Message;
import com.dee.spring.messaging.ReceiverService;

/**
 * @author dien.nguyen
 **/

@Service("standaloneTopicReceiverService")
@Scope("prototype")
public class StandaloneTopicReceiverService implements ReceiverService{
    
    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private Destination topic;
    
    private String id;
    
    @Override
    public Message receive() {
        Connection conn = null;
        try{
            conn = connectionFactory.createConnection();
            Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(topic);
            conn.start();
            
            MapMessage mapMessage = (MapMessage) consumer.receive(2000);
            
            if(mapMessage == null) {
                session.close();
                return null;
            }
            
            Message message = new Message();
            message.setMessage(mapMessage.getString("message"));
            message.setTitle(mapMessage.getString("title"));
            session.close();
            
            return message;
        } catch(JMSException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (JMSException e) {
            }
        }
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
