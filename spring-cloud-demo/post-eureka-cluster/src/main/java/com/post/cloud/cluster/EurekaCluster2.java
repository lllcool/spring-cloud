package com.post.cloud.cluster;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableEurekaServer
@PropertySource("classpath:application-cluster-2.properties")
public class EurekaCluster2 {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaCluster2.class).web(true).run(args);
    }
}
