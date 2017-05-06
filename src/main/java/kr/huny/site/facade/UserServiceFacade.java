package kr.huny.site.facade;

import kr.huny.site.domain.db.User.Authority;
import kr.huny.site.domain.db.User.User;
import kr.huny.site.domain.db.User.UserAuthority;
import kr.huny.site.service.AuthorityService;
import kr.huny.site.service.UserAuthorityService;
import kr.huny.site.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by sousic on 2017-05-06.
 */
@Component
@Slf4j
public class UserServiceFacade {
    @Autowired
    UserService userService;
    @Autowired
    UserAuthorityService userAuthorityService;
    @Autowired
    AuthorityService authorityService;

    public int SetUserJoin(User user) throws Exception
    {
        int result = 1;
        log.debug("user =>" + user.toString());

        userService.userSave(user);

        Authority authority = authorityService.findOne(1);
        UserAuthority userAuthority = UserAuthority.builder().user(user).authority(authority).build();
        userAuthorityService.SetUserAuthoriy(userAuthority);

        //userService.userDelete(user);
        //log.error(ex.toString());
        //result = 0;

        return result;
    }
}
