package com.example.maven_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello() {
        return "<h1>Hello, World!</h1><p>This is test app</p>";
    }
}
