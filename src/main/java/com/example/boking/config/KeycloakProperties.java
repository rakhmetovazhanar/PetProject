package com.example.boking.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Objects;


@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "keycloak")
public class KeycloakProperties implements InitializingBean {
    private String server;
    private String realm;
    private String resource;
    private Confidential confidential;

    @Override
    public void afterPropertiesSet() {
        Objects.requireNonNull(server);
        Objects.requireNonNull(realm);
        Objects.requireNonNull(resource);
        Objects.requireNonNull(confidential);
    }

    @Getter
    @Setter
    static class Confidential {

        private String password;

    }
}
