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
            var url = "/tools/authority/list/json?size=2&page=" + num;
            refreshList(url);
        });
    });

    function refreshList(url)
    {
        var template = Handlebars.compile($("#entry-template").html());
        $("#authoritylist").html('');

        $.getJSON(url, function(data) {
            $(data.list).each(function() {
                var html = template(this);
                $("#authoritylist").append(html);
            });
        });
    }

    function viewLoginHistory(user_no)
    {
        var url = "<c:url value="/tools/login/history/detail/json/"/>" + user_no;
        console.log(user_no);
    }
</script>
<script type="text/x-handlebars-template" id="entry-template">
    <tr>
        <td>{{authority}}</td>
        <td>{{authority_name}}</td>
    </tr>
</script>

<div id="loginHistroyModel" class="modal modal-primary fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title"></h4>
            </div>
            <div class="modal-body" data-rno>
                <p><input type="text" id="replytext" class="form-control"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" id="replyModBtn">Modify</button>
                <button type="button" class="btn btn-danger" id="replyDelBtn">DELETE</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
