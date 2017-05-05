package kr.huny.site.repository;

import kr.huny.site.domain.db.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sousic on 2017. 5. 5..
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
