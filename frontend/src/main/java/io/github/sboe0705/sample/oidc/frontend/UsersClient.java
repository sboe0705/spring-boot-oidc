package io.github.sboe0705.sample.oidc.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UsersClient {

    private RestTemplate restTemplate;

    public UsersClient(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public UserInfo getUserInfo() {
        return restTemplate.getForObject(
                "http://localhost:8081/user",
                UserInfo.class
        );
    }

}
