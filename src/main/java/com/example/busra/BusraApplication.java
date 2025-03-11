package com.example.busra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.example.busra")
public class BusraApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusraApplication.class, args);
    }

}
