package com.rbl.spa.auth;

import com.xeoscript.spa.auth.providers.AbstractSPAStatusProvider;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.rbl.spa.auth")
public abstract class RBLDefaultWebSecurityConfigurations extends RBLWebSecurityConfigurations<RBLUser> {

    RBLDefaultStatusProvider statusProvider = new RBLDefaultStatusProvider();

    public RBLDefaultWebSecurityConfigurations(
            RBLAuthenticationProvider authenticationProvider
    ) {
        super(authenticationProvider);
    }

    @Override
    protected AbstractSPAStatusProvider<RBLUser, RBLUser, RBLAuthenticationToken> statusProvider() {
        return statusProvider;
    }

}
