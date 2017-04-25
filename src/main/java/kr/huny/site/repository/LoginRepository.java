package kr.huny.site.repository;

import kr.huny.site.domain.db.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginHistory,Long> {

}
