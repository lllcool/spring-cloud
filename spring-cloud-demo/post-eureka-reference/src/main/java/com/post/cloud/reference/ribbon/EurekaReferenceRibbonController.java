package com.post.cloud.reference.ribbon;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EurekaReferenceRibbonController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.cluster.name}")
    private String serviceClusterName;

    // http://localhost:3333/getUser1
    @RequestMapping(value = "/getUser1", method = RequestMethod.GET)
    public String getUser() {
        return restTemplate.getForEntity("http://" + serviceClusterName + "/getUser?name=Zhangsan", String.class).getBody();
    }

    // http://localhost:3333/add1
    @RequestMapping(value = "/add1", method = RequestMethod.GET)
    public String add() {
        return restTemplate.getForEntity("http://" + serviceClusterName + "/add?a=10&b=20", String.class).getBody();
    }
}
