package com.rbl.spa.auth;

import com.xeoscript.unisessions.util.AuthenticationTokenFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@ConditionalOnClass(name = "com.xeoscript.unisessions.util.AuthenticationTokenFactory")
public class RBLAuthenticationTokenFactory implements AuthenticationTokenFactory {

    @Override
    public boolean supports(Object principal) {
        return principal instanceof RBLUser;
    }

    @Override
    public Authentication createAuthentication(Object principal, Collection<? extends GrantedAuthority> authorities) {
        if (principal instanceof RBLUser) {
            String[] permissions = authorities.stream()
                    .map(GrantedAuthority::getAuthority)
                    .toArray(String[]::new);

            RBLUser user = (RBLUser) principal;

            return new RBLAuthenticationToken(user, permissions);
        }

        return null;
    }
}
