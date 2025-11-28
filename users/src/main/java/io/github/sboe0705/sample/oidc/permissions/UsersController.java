package io.github.sboe0705.sample.oidc.permissions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private PermissionsClient permissionsClient;

    @GetMapping("/user")
    public UserInfo getUserInfo(@AuthenticationPrincipal Jwt jwt) {
        String name = jwt.getClaimAsString("name");
        List<String> permissions = permissionsClient.getPermissions();
        return new UserInfo(name, "role", permissions);
    }

}
