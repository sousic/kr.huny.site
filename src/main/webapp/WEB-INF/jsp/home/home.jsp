<%@ page import="kr.huny.site.authentication.UserInfo" %>
<%@ page import="org.springframework.security.core.Authentication" %>
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
    <title>Home</title>
    <jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
</head>
<body>
    로그인 계정 정보 : <%=user.toString()%>
</body>
</html>
