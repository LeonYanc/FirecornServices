package com.example.nosecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class NosecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(NosecurityApplication.class, args);
    }

}
