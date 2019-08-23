package com.post.cloud.oauth.authentication;import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class OAuthAuthenticationProvider implements AuthenticationProvider {
    private static final Logger LOG = LoggerFactory.getLogger(OAuthAuthenticationProvider.class);

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Object principal = authentication.getPrincipal();
        Object credentials = authentication.getCredentials();

        LOG.info("Principal={}, Credentials={}", principal, credentials);

        /*if (!StringUtils.equals(principal.toString(), "admin") || !StringUtils.equals(credentials.toString(), "123")) {
            return null;
        }*/

        // 返回一个Token对象表示登陆成功
        return new UsernamePasswordAuthenticationToken(principal, credentials, Collections.<GrantedAuthority> emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
