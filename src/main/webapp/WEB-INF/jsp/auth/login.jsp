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
        <form id="loginForm" method="post" role="form" data-toggle="validator">
            <h2>로그인</h2>
            <div class="form-group">
                <input type="text" id="loginID" name="loginID" value="${loginID}" class="form-control" placeholder="아이디를 넣어주세요." data-error="아이디를 넣어주세요." required autofocus>
                <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                <input type="password" id="loginPWD" name="loginPWD" class="form-control" placeholder="암호를 넣어주세요." data-error="암호를 넣어주세요." required/>
                <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                <input type="submit" value="로그인" class="btn btn-primary btn-block"/>
            </div>
        </form>
    </div>

<script type="text/javascript">
    (function() {

    })();
</script>
</body>
</html>
