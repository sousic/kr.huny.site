package kr.huny.site.service;

import kr.huny.site.domain.db.User.UserAuthority;
import kr.huny.site.repository.UserAuthorityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sousic on 2017. 5. 5..
 */
@Service
@Slf4j
public class UserAuthorityService {
    @Autowired
    UserAuthorityRepository userAuthorityRepository;

    public void SetUserAuthoriy(UserAuthority userAuthority)
    {
        log.info("userAuthority => " + userAuthority.toString());
        userAuthorityRepository.save(userAuthority);
    }
}
