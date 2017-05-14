<%@ page contentType="text/html;charset=UTF-8" language="java" session="true"
         import="controllers.MyFriendsController" %>
<%@ page import="model.*" %>
<%@ page import="java.util.Collection" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope.get(WelcomeController.WELCOME_KEY)} Добро пожаловать</title>

    <style>
        <%@include file="styles/main.css" %>
        <%@include file="styles/friends.css" %>
    </style>

</head>
<body>

<header class="reg-user">
    <%@ include file="WEB-INF/additional/header-reg-user.jsp" %>
</header>

<aside class="reg-user">
    <%@ include file="WEB-INF/additional/sidebar-reg-user.jsp" %>
</aside>

<section class="reg-user friends">

    <%
        Collection<User> friends = (Collection<User>) request.getAttribute(MyFriendsController.ALL_FRIENDS_KEY);
    %>

    <ul>
            <%
        for (User friend: friends) {
    %>
        <li>
            <ul>
                <li><a href="smb-page?some_user_id=<%=friend.getId()%>"><img src="users_profile_picture?user_id=<%=friend.getId()%>" /></a></li>
                <li class="name"><a href="smb-page?some_user_id=<%=friend.getId()%>"><%=friend.getFirstName()%> <%=friend.getLastName()%></a></li>
                <li><%=friend.getStatusOnWall()%></li>
            </ul>
        </li>
            <%
        }
    %>

    </ul>

</section>

</body>
</html>
