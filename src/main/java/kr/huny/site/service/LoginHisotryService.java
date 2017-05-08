package kr.huny.site.service;

import kr.huny.site.domain.db.Login.LoginHistory;
import kr.huny.site.repository.LoginHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by sousic on 2017. 5. 8..
 */
@Service
public class LoginHisotryService {
    @Autowired
    LoginHistoryRepository loginHistoryRepository;

    public Page<LoginHistory> findLoginHistoryByUser_IdOrderByIdIdDesc(Pageable pageable, Long User_Id)
    {
        return loginHistoryRepository.findLoginHistoryByUser_Id(pageable, User_Id);
    }
}
