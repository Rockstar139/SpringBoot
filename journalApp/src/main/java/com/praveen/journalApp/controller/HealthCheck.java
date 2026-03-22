package com.praveen.journalApp.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HealthCheck {
    
    @GetMapping("/health-check")
    public String healthCheck(){
        return "OK";
    }
}
