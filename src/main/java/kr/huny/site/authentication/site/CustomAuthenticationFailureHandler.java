package kr.huny.site.authentication.site;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sousic on 2017-03-27.
 */
@Slf4j
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private String loginidname;
    private String loginpasswordname;
    private String loginredirectname;
    private String exceptionmsgname;
    private String defaultFailreUrl;

    public CustomAuthenticationFailureHandler() {
        this.loginidname = "loginID";
        this.loginpasswordname = "loginPWD";
        this.loginredirectname = "loginRedirect";
        this.exceptionmsgname = "securityexceptionmsg";
        this.defaultFailreUrl = "/login.do";
    }

    public String getLoginidname() {
        return loginidname;
    }

    public void setLoginidname(String loginidname) {
        this.loginidname = loginidname;
    }

    public String getLoginpasswordname() {
        return loginpasswordname;
    }

    public void setLoginpasswordname(String loginpasswordname) {
        this.loginpasswordname = loginpasswordname;
    }

    public String getLoginredirectname() {
        return loginredirectname;
    }

    public void setLoginredirectname(String loginredirectname) {
        this.loginredirectname = loginredirectname;
    }

    public String getExceptionmsgname() {
        return exceptionmsgname;
    }

    public void setExceptionmsgname(String exceptionmsgname) {
        this.exceptionmsgname = exceptionmsgname;
    }

    public String getDefaultFailreUrl() {
        return defaultFailreUrl;
    }

    public void setDefaultFailreUrl(String defaultFailreUrl) {
        this.defaultFailreUrl = defaultFailreUrl;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        String loginid = httpServletRequest.getParameter(loginidname);
        String loginpasswd = httpServletRequest.getParameter(loginpasswordname);
        String loginRedirect = httpServletRequest.getParameter(loginredirectname);

        httpServletRequest.setAttribute(loginidname,loginid);
        httpServletRequest.setAttribute(loginpasswordname,loginpasswd);
        httpServletRequest.setAttribute(loginredirectname,loginRedirect);

        httpServletRequest.setAttribute(exceptionmsgname, e.getMessage());

        log.debug("login fail..");

        httpServletRequest.getRequestDispatcher(defaultFailreUrl).forward(httpServletRequest,httpServletResponse);
    }
}
