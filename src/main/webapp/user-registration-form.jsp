
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
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
