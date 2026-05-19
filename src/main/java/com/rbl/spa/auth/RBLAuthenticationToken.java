package com.rbl.spa.auth;

import com.xeoscript.spa.auth.models.AbstractSPAAuthentication;

@SuppressWarnings("unused")
public class RBLAuthenticationToken extends AbstractSPAAuthentication<RBLUser> {

    public RBLAuthenticationToken(RBLUser user, boolean authenticated) {
        super(user, authenticated);
    }

    public RBLAuthenticationToken(RBLUser user) {
        super(user);
    }

    public RBLAuthenticationToken(RBLUser user, String[] authorities) {
        super(user, authorities);
    }

}
