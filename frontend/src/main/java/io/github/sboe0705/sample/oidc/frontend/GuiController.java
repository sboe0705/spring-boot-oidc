package io.github.sboe0705.sample.oidc.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuiController {

    @Autowired
    private UsersClient usersClient;

    @GetMapping("/")
    public String index(Model model) {
        UserInfo userInfo = usersClient.getUserInfo();
        model.addAttribute("user", userInfo);
        return "index";
    }

}
