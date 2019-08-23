package com.post.cloud.reference.feign;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaReferenceFeignController {
    @Autowired
    private EurekaReferenceFeignClient feignClient;

    // http://localhost:3333/getUser2
    @RequestMapping(value = "/getUser2", method = RequestMethod.GET)
    public String getUser() {
        return feignClient.getUser("Zhangsan");
    }

    // http://localhost:3333/add2
    @RequestMapping(value = "/add2", method = RequestMethod.GET)
    public Integer add() {
        return feignClient.add(10, 20);
    }
}
