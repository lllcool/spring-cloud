package com.post.cloud.oauth.controller;import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 自定义的认证错误页
 */
@Controller
@SessionAttributes("authorizationRequest")
public class OAuthErrorController {
    private static final Logger LOG = LoggerFactory.getLogger(OAuthErrorController.class);

    @RequestMapping("/oauth/error")
    public String error(@RequestParam Map<String, String> parameters) {
        String uri = parameters.get("redirect_uri");

        LOG.info("重定向: {}", uri);

        return "redirect:" + uri + "?error=1";
    }
}
