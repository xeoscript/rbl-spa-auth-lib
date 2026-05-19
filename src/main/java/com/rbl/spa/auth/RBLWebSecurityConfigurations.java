package com.rbl.spa.auth;


import com.xeoscript.spa.auth.services.SPAWebSecurityConfigurerAdapter;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.rbl.spa.auth")
public abstract class RBLWebSecurityConfigurations<Status>
        extends SPAWebSecurityConfigurerAdapter<Status, RBLUser, RBLAuthenticationToken> {

    private final RBLAuthenticationProvider authenticationProvider;

    public RBLWebSecurityConfigurations(RBLAuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
        loadUsers();
    }


    protected abstract void loadUsers();

    protected void addUser(String username, String name, String mail, String givenName, String surName) {
        authenticationProvider.addUser(username, name, mail, givenName, surName);
    }

    @Override
    protected RBLAuthenticationProvider getAuthenticationProvider() {
        return authenticationProvider;
    }
}
