package kr.huny.site.authentication.site;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collection;

/**
 * Created by sousic on 2017-03-29.
 */
@Slf4j
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserJdbcDaoImpl userJdbcDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter;

    @Bean
    public UsernamePasswordAuthenticationFilter getUsernamePasswordAuthenticationFilter()
    {
        return new UsernamePasswordAuthenticationFilter();
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String)authentication.getCredentials();
        String originalPwd = usernamePasswordAuthenticationFilter.getPasswordParameter();

        UserDetails user;
        Collection<? extends GrantedAuthority> authorities;

        try {
            user = userJdbcDao.loadUserByUsername(username);
            //String hashedPassword = passwordEncoder.encode(password);
            boolean hashedPassword = passwordEncoder.matches(originalPwd, passwordEncoder.encode(originalPwd));

            log.debug("username : " + username + ", password : " + hashedPassword);
            log.debug("user.username : " + user.getUsername() + ", user.password : " + user.getPassword());

            if (!hashedPassword) throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
            authorities = user.getAuthorities();
        } catch(UsernameNotFoundException e)
        {
            log.info(e.toString()); throw new UsernameNotFoundException(e.getMessage());
        } catch(BadCredentialsException e)
        {
            log.info(e.toString()); throw new BadCredentialsException(e.getMessage());
        } catch(Exception e)
        {
            log.info(e.toString()); throw new RuntimeException(e.getMessage());
        }
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
