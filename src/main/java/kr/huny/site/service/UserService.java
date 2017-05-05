package kr.huny.site.service;

import kr.huny.site.domain.db.Login.LoginHistory;
import kr.huny.site.domain.db.User.Authority;
import kr.huny.site.domain.db.User.User;
import kr.huny.site.domain.db.User.UserAuthority;
import kr.huny.site.repository.LoginRepository;
import kr.huny.site.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class UserService {
	
	@Autowired
	LoginRepository loginRepository;

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserAuthorityService userAuthorityService;
	@Autowired
	AuthorityService authorityService;
	
	public void SetLoginHistory(LoginHistory loginHistory) {
		// TODO Auto-generated method stub
		log.info("loginHistory => " + loginHistory.toString());
		loginRepository.save(loginHistory);
	}

	public void SetUserJoin(User user) {
		log.info("user => " + user.toString());
		User dbUser = userRepository.save(user);

		Authority authority = authorityService.findOne(1);
		UserAuthority userAuthority = UserAuthority.builder().user(dbUser).authority(authority).build();

		userAuthorityService.SetUserAuthoriy(userAuthority);
	}
}
