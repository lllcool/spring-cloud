package com.post.cloud.service;import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableDiscoveryClient
@PropertySource("classpath:application-service-1.properties")
public class ZookeeperService1 {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ZookeeperService1.class).web(true).run(args);
    }
}
