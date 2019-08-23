package com.post.cloud.oauth;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableOAuth2Sso
public class OAuthClient {
    public static void main(String[] args) {
        new SpringApplicationBuilder(OAuthClient.class).web(true).run(args);
    }
}
