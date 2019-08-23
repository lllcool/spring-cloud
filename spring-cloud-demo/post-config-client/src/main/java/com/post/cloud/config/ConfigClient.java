package com.post.cloud.config;import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ConfigClient {
    private static final Logger LOG = LoggerFactory.getLogger(ConfigClient.class);

    @Autowired
    public void setEnviroment(Environment env) {
        LOG.info("my-config.appName from env={}", env.getProperty("my-config.appName"));
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigClient.class).web(true).run(args);
    }
}
