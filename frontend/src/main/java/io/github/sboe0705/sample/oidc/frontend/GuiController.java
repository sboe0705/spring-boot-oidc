package io.github.sboe0705.sample.oidc.frontend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuiController {

    private static final Logger logger = LoggerFactory.getLogger(GuiController.class);

    private final UsersClient usersClient;

    public GuiController(UsersClient usersClient) {
        this.usersClient = usersClient;
    }

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser user, @RegisteredOAuth2AuthorizedClient("sample") OAuth2AuthorizedClient client) {
        logger.info("Logged in user: {} ({})", user.getFullName(), user.getPreferredUsername());
        logger.info("Used ID token: {}", user.getIdToken().getTokenValue());
        String accessToken = client.getAccessToken().getTokenValue();
        logger.info("Used Access token (for registration \"{}\"): {}", client.getClientRegistration().getRegistrationId(), accessToken);
        UserInfo userInfo = usersClient.getUserInfo();
        model.addAttribute("user", userInfo);
        return "index";
    }

}
