package kr.huny.site.authentication.cookie;

import kr.huny.site.common.crypto.AESImpl;
import kr.huny.site.common.crypto.ICrypto;
import kr.huny.site.common.serializer.IAuthSerializer;
import kr.huny.site.common.serializer.IAuthSerializerImpl;
import org.springframework.security.core.Authentication;

import javax.servlet.http.Cookie;

/**
 * Created by sousic on 2017-05-24.
 */
public class CookieSecurityService {
    private static final String DEFAULT_COOKIE_PATH = "/";
    private final String cookieName;
    private final String cookePath;
    private final ICrypto iCrypto;
    private final IAuthSerializer iAuthSerializer;

    public CookieSecurityService(String cookieName, String encryptKey)
    {
        this.cookieName = cookieName;
        this.cookePath = DEFAULT_COOKIE_PATH;
        this.iCrypto = new AESImpl(encryptKey);
        this.iAuthSerializer = new IAuthSerializerImpl();
    }

    public CookieSecurityService(String cookieName, String encryptKey, String cookePath) {
        this.cookieName = cookieName;
        this.cookePath = cookePath;
        this.iCrypto = new AESImpl(encryptKey);
        this.iAuthSerializer = new IAuthSerializerImpl();
    }

    public Authentication getAuthenticationFrom(Cookie cookie)
    {
        return null;
        //byte[] decodedFromBase64 = Base64.decodeBase64(cookie.getValue());
    }
}
