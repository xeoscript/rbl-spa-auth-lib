package com.rbl.spa.auth;

import com.xeoscript.spa.auth.saml.Saml2Configuration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class RBLSaml2Configuration extends Saml2Configuration<RBLSaml2PropertyConfiguration> {

    public RBLSaml2Configuration(RBLSaml2PropertyConfiguration config) {
        super(config);
    }
}
