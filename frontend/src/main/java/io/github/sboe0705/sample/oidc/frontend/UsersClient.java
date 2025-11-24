package io.github.sboe0705.sample.oidc.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UsersClient {

    @Value("${app.clients.users.host}")
    private String host;

    @Value("${app.clients.users.port}")
    private int port;

    private final RestTemplate restTemplate;

    public UsersClient(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public UserInfo getUserInfo() {
        return restTemplate.getForObject(
                "http://%s:%d/user".formatted(host, port),
                UserInfo.class
        );
    }

}
