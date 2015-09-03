package com.dee.web.spring.usecase3.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @author dien.nguyen
 **/

public class AppPropertiesPlacehober extends PropertyPlaceholderConfigurer {
    
    private static Map<String, String> propertiesMap;
    private int springSystemPropertiesMode = SYSTEM_PROPERTIES_MODE_OVERRIDE;
    
    @Override
    public void setSystemPropertiesMode(int systemPropertiesMode) {
        super.setSystemPropertiesMode(systemPropertiesMode);
    }
    
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
            throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        propertiesMap = new HashMap<String, String>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String valueStr = resolvePlaceholder(keyStr, props, springSystemPropertiesMode);
            propertiesMap.put(keyStr, valueStr);
        }
    }
    
    public static String getProperty(String name) {
        return propertiesMap.get(name).toString();
    }
    
}
