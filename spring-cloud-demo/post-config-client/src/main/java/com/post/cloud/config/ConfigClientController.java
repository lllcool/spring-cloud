package com.post.cloud.config;import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigClientController {
    @Value("${my-config.appName}")
    private String appName;

    // http://localhost:5557/appName
    @RequestMapping("/appName")
    public String appName() {
        return appName;
    }
}
