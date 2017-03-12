<%--
  Created by IntelliJ IDEA.
  User: sousic
  Date: 2017. 3. 8.
  Time: PM 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<html>
<head>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
</head>
<body>
    <div class="container">
        <form id="loginForm">
            <input type="text" id="loginID" name="loginID" class="form-control" placeholder="아이디를 넣어주세요.">
            <input type="password" id="loginPWD" name="loginPWD" class="form-control" placeholder="암호를 넣어주세요."/>
        </form>
    </div>

<script type="text/javascript">
    (function() {
        $("#test").text("jquery load()");
    })();
</script>
</body>
</html>
