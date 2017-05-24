package kr.huny.site.authentication.cookie;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SaveContextOnUpdateOrErrorResponseWrapper;
import org.springframework.security.web.context.SecurityContextRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by sousic on 2017-05-24.
 */
public class CookieSecurityConextRepository implements SecurityContextRepository {
    @Override
    public SecurityContext loadContext(HttpRequestResponseHolder httpRequestResponseHolder) {
        HttpServletRequest request = httpRequestResponseHolder.getRequest();

        SaveToSessionResponseWrapper responseWrapper = new SaveToSessionResponseWrapper(httpRequestResponseHolder.getResponse(), false);
        httpRequestResponseHolder.setResponse(responseWrapper);

        SecurityContext context = SecurityContextHolder.createEmptyContext();

        return context;
    }

    @Override
    public void saveContext(SecurityContext securityContext, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        SaveToSessionResponseWrapper responseWrapper = (SaveToSessionResponseWrapper)httpServletResponse;
        if(!responseWrapper.isContextSaved()) {
            responseWrapper.saveContext(securityContext);
        }
    }

    @Override
    public boolean containsContext(HttpServletRequest httpServletRequest) {
        return false;
    }

    final class SaveToSessionResponseWrapper extends SaveContextOnUpdateOrErrorResponseWrapper {

        public SaveToSessionResponseWrapper(HttpServletResponse response, boolean disableUrlRewriting) {
            super(response, disableUrlRewriting);
        }

        @Override
        protected void saveContext(SecurityContext securityContext) {
            //Cookie securityCookie = securityContext.getAuthentication();
        }
    }
}
