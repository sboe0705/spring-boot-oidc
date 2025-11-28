package io.github.sboe0705.sample.oidc.frontend;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateFactory {

    private final RestTemplateBuilder restTemplateBuilder;

    private final OAuth2AuthorizedClientManager manager;

    public RestTemplateFactory(RestTemplateBuilder restTemplateBuilder,
                               OAuth2AuthorizedClientManager manager) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.manager = manager;
    }

    public RestTemplate create(ClientProperties clientProperties) {
        return restTemplateBuilder
                .rootUri("http://%s:%s".formatted(clientProperties.host(), clientProperties.port()))
                .additionalInterceptors(new AccessTokenInterceptor(manager, clientProperties.registrationId()))
                .build();
    }

}
