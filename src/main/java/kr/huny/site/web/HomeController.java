package kr.huny.site.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.RequestWrapper;

/**
 * Created by sousic on 2017-03-23.
 */
@Controller
public class HomeController {

    @RequestMapping(value="/")
    public String Default()
    {
        return "redirect:/home";
    }


    @RequestMapping(value = "/home")
    public String Home()
    {
        return "home/home";
    }
}
