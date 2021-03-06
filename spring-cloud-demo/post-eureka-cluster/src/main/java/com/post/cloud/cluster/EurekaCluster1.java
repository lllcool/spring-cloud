package com.post.cloud.cluster;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableEurekaServer
@PropertySource("classpath:application-cluster-1.properties")
public class EurekaCluster1 {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaCluster1.class).web(true).run(args);
    }
}
