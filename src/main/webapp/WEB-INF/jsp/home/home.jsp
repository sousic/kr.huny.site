<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="kr.huny.site.authentication.site.UserInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
    Authentication auth = (Authentication)request.getUserPrincipal();
    String name = "*";

    if(auth == null) {

    } else {
        Object principal = auth.getPrincipal();
        if(principal != null && principal instanceof UserInfo) {
            name = ((UserInfo)principal).getUsername();
        }
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%=name%>
</body>
</html>
