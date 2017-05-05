<%@ page import="controllers.MyThemesController" %>
<%@ page import="model.WallMessage" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: veraivanova
  Date: 11.04.17
  Time: 8:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

    <style>
        <%@include file="styles/main.css" %>
        <%@include file="styles/user-themes.css" %>
    </style>
</head>
<body>

<header class="reg-user">
    <%@ include file="WEB-INF/additional/header-reg-user.jsp" %>
</header>

<aside class="reg-user">
    <%@ include file="WEB-INF/additional/sidebar-reg-user.jsp" %>
</aside>

<section class="user-themes">

    <%
        Collection<WallMessage> myThemes = (Collection<WallMessage>) request.getAttribute(MyThemesController.MY_THEMES_KEY);
    %>

    <ul>
        <%
            for (WallMessage myTheme: myThemes) {
        %>
        <li>
            <ul>
                <li class="forum-theme">В подфоруме: <%=myTheme.getForumThemeName()%></li>
                <li class="date-time"><%=myTheme.getDateTime()%> Вы написали: </li>
                <li class="header">Заголовок: <%=myTheme.getMessageHeader()%></li>
                <li class="text"><%=myTheme.getText()%></li>
                <li class="picture"><img src="wall_message_picture?wall_message_picture_id=<%=myTheme.getId()%>" /></li>
                <li class="link">
                    <a href="forum-this-topic?this_forum_topic_id=<%=myTheme.getId()%>"> ссылка на обсуждение </a>
                </li>
            </ul>
        </li>
        <%
            }
        %>
    </ul>

</section>

</body>
</html>
