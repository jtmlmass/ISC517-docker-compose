package com.pucmm.composerprogram.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class generalController {
    @RequestMapping("/")
    public ModelAndView getIndex(){
        return new ModelAndView("redirect:/poll");
    }
}
