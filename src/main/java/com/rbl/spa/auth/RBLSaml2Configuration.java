package com.rbl.spa.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.saml2.provider.service.registration.InMemoryRelyingPartyRegistrationRepository;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistration;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrationRepository;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrations;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class RBLSaml2Configuration {

    private final RBLSaml2PropertyConfiguration config;

    @Bean
    public RelyingPartyRegistrationRepository relyingPartyRegistrationRepository() {

        log.info("Loading Azure Bank SAML metadata");

        String metadataPath = config.metadataPath();
        String acsURL = config.acsURL();
        String entityID = config.entityID();
        String serviceName = config.serviceName();
        log.info("Metadata Path: {}", metadataPath);
        log.info("ACS URL: {}", acsURL);
        log.info("Entity ID: {}", entityID);
        log.info("Service Name: {}", serviceName);
        log.info("Base URL: {}", "{baseUrl}");

        RelyingPartyRegistration registration =
                RelyingPartyRegistrations
                        .fromMetadataLocation("classpath:" + metadataPath)
                        .registrationId(serviceName)
                        .entityId(entityID)
                        .assertionConsumerServiceLocation("{baseUrl}" + acsURL + serviceName)
                        .build();

        return new InMemoryRelyingPartyRegistrationRepository(registration);
    }
}
