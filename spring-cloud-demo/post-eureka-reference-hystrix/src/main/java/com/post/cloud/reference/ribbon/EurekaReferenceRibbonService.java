package com.post.cloud.reference.ribbon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class EurekaReferenceRibbonService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.cluster.name}")
    private String serviceClusterName;

    private static final Logger LOG = LoggerFactory.getLogger(EurekaReferenceRibbonService.class);

    @HystrixCommand(fallbackMethod = "getUserFallback")
    public String getUser() {
        return restTemplate.getForEntity("http://" + serviceClusterName + "/getUser?name=Zhangsan", String.class).getBody();
    }

    public String getUserFallback() {
        LOG.info("into fallback");
        return "getUser fallback";
    }

    @HystrixCommand(fallbackMethod = "addFallback")
    public String add() {
        return restTemplate.getForEntity("http://" + serviceClusterName + "/add?a=10&b=20", String.class).getBody();
    }

    public Integer addFallback() {
        return -9999;
    }
}
