package kr.huny.site.repository;

import kr.huny.site.domain.db.Login.LoginHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory,Long> {
    Page<LoginHistory> findByUserNo(Long userNo, Pageable pageable);
}
