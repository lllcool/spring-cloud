package com.post.cloud.reference.feign;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaReferenceFeign2Controller {
    @Autowired
    private EurekaReferenceFeignClient feignClient;

    private static final Logger LOG = LoggerFactory.getLogger(EurekaReferenceFeign2Controller.class);

    // http://localhost:3333/getUser2
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    @RequestMapping(value = "/getUser3", method = RequestMethod.GET)
    public String getUser() {
        return feignClient.getUser("Zhangsan");
    }

    // http://localhost:3333/add2
    @RequestMapping(value = "/add2", method = RequestMethod.GET)
    public Integer add() {
        return feignClient.add(10, 20);
    }



    private String saveOrderFail(){
        LOG.info("controller中的降级方法");
        return( "抢购人数太多，您被挤出来了，稍等重试");

    }
}
