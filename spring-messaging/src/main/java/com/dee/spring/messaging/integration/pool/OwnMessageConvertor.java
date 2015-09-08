package com.dee.spring.messaging.integration.pool;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

/**
 * @author dien.nguyen
 **/

@Service("ownMessageConvertor")
public class OwnMessageConvertor implements MessageConverter {

    @Override
    public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
        com.dee.spring.messaging.Message buMessage = (com.dee.spring.messaging.Message) object;
        MapMessage mapMessage = session.createMapMessage();
        mapMessage.setString("title", buMessage.getTitle());
        mapMessage.setString("message", buMessage.getMessage());
        return mapMessage;
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        MapMessage mapMessage = (MapMessage) message;
        com.dee.spring.messaging.Message buMessage = new com.dee.spring.messaging.Message();
        buMessage.setTitle(mapMessage.getString("title"));
        buMessage.setMessage(mapMessage.getString("message"));
        return buMessage;
    }

}
