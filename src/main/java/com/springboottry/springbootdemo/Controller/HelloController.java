package com.springboottry.springbootdemo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// controller as a component and will always return a response body
@RestController
public class HelloController {

    // map the endpoint
    @GetMapping("/")
    public String helloWorld() {
        return "Hello Test";
    }
}
