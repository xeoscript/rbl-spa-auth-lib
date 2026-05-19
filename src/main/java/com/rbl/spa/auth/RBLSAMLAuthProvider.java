package com.rbl.spa.auth;

import com.xeoscript.spa.auth.saml.AbstractSPASAMLAuthenticationProvider;
import com.xeoscript.spa.auth.saml.SAMLAttributeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class RBLSAMLAuthProvider extends
        AbstractSPASAMLAuthenticationProvider<RBLUser, RBLAuthenticationToken> {

    @Override
    protected RBLUser getUser(Saml2Authentication samlAuth) {
        log.info("Logged in User : {}", samlAuth);

        Object principal = samlAuth.getPrincipal();
        log.info("Principal : {}", principal);

        Saml2AuthenticatedPrincipal saml2Principal = (Saml2AuthenticatedPrincipal) principal;
        Map<String, List<Object>> attributes = saml2Principal.getAttributes();
        log.info("SAML2 Principal Name : {}", saml2Principal.getName());
        log.info("SAML2 Principal Attributes : {}", attributes);

        Map<String, Object> newMap = SAMLAttributeUtils.mapSAMLAttributes(attributes);

        Object groupsObject = newMap.get("groups");
        log.info("Type of groups: {}", groupsObject.getClass().getName());

        ArrayList<String> groups = (ArrayList<String>) groupsObject;

        String givenName = newMap.get("givenname").toString();
        String surname = newMap.get("surname").toString();
        String displayname = newMap.get("displayname").toString();
        String emailaddress = newMap.get("emailaddress").toString();

        int index = emailaddress.indexOf("@");
        String username = emailaddress.substring(0, index);

        RBLUser user = new RBLUser();
        user.setGivenName(givenName);
        user.setSurName(surname);
        user.setUsername(username);
        user.setName(displayname);
        user.setMail(emailaddress);
        user.setGroups(groups);


        return user;
    }

    @Override
    protected RBLAuthenticationToken getToken(RBLUser user) {
        return new RBLAuthenticationToken(user);
    }
}
