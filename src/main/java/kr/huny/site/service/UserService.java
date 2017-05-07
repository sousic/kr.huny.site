package kr.huny.site.service;

import kr.huny.site.domain.db.Login.LoginHistory;
import kr.huny.site.domain.db.User.User;
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
}
