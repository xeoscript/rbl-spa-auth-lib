package com.rbl.spa.auth;

import com.xeoscript.spa.auth.saml.SAMLSPAWebSecurityAuthConfigurerExtension;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrationRepository;
import org.springframework.stereotype.Component;

@Component
public class RBLSAMLSPAWebSecurityAuthConfigurerExtension
        extends SAMLSPAWebSecurityAuthConfigurerExtension<RBLUser, RBLSaml2PropertyConfiguration, RBLAuthenticationToken, RBLSAMLAuthProvider> {


    public RBLSAMLSPAWebSecurityAuthConfigurerExtension(
            RBLSaml2PropertyConfiguration configuration,
            RBLSAMLAuthProvider samlAuthenticationProvider,
            RelyingPartyRegistrationRepository relyingPartyRegistrationRepository
    ) {
        super(configuration, samlAuthenticationProvider, relyingPartyRegistrationRepository);
    }

}
