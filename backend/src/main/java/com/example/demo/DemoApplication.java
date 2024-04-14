package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RestController
    public static class HelloController {
        @GetMapping("/")
        public String home() {
            log.info("hello route was called");
            return "Hello, Spring Boot with Java 17!";
        }
    }

    @RestController
    public static class InfoController {
        @GetMapping("/api")
        public Person info() {
            log.info("info route was called");
            return new Person(
                    "Rohit Khapre",
                    24,
                    "DevOps Engineer",
                    2
            );
        }
    }
}

