package kr.huny.site.web.manager;

import kr.huny.site.common.Helper.PageableHelper;
import kr.huny.site.domain.db.User.User;
import kr.huny.site.domain.web.CommonResp;
import kr.huny.site.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sousic on 2017. 5. 8..
 */
@Slf4j
@Controller
@RequestMapping(value = "/tools/member")
public class MemberController {
    Sort sorted = new Sort("id");

    @Autowired
    UserService userService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public String Default()
    {
        return "redirect:/tools/member/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model, @PageableDefault(direction = Sort.Direction.DESC, sort = "id") Pageable pageable)
    {
        CommonResp<User> userList = new CommonResp<>(userService.findAll(PageableHelper.getPageRequest(pageable)));
        model.addAttribute("userList", userList);
        return "tools/member/list";
    }
}
