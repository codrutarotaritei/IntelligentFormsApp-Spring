package com.cobraTeam.intelligentFormsApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/greetings")
public class WelcomeController {

    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping(path = "/goodbye")
    public String goodbye() {
        return "Bye, bye!";
    }
}
