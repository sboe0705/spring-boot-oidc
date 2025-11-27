package io.github.sboe0705.sample.oidc.frontend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuiController {

    private static final Logger logger = LoggerFactory.getLogger(GuiController.class);

    @Autowired
    private UsersClient usersClient;

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser user) {
        logger.info("Logged in user: {} ({})", user.getFullName(), user.getPreferredUsername());
        logger.info("Used JWT: {}", user.getIdToken().getTokenValue());
        UserInfo userInfo = usersClient.getUserInfo();
        model.addAttribute("user", userInfo);
        return "index";
    }

}
