package kr.huny.site.web;

import kr.huny.site.domain.web.user.UserWrite;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by sousic on 2017. 3. 8..
 */
@Slf4j
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

        //model.addAttribute("loginID", loginID);
        //model.addAttribute("fail",true);

        return "auth/login";
    }

    @RequestMapping(value = "login_duplicate", method = RequestMethod.GET)
    public void login_duplicate() {

    }

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String register()
    {
        return "user/join";
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String registerPost(@ModelAttribute @Valid UserWrite userWrite, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors()) {
            log.debug("[1]result = " + bindingResult);
            model.addAttribute(userWrite);
            return "user/join";
        }

        if(!userWrite.getPwd().equals(userWrite.getPwdConfirm())) {
            bindingResult.reject("pwdConfirm");
            model.addAttribute("pwdConfirm", true);
        }

        if(bindingResult.hasErrors()) {
            log.debug("[2]result = " + bindingResult);
            model.addAttribute(userWrite);
            return "user/join";
        }

        return "user/join";
    }
}
