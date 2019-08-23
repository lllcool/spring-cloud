package com.post.cloud.service;import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableDiscoveryClient
@PropertySource("classpath:application-service-2.properties")
public class EurekaService2 {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaService2.class).web(true).run(args);
    }
}
