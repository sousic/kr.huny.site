package kr.huny.site.web.manager;

import kr.huny.site.domain.db.Login.LoginHistory;
import kr.huny.site.domain.web.CommonResp;
import kr.huny.site.repository.LoginHistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    Sort sorted = new Sort(Sort.Direction.DESC, "history_id");

    @Autowired
    //LoginHistoryService loginHistoryService;
    LoginHistoryRepository loginHistoryRepository;

    @RequestMapping(value = "/detail/json/{user_no}", method = RequestMethod.GET)
    public @ResponseBody Object listUserLoginHistory(@PathVariable Long user_no, @PageableDefault(direction = Sort.Direction.DESC, size = 10, sort = { "id" })  Pageable pageable)
    {

        Page<LoginHistory> loginHisotry = loginHistoryRepository.findByUserNo(user_no,pageable);
        CommonResp<LoginHistory> zz = new CommonResp<>(loginHisotry);

        /*for(int i = 0 ; i < loginHisotry.getContent().size();i++)
        {
            log.debug(loginHisotry.getContent().get(i).getUser().getId().toString());
        }*/

        return zz;
    }
}
