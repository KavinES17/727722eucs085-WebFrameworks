package com.example.ce1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    @Value("${app.name}")
    public String appName;

    @Value("${app.version}")
    public String appVersion;
    
}
