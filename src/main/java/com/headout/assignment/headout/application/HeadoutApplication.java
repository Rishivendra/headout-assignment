package com.headout.assignment.headout.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.headout.assignment.headout")
public class HeadoutApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeadoutApplication.class, args);
    }

}
