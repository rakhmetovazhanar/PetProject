package com.example.boking.config;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.authorization.client.AuthzClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class KeycloakConfig {
    @Autowired
    private KeycloakProperties keycloakProperties;

    @Bean
    public Keycloak keycloak() {
        return KeycloakBuilder.builder()
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .serverUrl(keycloakProperties.getServer())
                .realm(keycloakProperties.getRealm())
                .clientId(keycloakProperties.getResource()) // NPE -> NullPointerException
                .clientSecret(keycloakProperties.getConfidential().getPassword())
                .build();
    }

    @Bean
    public AuthzClient authzClient() {
        return AuthzClient.create();
    }
}
