package kr.huny.site.web.manager;

import kr.huny.site.common.Helper.PageableHelper;
import kr.huny.site.domain.db.Login.LoginHistory;
import kr.huny.site.domain.web.CommonPageResp;
import kr.huny.site.service.LoginHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sousic on 2017. 5. 8..
 * 로그인 기록 관련 컨트롤러
 */
@Slf4j
@Controller
@RequestMapping(value = "/tools/login/history")
public class LoginHistoryController {

    @Autowired
    LoginHistoryService loginHistoryService;

    @RequestMapping(value = "/detail/json/{user_no}", method = RequestMethod.GET)
    @ResponseBody
    public Object listUserLoginHistory(@PathVariable Long user_no, @PageableDefault(direction = Sort.Direction.DESC, sort = "id") Pageable pageable)
    {
        CommonPageResp<LoginHistory> loginHistory = new CommonPageResp<>(loginHistoryService.findByUserNo(PageableHelper.getPageRequest(pageable), user_no));

        return loginHistory;
    }
}
