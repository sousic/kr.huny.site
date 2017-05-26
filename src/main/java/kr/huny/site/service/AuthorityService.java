package kr.huny.site.service;

import kr.huny.site.domain.db.User.Authority;
import kr.huny.site.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by sousic on 2017-04-28.
 */
@Service
public class AuthorityService {
    @Autowired
    AuthorityRepository authorityRepository;

    public Page<Authority> findAll(Pageable pageable)
    {
        return authorityRepository.findAll(pageable);
    }

    public Authority findOne(Integer authority_no)
    {
        return authorityRepository.findOne(authority_no);
    }

    public void save(Authority authority)
    {
        authorityRepository.save(authority);
    }
}
