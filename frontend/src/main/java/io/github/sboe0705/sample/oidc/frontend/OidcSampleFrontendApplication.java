package io.github.sboe0705.sample.oidc.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(UserClientProperties.class)
public class OidcSampleFrontendApplication {

    public static void main(String[] args) {
        SpringApplication.run(OidcSampleFrontendApplication.class, args);
    }

}
