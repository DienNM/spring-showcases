package com.dee.spring.security.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dee.spring.security.web.dto.UserLogin;

/**
 * @author dien.nguyen
 **/

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String setUpLoginForm(Model model) {
        model.addAttribute("user", new UserLogin());
        return "login";
    }
}
