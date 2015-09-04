package com.dee.web.spring.usecase2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

/**
 * @author dien.nguyen
 **/

public class JodaObjectMapper extends ObjectMapper {

    private static final long serialVersionUID = 1L;
    
    public JodaObjectMapper() {
        super();
        registerModule(new JodaModule());
    }

}
