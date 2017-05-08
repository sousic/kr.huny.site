package kr.huny.site.web.manager;

import kr.huny.site.domain.db.Login.LoginHistory;
import kr.huny.site.domain.web.CommonResp;
import kr.huny.site.service.LoginHisotryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sousic on 2017. 5. 8..
 * 로그인 기록 관련 컨트롤러
 */
@Controller
@RequestMapping(value = "/tools/login/history")
public class LoginHistoryController {
    @Autowired
    LoginHisotryService loginHisotryService;

    @RequestMapping(value = "/detail/json/{user_no}", method = RequestMethod.GET)
    public @ResponseBody Object listUserLoginHistory(@PathVariable Long user_no, Pageable pageable)
    {
        CommonResp<LoginHistory> loginHisotry = new CommonResp<>(loginHisotryService.findLoginHistoryByUser_IdOrderByIdIdDesc(pageable, user_no));

        return loginHisotry;
    }
}
