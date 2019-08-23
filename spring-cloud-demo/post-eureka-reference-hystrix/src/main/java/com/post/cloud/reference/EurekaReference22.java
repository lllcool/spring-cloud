package com.post.cloud.reference;import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class EurekaReference22 {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaReference22.class).web(true).run(args);
    }
}
