package com.rbl.spa.auth;

import com.xeoscript.spa.auth.providers.AbstractSPAAuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RBLAuthenticationProvider
        extends AbstractSPAAuthenticationProvider<RBLUser, RBLAuthenticationToken> {

    Map<String, RBLUser> users = new HashMap<>();

    @Override
    protected RBLAuthenticationToken getToken(RBLUser user) {
        return new RBLAuthenticationToken(user);
    }

    @Override
    protected RBLUser authenticate(String username, String password) {
        return getUser(username, password);
    }

    protected void addUser(String username, String name, String mail, String givenName, String surName) {
        RBLUser user = new RBLUser();

        user.setUsername(username);
        user.setName(name);
        user.setGivenName(givenName);
        user.setSurName(surName);
        user.setMail(mail);

        users.put(username, user);
    }

    public RBLUser getUser(String username, String password) throws BadCredentialsException {
        if (users.containsKey(username) && password.equals("q1w2e3r4")) {
            return users.get(username);
        }
        return null;
    }
}
