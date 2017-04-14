<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="controllers.FriendsController" %>
<%@ page import="model.*" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: veraivanova
  Date: 11.04.17
  Time: 7:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope.get(WelcomeController.WELCOME_KEY)} Добро пожаловать</title>
</head>
<body>

<header class="reg-user">
    <%@ include file="WEB-INF/header-reg-user.jsp" %>
</header>

<aside class="reg-user">
    <%@ include file="WEB-INF/sidebar-reg-user.jsp" %>
</aside>

<section>

    <%
        Collection<User> users = (Collection<User>) request.getAttribute(FriendsController.ALL_USERS_KEY);
    %>

    <table>
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Date of birth</th>
            <th>Access Level</th>
            <th>Email</th>
            <th>Password hash</th>
            <th>Profile photo</th>
            <th>Status on wall</th>
            <th>City</th>
        </tr>
            <%
        for (User user: users) {
    %>
        <tr>
            <td><%=user.getId()%></td>
            <td><%=user.getFirstName()%></td>
            <td><%=user.getLastName()%></td>
            <td><%=user.getDateOfBirth()%></td>
            <td><%=user.getAccessLevel()%></td>
            <td><%=user.getEmail()%></td>
            <td><%=user.getPasswordHash()%></td>
            <td><%=user.getProfilePhoto()%></td>
            <td><%=user.getStatusOnWall()%></td>
            <td><%=user.getCity()%></td>
        </tr>
            <%
        }
    %>


</section>

</body>
</html>
