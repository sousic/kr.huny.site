package kr.huny.site.repository;

import kr.huny.site.domain.db.Login.LoginHistory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by sousic on 2017. 5. 9..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/appConfig.xml" })
public class LoginHistoryRepositoryTest {
    private final Logger logger = LoggerFactory.getLogger(LoginHistoryRepositoryTest.class);

    @Autowired LoginHistoryRepository loginHistoryRepository;

    private Long userNo = 1L;

    @Test
    public void findByUserNo() throws Exception {
        Page<LoginHistory> loginHistoryList = loginHistoryRepository.findByUserNo(userNo,new PageRequest(0,10));

        logger.debug("loginHistoryList =>" + loginHistoryList.getContent().size());
        logger.debug(loginHistoryList.getContent().get(0).toString());
    }

}