<%@ page import="controllers.RegistrationController" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: veraivanova
  Date: 31.05.17
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    User user = (User) request.getAttribute(RegistrationController.USER_INFO_KEY);
%>

<div class="user-profile-picture"><img src="users_profile_picture?user_id=<%=user.getId()%>" /></div>

<section class="user-info">
    User Id <%=user.getId()%>
    Access Level <%=user.getAccessLevel()%>
    <div class="user-name"><%=user.getFirstName()%> <%=user.getLastName()%></div>
    <div class="user-status-on-wall"><%=user.getStatusOnWall()%></div>
    <div class="user-dob">День рождения: <%=user.getDateOfBirth()%></div>
    <div class="user-city">Город: <%=user.getCity()%></div>
</section>

<a href="/">Вернуться на главную страницу</a>

</body>
</html>
