<%--
  Created by IntelliJ IDEA.
  User: veraivanova
  Date: 11.04.17
  Time: 5:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello!


<div class="text-article">
    <c:if test="${notif ne null}">
    <div class="notif">
        <span>${notif}</span>
    </div>
    </c:if>
    <form method="POST" action="registration">

        
</body>
</html>
