package com.dee.web.spring.usecase1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;

import com.dee.web.spring.usecase1.Course;
import com.dee.web.spring.usecase1.Student;
import com.dee.web.spring.usecase1.Students;

/**
 * @author dien.nguyen
 **/

@Configuration
@EnableWebMvc
public class XmlRESTConfiguration {

    @Bean
    public ViewResolver viewResolver() {
        return new BeanNameViewResolver();
    }

    @Bean
    public View studentTemaplate() {
        return new MarshallingView(jaxb2StudentMarshaller());
    }

    @Bean
    public Marshaller jaxb2StudentMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Students.class, Student.class, Course.class);
        return marshaller;
    }

}
