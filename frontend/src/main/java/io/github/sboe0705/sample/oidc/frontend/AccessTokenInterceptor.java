package io.github.sboe0705.sample.oidc.frontend;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

import java.io.IOException;

public class AccessTokenInterceptor implements ClientHttpRequestInterceptor {

    private final OAuth2AuthorizedClientManager manager;

    private final String registrationId;

    public AccessTokenInterceptor(OAuth2AuthorizedClientManager manager, String registrationId) {
        this.manager = manager;
        this.registrationId = registrationId;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        OAuth2AuthorizedClient authorizedClient = manager.authorize(
                OAuth2AuthorizeRequest.withClientRegistrationId(registrationId)
                        .principal(SecurityContextHolder.getContext().getAuthentication())
                        .build()
        );
        String accessToken = authorizedClient.getAccessToken().getTokenValue();
        request.getHeaders().setBearerAuth(accessToken);
        return execution.execute(request, body);
    }

}
