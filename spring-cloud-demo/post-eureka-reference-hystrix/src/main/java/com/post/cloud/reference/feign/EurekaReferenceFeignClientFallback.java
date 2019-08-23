package com.post.cloud.reference.feign;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class EurekaReferenceFeignClientFallback implements EurekaReferenceFeignClient {
    private static final Logger LOG = LoggerFactory.getLogger(EurekaReferenceFeignClientFallback.class);
    @Override
    public String getUser(@RequestParam(value = "name") String name) {
        LOG.info("into fallback2");

        return null;
    }

    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -9999;
    }
}

