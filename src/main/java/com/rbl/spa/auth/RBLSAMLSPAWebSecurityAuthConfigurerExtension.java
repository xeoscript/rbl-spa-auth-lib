package com.rbl.spa.auth;

import com.xeoscript.spa.auth.saml.SAMLSPAWebSecurityAuthConfigurerExtension;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrationRepository;
import org.springframework.stereotype.Component;

@Component
public class RBLSAMLSPAWebSecurityAuthConfigurerExtension
        extends SAMLSPAWebSecurityAuthConfigurerExtension<RBLUser, RBLAuthenticationToken, RBLSAMLAuthProvider> {


    public RBLSAMLSPAWebSecurityAuthConfigurerExtension(
            RBLSAMLAuthProvider samlAuthenticationProvider,
            RelyingPartyRegistrationRepository relyingPartyRegistrationRepository
    ) {
        super(samlAuthenticationProvider, relyingPartyRegistrationRepository);
    }

    @Override
    protected String ssoRedirectURL() {
        return "/saml2/authenticate/rbl";
    }

}
