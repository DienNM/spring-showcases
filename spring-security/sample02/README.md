# Spring Security Example 02

Some notes on Spring Security 4:

    - CSRF is enabled by default
    
    
Case 1:

    - Using default Authentication
        + user-service tag: InMemoryUserDetailsManager >  UserDetailsManager
    - Customize form-login, logout
    
Case 2: Customize UserDetailsService

    - user-service: 
        + com.dee.spring.security.case2.service.DeeUserDetailsService
        + &lt; authentication-provider user-service-ref="deeUserDetailsService" /&gt;
    - authentication-provider:
        + use DaoAuthenticationProvider by default
        
Case 3: Customize AuthenticationProvider

    - DeeUserDetails that implements UserDetails and extends from DeeUser
    - Update DeeUserDetailsService to return DeeUserDetails
    - authentication-provider: using DeeAuthenticationProvider