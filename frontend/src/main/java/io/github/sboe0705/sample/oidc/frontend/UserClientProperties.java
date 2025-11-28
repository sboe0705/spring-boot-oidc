package io.github.sboe0705.sample.oidc.frontend;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.clients.users")
public record UserClientProperties(
        String host,
        int port,
        String registrationId
) implements ClientProperties {
}
