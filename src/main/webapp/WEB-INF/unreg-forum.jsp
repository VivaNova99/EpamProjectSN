<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="controllers.WelcomeController" %>
<%@ page import="java.util.Collection" %>
<%@ page import="model.*" %>
<html>
<head>
    <title> Добро пожаловать </title>
    <%--<title>${requestScope.get(WelcomeController.WELCOME_KEY)} Добро пожаловать</title>--%>

</head>
<body>

<header class="unreg">
    <%@ include file="header-unreg.jsp" %>
</header>


<section class="forum-themes">

    <%@ include file="forum-themes.jsp" %>

</section>

</body>

</html>
