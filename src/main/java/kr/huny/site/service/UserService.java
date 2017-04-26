package kr.huny.site.service;

import kr.huny.site.domain.db.Login.LoginHistory;
import kr.huny.site.repository.LoginRepository;
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
	
	public void SetLoginHistory(LoginHistory loginHistory) {
		// TODO Auto-generated method stub
		log.info("loginHistory => " + loginHistory.toString());
		loginRepository.save(loginHistory);
	}
}
