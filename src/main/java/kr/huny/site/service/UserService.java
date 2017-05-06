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

@Slf4j
@Service
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

	public void userSave(User user)
	{
		userRepository.save(user);
	}

	public void userDelete(User user)
	{
		userRepository.delete(user);
	}

	public int SetUserJoin(User user) throws Exception
	{
		int result = 1;
		log.debug("user =>" + user.toString());

		userSave(user);

		Authority authority = authorityService.findOne(1);
		UserAuthority userAuthority = UserAuthority.builder().user(user).authority(authority).build();
		userAuthorityService.SetUserAuthoriy(userAuthority);

		//userService.userDelete(user);
		//log.error(ex.toString());
		//result = 0;

		return result;
	}
}
