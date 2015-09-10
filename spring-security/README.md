# Spring Security Examples

Example of Spring Security

web.xml:

    - ContextLoaderListener listener: starting and stopping Spring root ApplicationContext
    
        + In tag: context-param, update contextConfigLocation to point to location of Spring Configuration
            Example: classpath:spring/app-context.xml /WEB-INF/spring/security-context.xml
             
    - DispatcherServlet servlet: loading Web Application Context (MVC in this case)
    
        + contextConfigLocation: update location of Spring configuration for Web Application
            Example: /WEB-INF/spring/mvc-context.xml
            
    - springSecurityFilterChain filter: intercept all requests to Web App
        + using DelegatingFilterProxy
        + springSecurityFilterChain name will be mapped with a bean name in spring.
        + FilterChainProxy is target class of springSecurityFilterChain