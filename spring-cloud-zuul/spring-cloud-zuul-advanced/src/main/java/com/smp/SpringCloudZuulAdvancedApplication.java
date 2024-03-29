package com.smp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SpringCloudZuulAdvancedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulAdvancedApplication.class, args);
    }

}
