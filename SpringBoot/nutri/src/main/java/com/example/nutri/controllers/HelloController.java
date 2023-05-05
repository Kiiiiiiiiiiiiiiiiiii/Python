package com.example.nutri.controllers;

import com.example.nutri.services.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
@RestController
public class HelloController {
    HelloService helloService = new HelloService();

    @GetMapping("/hello")
    public String hello(String name){
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
