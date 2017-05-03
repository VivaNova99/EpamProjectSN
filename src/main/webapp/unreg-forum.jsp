<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="controllers.WelcomeController" %>
<%@ page import="java.util.Collection" %>
<%@ page import="model.*" %>
<html>
<head>
    <title> Добро пожаловать </title>
    <%--<title>${requestScope.get(WelcomeController.WELCOME_KEY)} Добро пожаловать</title>--%>

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Spirax">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <style>
        <%@include file="styles/main.css" %>
        <%@include file="styles/forum-themes.css" %>
    </style>


</head>
<body>

<header class="unreg">
    <%@ include file="WEB-INF/additional/header-unreg.jsp" %>
</header>


<section class="unreg-forum-themes">
    <%@ include file="WEB-INF/additional/forum-themes.jsp" %>
</section>

</body>

</html>
