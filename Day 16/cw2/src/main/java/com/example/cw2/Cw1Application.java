package com.example.cw2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.cw2.service.MyService;

@SpringBootApplication
public class Cw1Application implements CommandLineRunner {

    @Autowired
    private MyService myService;

    public static void main(String[] args) {
        SpringApplication.run(Cw1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Final Result: " + myService.process("Hello, Spring AOP!"));
    }
}
