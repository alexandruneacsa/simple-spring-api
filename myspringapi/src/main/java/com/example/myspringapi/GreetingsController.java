package com.example.myspringapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/welcome")
public class GreetingsController {

    @GetMapping
    public String welcome(){
        return "Welcome!";
    }

    @GetMapping(path = "/hello")
    public String hello(){
        return "Hello!";
    }

    @GetMapping(path = "/bye")
    public String bye(){
        return "Goodbye!";
    }
}
