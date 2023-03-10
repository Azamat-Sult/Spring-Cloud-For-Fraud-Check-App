package ru.antifraud.fraudcheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@EnableEurekaClient
@PropertySources({
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
@SpringBootApplication
public class FraudCheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(FraudCheckApplication.class, args);
    }

}