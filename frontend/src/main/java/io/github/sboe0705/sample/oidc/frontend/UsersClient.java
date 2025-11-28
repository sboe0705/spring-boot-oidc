package io.github.sboe0705.sample.oidc.frontend;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UsersClient {

    private final RestTemplate restTemplate;

    public UsersClient(UserClientProperties userClientProperties, RestTemplateFactory restTemplateFactory) {
        restTemplate = restTemplateFactory.create(userClientProperties);
    }

    public UserInfo getUserInfo() {
        return restTemplate.getForObject("/user", UserInfo.class);
    }

}
