package io.github.sboe0705.sample.oidc.permissions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PermissionsClient {

    @Value("${app.clients.permissions.host}")
    private String host;

    @Value("${app.clients.permissions.port}")
    private int port;

    private final RestTemplate restTemplate;

    public PermissionsClient(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public List<String> getPermissions() {
        return restTemplate.exchange(
                "http://%s:%d/permissions".formatted(host, port),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {
                }
        ).getBody();
    }

}
