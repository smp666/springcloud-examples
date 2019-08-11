package com.smp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudConfigClient2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClient2Application.class, args);
    }

}
