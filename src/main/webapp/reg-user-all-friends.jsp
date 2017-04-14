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
        Collection<User> friends = (Collection<User>) request.getAttribute(FriendsController.ALL_FRIENDS_KEY);
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
        for (User friend: friends) {
    %>
        <tr>
            <td><%=friend.getId()%></td>
            <td><%=friend.getFirstName()%></td>
            <td><%=friend.getLastName()%></td>
            <td><%=friend.getDateOfBirth()%></td>
            <td><%=friend.getAccessLevel()%></td>
            <td><%=friend.getEmail()%></td>
            <td><%=friend.getPasswordHash()%></td>
            <td><%=friend.getProfilePhoto()%></td>
            <td><%=friend.getStatusOnWall()%></td>
            <td><%=friend.getCity()%></td>
        </tr>
            <%
        }
    %>


</section>

</body>
</html>
