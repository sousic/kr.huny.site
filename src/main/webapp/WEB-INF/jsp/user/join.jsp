<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <c:set var="contextPath" value="<%=request.getContextPath()%>"/>
</head>
<body>
    <div class="container">
        <form id="joinForm" method="post" role="form" data-toggle="validator" action="${contextPath}/join">
            <h2>가입하기</h2>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon" id="addon_email">아이디</span>
                    <input type="text" id="email" name="email" value="${userWrite.email}" class="form-control" placeholder="아이디를 넣어주세요." data-error="아이디를 넣어주세요." aria-describedby="addon_email" required >
                </div>
                <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon" id="addon_nickName">별명</span>
                    <input type="text" id="nickName" name="nickName" value="${userWrite.nickName}" class="form-control" placeholder="별명을 넣어주세요." data-error="별명을 넣어주세요." aria-describedby="addon_nickName" required/>
                </div>
                <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon" id="addon_pwd">비밀번호</span>
                    <input type="password" id="pwd" name="pwd" class="form-control" placeholder="암호를 넣어주세요." data-error="암호를 넣어주세요." aria-describedby="addon_pwd" required/>
                </div>
                <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon" id="addon_pwdConfirm">비밀번호확인</span>
                    <input type="password" id="pwdConfirm" name="pwdConfirm" class="form-control" placeholder="암호를 넣어주세요." data-error="암호를 넣어주세요."  aria-describedby="addon_pwdConfirm" required/> <%--data-match="#pwd" data-match-error="암호를 확인해 주세요."--%>
                </div>
                <div class="help-block with-errors"><c:if test="${pwdConfirm == true}">암호를 확인해주세요.</c:if></div>
            </div>
            <div class="form-group">
                <div class="row">
                    <div class="col-xs-6 col-md-6">
                        <input type="submit" value="가입하기" class="btn btn-primary btn-block"/>
                    </div>
                    <div class="col-xs-6 col-md-6">
                        <input type="submit" value="취소" class="btn btn-default btn-block"/>
                    </div>
                </div>
            </div>
        </form>
    </div>

<script type="text/javascript">
    (function() {
		
    })();
</script>
</body>
</html>
