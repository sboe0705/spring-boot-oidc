package io.github.sboe0705.sample.oidc.permissions;

import java.util.List;

public record UserInfo(String name, String role, List<String> permissions) {

}
