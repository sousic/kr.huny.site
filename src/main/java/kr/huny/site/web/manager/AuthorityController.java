package kr.huny.site.web.manager;

import kr.huny.site.common.Helper.PageableHelper;
import kr.huny.site.domain.db.User.Authority;
import kr.huny.site.domain.web.CommonPageResp;
import kr.huny.site.domain.web.CommonResp;
import kr.huny.site.service.AuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sousic on 2017-04-28.
 */
@Slf4j
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
    public String AuthorityList(Model model, @PageableDefault(direction = Sort.Direction.DESC, sort = "authority") Pageable pageable)
    {
        Page<Authority> authorities = authorityService.findAll(PageableHelper.getPageRequest(pageable));
        CommonPageResp<Authority> authorityResp = new CommonPageResp<>(authorities);

        model.addAttribute("authorities", authorityResp);
        return "tools/authority/list";
    }

    @RequestMapping(value = "/list/json", method = RequestMethod.GET)
    @ResponseBody
    public Object getJSONAuthorityList(@PageableDefault(direction = Sort.Direction.DESC, sort = "authority") Pageable pageable)
    {
        Page<Authority> authorities = authorityService.findAll(PageableHelper.getPageRequest(pageable));

        CommonPageResp<Authority> authorityResp = new CommonPageResp<>(authorities);

        return authorityResp;
    }

    @RequestMapping(value = "/authority/update", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public Object updateAuthority(Authority authority)
    {
        log.info(authority.toString());
        CommonResp commonResp = CommonResp.builder().errCode(1).build();

        try {
            authorityService.save(authority);
            commonResp.setErrMsg("수정에 성공 했습니다.");
        }
        catch (Exception ex) {
            commonResp.setErrCode(-99);
            commonResp.setErrMsg("수정에 실패 했습니다.");
        }

        return commonResp;
    }

    @RequestMapping(value = "/authority/create", method=RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public Object createAuthority(Authority authority)
    {
        log.info(authority.toString());
        CommonResp commonResp = CommonResp.builder().errCode(1).build();

        try {
            authorityService.save(authority);
            commonResp.setErrMsg("등록에 성공 했습니다.");
        }
        catch (Exception ex)
        {
            commonResp.setErrCode(-99);
            commonResp.setErrMsg("등록에 실패 했습니다.");
        }

        return commonResp;
    }
}
