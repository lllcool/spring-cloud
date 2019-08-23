package com.post.cloud.config;import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
@PropertySource("classpath:application-config-2.properties")
public class ConfigServer2 {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigServer2.class).web(true).run(args);
    }
}
