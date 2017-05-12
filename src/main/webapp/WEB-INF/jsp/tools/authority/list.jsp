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

                <h2 class="sub-header">권한 목록</h2>

                <div class="table-responsive">
                    <table class="table table-striped">
                        <colgroup>
                            <col width="300px;">
                            <col width="*">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>권한등급</th>
                            <th>권한명</th>
                        </tr>
                        </thead>
                        <tbody id="authoritylist">
                        <c:forEach items="${authorities.list}" var="item">
                        <tr>
                            <td>${item.authority}</td>
                            <td>${item.authority_name}</td>
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
            total: ${authorities.totalPages},
            page: ${authorities.number}+1,
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
</script>
<script type="text/x-handlebars-template" id="entry-template">
    <tr>
        <td>{{authority}}</td>
        <td>{{authority_name}}</td>
    </tr>
</script>
</body>
</html>
