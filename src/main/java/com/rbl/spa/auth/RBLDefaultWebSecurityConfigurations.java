package com.rbl.spa.auth;

import com.xeoscript.spa.auth.providers.AbstractSPAStatusProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrationRepository;

@ComponentScan("com.idfc.spa.auth")
public abstract class RBLDefaultWebSecurityConfigurations extends RBLWebSecurityConfigurations<RBLUser> {

    RBLDefaultStatusProvider statusProvider = new RBLDefaultStatusProvider();

    protected final RBLSAMLAuthProvider samlAuthProvider;

    protected final RelyingPartyRegistrationRepository relyingPartyRegistrationRepository;

    public RBLDefaultWebSecurityConfigurations(
            RBLAuthenticationProvider authenticationProvider,
            RBLSAMLAuthProvider samlAuthProvider,
            RelyingPartyRegistrationRepository relyingPartyRegistrationRepository
    ) {
        super(authenticationProvider);
        this.samlAuthProvider = samlAuthProvider;
        this.relyingPartyRegistrationRepository = relyingPartyRegistrationRepository;
    }

    public RBLSAMLAuthProvider getSamlAuthenticationProvider() {
        return samlAuthProvider;
    }

    @Override
    protected String getSAMLLoginUrl() {
        return "/auth/saml2/login/";
    }

    @Override
    protected String getSAMLSignOnURL() {
        return "/saml2/authenticate/idfc";
    }

    @Override
    protected void configureSAML(HttpSecurity http, AuthenticationManager authManager, String loginURL) throws Exception {
        // https://gbpaymentsplatform.uat.idfcfirst.bank.in/epfo/dashboard/api/v1/saml2/authenticate/idfc
        // https://gbpaymentsplatform.uat.idfcfirst.bank.in/epfo/dashboard/api/v1/saml2/authenticate/idfc
        // https://gbpaymentsplatform.uat.idfcfirst.bank.in/epfo/dashboard/api/v1/auth/saml2/login/idfc

        http.saml2Login(saml2 -> saml2
                .authenticationManager(authManager)
                .relyingPartyRegistrationRepository(this.relyingPartyRegistrationRepository)
                .loginProcessingUrl(loginURL + "{registrationId}")
                .successHandler(this::sendSAMLAuthSuccessResponse)
        );
    }

    @Override
    protected AbstractSPAStatusProvider<RBLUser, RBLUser, RBLAuthenticationToken> statusProvider() {
        return statusProvider;
    }

}
