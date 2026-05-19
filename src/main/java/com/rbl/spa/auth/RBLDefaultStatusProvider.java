package com.rbl.spa.auth;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class RBLDefaultStatusProvider extends RBLStatusProvider<RBLUser> {

    @Override
    protected RBLUser getStatus(RBLUser user, Collection<? extends GrantedAuthority> authorities) {
        return user;
    }
}
