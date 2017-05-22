<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sousic
  Date: 2017-03-23
  Time: 오후 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tools</title>
    <jsp:include page="/WEB-INF/jsp/common/tool_header.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/tool_navi.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="/WEB-INF/jsp/common/tool_menu.jsp"></jsp:include>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <h2 class="sub-header">회원 목록</h2>

            <div class="table-responsive">
                <table class="table table-striped">
                    <colgroup>
                        <col width="*">
                        <col width="*">
                    </colgroup>
                    <thead>
                    <tr>
                        <th>NO</th>
                        <th>아이디</th>
                        <th>최근암호변경일</th>
                        <th>별명</th>
                        <th>등록일</th>
                        <th>등급</th>
                        <th>마지막로그인</th>
                        <th>코드</th>
                        <th>최근로그인기록</th>
                    </tr>
                    </thead>
                    <tbody id="list">
                    <c:forEach items="${userList.list}" var="item">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.email}</td>
                            <td>${item.pwdChangeDate}</td>
                            <td>${item.nickname}</td>
                            <td>${item.regDate}</td>
                            <td>${item.grade}</td>
                            <td>${item.lastLoginDate}</td>
                            <td>${item.userCode.name}</td>
                            <td><button onclick="viewLoginHistory(${item.id});" class="btn btn-info">로그인기록</button></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="text-center">
                <div id="pageNavi" class="center">

                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $("#pageNavi").bootpag({
            total: ${userList.totalPages},
            page: ${userList.number+1},
            maxVisible:10
        }).on('page', function(event,num){
            var url = "<c:url value="/tools/member/list/json"/>?page=" + num;
            refreshList(url);
        });
    });

    function refreshList(url)
    {
        var template = Handlebars.compile($("#entry-user-template").html());
        $("#list").html('');

        $.getJSON(url, function(data) {
            $(data.list).each(function() {
                var html = template(this);
                $("#list").append(html);
            });
        });
    }

    function viewLoginHistory(user_no)
    {
        if($.trim(user_no) == '') {
            alert("잘못된 접근 입니다.");
            return false;
        } else {
            var url = "<c:url value="/tools/login/history/detail/json/"/>" + user_no;
            var template = Handlebars.compile($("#entry-user-history-template").html());
            $("#userLoginHistoryLists").html('');

            $.getJSON(url,function(){})
                .done(function (data) {
                $(data.list).each(function () {
                    var html = template(this);
                    $("#userLoginHistoryLists").append(html);
                    console.log(this);
                });
                $("#loginHistroyModel").modal();
            });
        }
    }
</script>
<script type="text/x-handlebars-template" id="entry-user-template">
    <tr>
        <td>{{id}}</td>
        <td>{{email}}</td>
        <td>{{pwdChangeDate}}</td>
        <td>{{nickname}}</td>
        <td>{{regDate}}</td>
        <td>{{grade}}</td>
        <td>{{lastLoginDate}}</td>
        <td>{{userCode.name}}</td>
        <td><button onclick="viewLoginHistory({{id}});" class="btn btn-info">로그인기록</button></td>
    </tr>
</script>
<script type="text/x-handlebars-template" id="entry-user-history-template">
    <tr>
        <td>{{id}}</td>
        <td>{{loginDate}}</td>
    </tr>
</script>

<div id="loginHistroyModel" class="modal modal-primary fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">접속로그기록</h4>
            </div>
            <div class="modal-body">
                <table>
                    <thead>
                    <tr>
                        <th>일련번호</th>
                        <th>최종접속</th>
                    </tr>
                    </thead>
                    <tbody id="userLoginHistoryLists">

                    </tbody>
                </table>
            </div>
            <%--<div class="modal-footer">
                <button type="button" class="btn btn-info" id="replyModBtn">Modify</button>
                <button type="button" class="btn btn-danger" id="replyDelBtn">DELETE</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>--%>
        </div>
    </div>
</div>
</body>
</html>
