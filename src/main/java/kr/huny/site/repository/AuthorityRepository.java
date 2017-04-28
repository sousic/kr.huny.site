package kr.huny.site.repository;

import kr.huny.site.domain.db.User.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sousic on 2017-04-28.
 */
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
