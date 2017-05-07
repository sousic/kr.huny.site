package kr.huny.site.facade.user;

import kr.huny.site.domain.db.User.Authority;
import kr.huny.site.domain.db.User.User;
import kr.huny.site.domain.db.User.UserAuthority;
import kr.huny.site.service.AuthorityService;
import kr.huny.site.service.UserAuthorityService;
import kr.huny.site.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Created by sousic on 2017-05-06.
 */
@Component
@Slf4j
public class UserFacadeImpl implements UserFacade {
    @Autowired
    UserService userService;
    @Autowired
    UserAuthorityService userAuthorityService;
    @Autowired
    AuthorityService authorityService;

    @Transactional
    public void SetUserJoin(User user)
    {
        log.debug("user =>" + user.toString());

        userService.userSave(user);

        Authority authority = authorityService.findOne(1);
        UserAuthority userAuthority = UserAuthority.builder().user(user).authority(authority).build();
        userAuthorityService.SetUserAuthoriy(userAuthority);
    }
}
