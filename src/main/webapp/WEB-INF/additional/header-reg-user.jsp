
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
<head>

    <title></title>

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Spirax">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <style>
        <%@include file="../../styles/main.css" %>
        <%@include file="../../styles/header-reg-user.css" %>
    </style>

</head>
<body>

<div class="header-reg-user">

    <ul>
        <li class="logo"><a href="my-page">W-only</a></li>
        <li class="exit"><a href="logout">Выйти<i class="fa fa-sign-out" aria-hidden="true"></i></a></li>
    </ul>
    <%--<input type="hidden" name="j_id" value="<%=session.getAttribute("j_id")%>">--%>
    <%--<input type="hidden" name="j_id" value="<%=request.getParameter("j_id")%>" />--%>

</div>

</body>
</html>
