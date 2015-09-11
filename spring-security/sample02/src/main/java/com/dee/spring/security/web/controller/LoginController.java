package com.dee.spring.security.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dee.spring.security.model.DeeUser;
import com.dee.spring.security.service.DeeUserService;
import com.dee.spring.security.web.dto.UserLogin;

/**
 * @author dien.nguyen
 **/

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    
    @Autowired
    @Qualifier("inMemoryDeeUserService")
    private DeeUserService deeUserService;
    
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String setUpLoginForm(Model model) {
        model.addAttribute("user", new UserLogin());
        return "login";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String setUpRegisterForm(Model model) {
        model.addAttribute("user", new DeeUser());
        return "register";
    }
    
    @RequestMapping(value = "/register/submit", method = RequestMethod.POST)
    public String submitRegister(@ModelAttribute("user") DeeUser user) {
        deeUserService.add(user);
        return "redirect:/comments";
    }
}
