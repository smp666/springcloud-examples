package com.smp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudGatewaySimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewaySimpleApplication.class, args);
    }
    @Bean
    public RouteLocator customRouteLocater(RouteLocatorBuilder builder){
        return builder.routes()

                .route("path_route",r->r.path("/about")
                                    .uri("http://www.ityouknow.com"))
                .build();

    }
}
