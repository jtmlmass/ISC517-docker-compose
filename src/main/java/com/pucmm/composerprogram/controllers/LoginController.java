package com.pucmm.composerprogram.controllers;

import com.pucmm.composerprogram.services.SecurityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    private final SecurityService securityService;

    public LoginController(SecurityService securityService){
        this.securityService = securityService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage() {
        return new ModelAndView("login");
    }
}
