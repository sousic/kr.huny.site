package kr.huny.site.web.manager;

import kr.huny.site.domain.db.User.Authority;
import kr.huny.site.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sousic on 2017-04-28.
 */
@Controller
@RequestMapping(value = "/tools/authority")
public class AuthorityController {

    @Autowired
    AuthorityService authorityService;

    @RequestMapping(value = "/")
    public String Default()
    {
        return "redirect:/tools/authority/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String AuthorityList(Model model, @PageableDefault(direction = Sort.Direction.DESC, size = 10, sort = { "authority" }) Pageable pageable)
    {
        Page<Authority> authorities = authorityService.authorityFindAll(pageable);
        model.addAttribute("authorities",authorities);
        return "tools/authority/list";
    }
}
