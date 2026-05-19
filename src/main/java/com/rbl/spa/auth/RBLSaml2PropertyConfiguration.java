package com.rbl.spa.auth;

import com.xeoscript.env.Config;
import com.xeoscript.env.EnvConfiguration;

@EnvConfiguration
public interface RBLSaml2PropertyConfiguration {


    @Config(name = "rbl.saml-service-name")
    String serviceName();

    @Config(name = "rbl.saml-entity-id")
    String entityID();

    @Config(name = "rbl.sml-metadata-path")
    String metadataPath();

    @Config(name = "rbl.saml-acs-url")
    String acsURL();


}
