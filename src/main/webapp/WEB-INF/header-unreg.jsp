<%--
  Created by IntelliJ IDEA.
  User: veraivanova
  Date: 11.04.17
  Time: 5:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Spirax">

    <style>
        <%@include file="../styles/main.css" %>
        <%@include file="../styles/header-unreg.css" %>
    </style>
</head>
<body>

<div class="header-unreg">
    <ul>
        <li class="logo">W-only</li>
        <li class="enter-or-register">Пожалуйста, войдите
            <textarea class="enter-login" placeholder="login"></textarea>
            <textarea class="enter-password" placeholder="password"></textarea>
            или <a href="registration-form.jsp">зарегистрируйтесь</a>
        </li>
    </ul>
</div>

</body>
</html>
