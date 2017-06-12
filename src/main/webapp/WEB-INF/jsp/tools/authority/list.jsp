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
                            <col width="100px;" align="center"/>
                        </colgroup>
                        <thead>
                        <tr>
                            <th>권한등급</th>
                            <th>권한명</th>
                            <th>동</th>
                        </tr>
                        </thead>
                        <tbody id="authoritylist">
                        <c:forEach items="${authorities.list}" var="item">
                        <tr>
                            <td>${item.authority}</td>
                            <td>${item.authority_name}</td>
                            <td>
                                <span class="btn btn-default modify" data-authority="${item.authority}">수정</span>
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="text-right">
                    <a href="javascript:" class="btn btn-default btn-info" id="regAuth">등록</a>
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
            var url = "<c:url value="/tools/authority/list/json"/>?page=" + num;
            refreshList(url);
        });

        $("#authoritylist").on("click",".modify", function() {
            $("#authority").val($(this).data("authority"));
            $("#authority_name").val($(this).parents("tr").find("td:eq(1)").text());
            $("#authorityModal #title").text("권한명수정");
            $("#authorityModal").modal();
        });

        $("#replyModBtn").click(function() {
            $.getJSON('<c:url value="/tools/authority/authority/update"/>', $("#aForm").serialize(), function(data){
                if(data.errCode == 1) {
                    refreshList('<c:url value="/tools/authority/list/json"/>?page='+$("#pageNavi .active").text());
                    $("#authorityModal").modal('hide');
                }
            });
        });

        $("#regAuth").on("click", function() {
            $.post('<c:url value="/tools/authority/authority/create"/>',$("#aForm").serialize(), function(data) {
                if(data.errCode == 1) {
                    refreshList('<c:url value="/tools/authority/list/json"/>?page='+$("#pageNavi .active").text());
                    $("#authorityModal").modal('hide');
                }
            }, "json");
        });

        $("#regAuth").on("click", function() {
            $("#authorityModal #title").text("권한명등록");
            $("#authorityModal #authWrapper").show();
            $("#authorityModal").modal();
        });

        $('#authorityModal').on('hide.bs.modal', function (e) {
            resetAuthorityModel();
        });
    });

    function resetAuthorityModel()
    {
        $("#authority").val('');
        $("#authority_name").val('');
        $("#authorityModal #authWrapper").hide();
    }

    function refreshList(url)
    {
        var template = Handlebars.compile($("#entry-template").html());
        $("#authoritylist").html('');

        $.getJSON(url,function(){})
        .done(function(data) {
            $(data.list).each(function () {
                var html = template(this);
                $("#authoritylist").append(html);
            })
        });
    }
</script>
<script type="text/x-handlebars-template" id="entry-template">
    <tr>
        <td>{{authority}}</td>
        <td>{{authority_name}}</td>
        <td>
            <span class="btn btn-default modify" data-authority="{{authority}}">수정</span>
        </td>
    </tr>
</script>

<div id="authorityModal" class="modal modal-primary fade" role="dialog">
    <div class="modal-dialog">
        <form id="aForm" method="post" data-toggle="validator" role="form" onsubmit="return false;">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title" id="title"></h4>
            </div>
            <div class="modal-body">
                <div class="form-group" style="display: none;" id="authWrapper">
                    <div class="input-group">
                        <span class="input-group-addon" id="addon_authority">권한번호</span>
                        <input type="text" id="authority" name="authority" value="" class="form-control" placeholder="권한명을 넣어주세요." data-error="권한번호를 넣어주세요." aria-describedby="addon_authority" required >
                    </div>
                    <div class="help-block with-errors"></div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon" id="addon_authority_name">권한명</span>
                        <input type="text" id="authority_name" name="authority_name" value="" class="form-control" placeholder="권한명을 넣어주세요." data-error="권한명을 넣어주세요." aria-describedby="addon_authority_name" required >
                    </div>
                    <div class="help-block with-errors"></div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-info" id="replyModBtn">완료</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
            </div>
        </div>
        </form>
    </div>
</div>
</body>
</html>
