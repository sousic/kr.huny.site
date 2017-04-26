package kr.huny.site.authentication;

import kr.huny.site.common.CommonRole;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sousic on 2017-03-24.
 */
public class UserJdbcDaoImpl extends JdbcDaoImpl {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //return super.loadUserByUsername(username);
        List<UserDetails> users = loadUsersByUsername(username);

        if(users.size() == 0) {
            logger.debug("Query returned no results for user '" + username + "'");

            UsernameNotFoundException ue = new UsernameNotFoundException(messages.getMessage("JdbcDaoImpl.notFound", new Object[]{username}, "Username {0} not found"));
            throw ue;
        }

        UserInfo userInfo = (UserInfo)users.get(0);

        Set<GrantedAuthority> dbAuthsSet = new HashSet<GrantedAuthority>();

        if(getEnableAuthorities()) {
            dbAuthsSet.addAll(loadUserAuthorities(userInfo.getUsername()));
        }

        if(getEnableGroups())
        {
            dbAuthsSet.addAll(loadUserAuthorities(userInfo.getUsername()));
        }

        List<GrantedAuthority> dbAuths = new ArrayList<GrantedAuthority>(dbAuthsSet);
        userInfo.setAuthorities(dbAuths);

        if(dbAuths.size() == 0) {
            logger.debug("User '" + username + "' has no authorities and will be treated as 'not found'");

            UsernameNotFoundException ue = new UsernameNotFoundException(messages.getMessage("JdbcDaoImpl.noAuthority", new Object[]{username}, "User {0} has no GrantedAuthority"));
            throw ue;
        }

        logger.debug(userInfo.toString());

        return userInfo;
    }

    @Override
    protected List<UserDetails> loadUsersByUsername(String username) {
        //return super.loadUsersByUsername(username);
        return getJdbcTemplate().query(getUsersByUsernameQuery(), new String[]{username}, new RowMapper<UserDetails>() {
            @Override
            public UserDetails mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                //UserInfo(long user_id, String email, String password, String nickname, Set<GrantedAuthority> authorities) {
                long user_no = resultSet.getLong("user_no");
                String email = resultSet.getString("email");
                String nickname = resultSet.getString("nickname");
                String password = resultSet.getString("pwd");

                return new UserInfo(user_no, email, password, nickname, AuthorityUtils.NO_AUTHORITIES);
            }
        });
    }

    @Override
    protected List<GrantedAuthority> loadUserAuthorities(String username) {
        //return super.loadUserAuthorities(username);
        return getJdbcTemplate().query(getAuthoritiesByUsernameQuery(), new String[]{username}, new RowMapper<GrantedAuthority>() {
            @Override
            public GrantedAuthority mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Integer roleNumber = resultSet.getInt("authority");

                return new SimpleGrantedAuthority(CommonRole.getRoleName(roleNumber));
            }
        });
    }

    @Override
    protected List<GrantedAuthority> loadGroupAuthorities(String username) {
        return super.loadGroupAuthorities(username);
    }
}
