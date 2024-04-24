package com.example.gateway.Config;

import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@AllArgsConstructor
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-service", r -> r.path("/auth/**")
                        .uri("lb://auth-service"))
                .route("Order-Services", r -> r.path("/order/**")
                        .uri("lb://Order-Services"))
                .route("Paiement-Services", r -> r.path("/paiement/**")
                        .uri("lb://Paiement-Services"))
                .route("Products-Services", r -> r.path("/catalogs/**")
                        .uri("lb://Products-Services"))
                .build();
    }
}