package io.github.sboe0705.sample.oidc.permissions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PermissionsController {

    private final Map<String, List<String>> permissionsByRoles = Map.of(
            "user", List.of("view", "add", "edit"),
            "manager", List.of("approve", "report"),
            "admin", List.of("configure")
    );

    @GetMapping("/permissions")
    public List<String> getPermissions(/*Principal principal*/) {
        String role = "user";
        return permissionsByRoles.get(role);
    }

}
