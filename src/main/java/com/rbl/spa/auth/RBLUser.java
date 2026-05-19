package com.rbl.spa.auth;

import com.xeoscript.spa.auth.models.AbstractSPAUser;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RBLUser extends AbstractSPAUser {

    String givenName;

    String surName;

    String username;

    String name;

    String mail;

    List<String> groups;

    @Override
    public String toString() {
        return username;
    }
}
