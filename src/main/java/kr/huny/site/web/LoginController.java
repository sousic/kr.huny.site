package kr.huny.site.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by sousic on 2017. 3. 8..
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login()
    {
        return "auth/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String loginID, @RequestParam String loginPWD, Model model)
    {
        model.addAttribute("loginID", loginID);
        model.addAttribute("fail",true);

        return "auth/login";
    }
}
