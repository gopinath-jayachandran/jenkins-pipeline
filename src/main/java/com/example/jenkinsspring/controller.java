package com.example.jenkinsspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("")
    public String index() {
        return "Hello Peoples";
    }
}
