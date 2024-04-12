package com.example.ce1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ce1.config.AppConfig;

@RestController
public class ApiController {
    @Autowired
    public AppConfig config;
    @GetMapping("/info")
    public String getInfo() {
        return "App Name: " + config.appName + ", App Version: " + config.appVersion;
    }
    
}
