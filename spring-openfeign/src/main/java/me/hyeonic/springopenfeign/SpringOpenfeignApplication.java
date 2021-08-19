package me.hyeonic.springopenfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringOpenfeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringOpenfeignApplication.class, args);
    }

}