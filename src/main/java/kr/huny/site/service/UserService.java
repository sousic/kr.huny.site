package kr.huny.site.service;

import kr.huny.site.domain.db.Login.LoginHistory;
import kr.huny.site.domain.db.User.User;
import kr.huny.site.repository.LoginHistoryRepository;
import kr.huny.site.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class UserService {
	
	@Autowired
	LoginHistoryRepository loginHistoryRepository;
	@Autowired
	UserRepository userRepository;
	
	public void SetLoginHistory(LoginHistory loginHistory) {
		// TODO Auto-generated method stub
		log.info("loginHistory => " + loginHistory.toString());
		loginHistoryRepository.save(loginHistory);
	}

	public void userSave(User user)
	{
		userRepository.save(user);
	}

	public void userDelete(User user)
	{
		userRepository.delete(user);
	}

	public Page<User> findAll(Pageable pageable){
		return userRepository.findAll(pageable);
	}

	public User findOne(Long userid){
		return userRepository.findOne(userid);
	}

	public void updateUserLastLoginDate(long user_no) {
		User user = userRepository.findOne(user_no);
		user.setLastLoginDate(new Date());
		userRepository.save(user);
	}
}
