package com.dee.spring.messaging;



/**
 * @author dien.nguyen
 **/

public interface ReceiverService {
    
    Message receive();
    
    String getId();
    
    void setId(String id);
    
}
