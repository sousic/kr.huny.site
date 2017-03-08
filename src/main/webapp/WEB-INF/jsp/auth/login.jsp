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
    <title>Title</title>
</head>
<body>
    <span id="test"></span>


<script type="text/javascript" src="/resources/js/jquery/jquery.min.js"></script>
<script type="text/javascript">
    (function() {
        $("#test").text("jquery load()");
    })();
</script>
</body>
</html>
