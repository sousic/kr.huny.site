package kr.huny.site.repository;

import kr.huny.site.domain.db.User.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sousic on 2017. 5. 5..
 */
public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Long> {
}
