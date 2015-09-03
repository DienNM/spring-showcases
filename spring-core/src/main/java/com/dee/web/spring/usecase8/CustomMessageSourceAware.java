package com.dee.web.spring.usecase8;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

/**
 * @author dien.nguyen
 */

public class CustomMessageSourceAware implements MessageSourceAware {

    @Override
    public void setMessageSource(MessageSource messageResource) {
        System.out.println(messageResource.getClass());
    }

}
