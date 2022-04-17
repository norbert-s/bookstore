package com.norbert.susztek.bookstore.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Secured("ROLE_USER")
    @GetMapping("/")
    public String getHome(){
        return "books/home";
    }
}
