package com.rbl.spa.auth;

import com.xeoscript.env.Config;
import com.xeoscript.env.EnvConfiguration;
import com.xeoscript.spa.auth.saml.Saml2PropertyConfiguration;

@EnvConfiguration
public interface RBLSaml2PropertyConfiguration extends Saml2PropertyConfiguration {


    @Config(name = "rbl.saml-service-name")
    String serviceName();

    @Config(name = "rbl.saml-entity-id")
    String entityID();

    @Config(name = "rbl.saml-metadata-path")
    String metadataPath();

    @Config(name = "rbl.saml-acs-url")
    String acsURL();


}
