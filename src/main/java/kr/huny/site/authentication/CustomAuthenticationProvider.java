package kr.huny.site.authentication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.huny.site.common.crypto.SHAPasswordEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

/**
 * Created by sousic on 2017-03-29.
 */
@Slf4j
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserJdbcDaoImpl userJdbcDao;

    @Autowired
    private SHAPasswordEncoder shaPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String)authentication.getCredentials();

        ObjectMapper om = new ObjectMapper();
        try {
            String json = om.writeValueAsString(authentication);
            log.debug("Authentication : " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        UserDetails user;
        Collection<? extends GrantedAuthority> authorities;

        try {
            user = userJdbcDao.loadUserByUsername(username);
            String hashedPassword = shaPasswordEncoder.encode(password);

            log.debug("username : " + username + ", password : " + password + ", hashedPassword :" + hashedPassword);
            log.debug("user.username : " + user.getUsername() + ", user.password : " + user.getPassword());
                       
        	if (!hashedPassword.equals(user.getPassword())) throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
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
