package com.vivolvle.fundation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FundationApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundationApplication.class, args);
    }

}
