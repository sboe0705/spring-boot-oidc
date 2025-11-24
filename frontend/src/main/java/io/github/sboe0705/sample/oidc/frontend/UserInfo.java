package io.github.sboe0705.sample.oidc.frontend;

import java.util.List;

public record UserInfo(String name, String role, List<String> permissions) {

}
