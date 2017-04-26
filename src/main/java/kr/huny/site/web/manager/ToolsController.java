package kr.huny.site.web.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sousic on 2017-03-23.
 */
@Controller
@RequestMapping(value = "/tools")
public class ToolsController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Home()
    {
        return "tools/home";
    }
}
