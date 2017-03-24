<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="kr.huny.site.authentication.site.UserInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
    Authentication auth = (Authentication)request.getUserPrincipal();
    UserInfo user = null;
    if(auth == null) {
        user = new UserInfo();
    } else {
        Object principal = auth.getPrincipal();
        if(principal != null && principal instanceof UserInfo) {
            user = ((UserInfo)principal);
        }
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    로그인 계정 정보 : <%=user.toString()%>
</body>
</html>
