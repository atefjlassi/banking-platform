package com.bank.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    /**
     *
     * @param reactiveDiscoveryClient
     * @param locatorProperties
     * @return
     *
     * create this bean to satisfy the dynamic routing between microservices
     */
    @Bean
    DiscoveryClientRouteDefinitionLocator locator(ReactiveDiscoveryClient reactiveDiscoveryClient,
                                                  DiscoveryLocatorProperties locatorProperties) {
        return new DiscoveryClientRouteDefinitionLocator(reactiveDiscoveryClient, locatorProperties);
    }
}
