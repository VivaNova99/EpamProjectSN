
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true"
import="controllers.MyNewsController" %>
<%@ page import="model.*" %>
<%@ page import="java.util.Collection" %>

<html>
<head>
    <title></title>

    <style>
        <%@include file="styles/main.css" %>
        <%@include file="styles/news.css" %>
    </style>

</head>
<body>

<header class="reg-user">
    <%@ include file="WEB-INF/additional/header-reg-user.jsp" %>
</header>

<aside class="reg-user">
    <%@ include file="WEB-INF/additional/sidebar-reg-user.jsp" %>
</aside>

<section class="news">

    <%
        Collection<WallMessage> last10WallMessages = (Collection<WallMessage>) request.getAttribute(MyNewsController.LAST_10_WALL_MESSAGES_KEY);
    %>

    <ul>
        <%
            for (WallMessage last10WallMessage: last10WallMessages) {
        %>
        <li>
            <ul>
                <li class="profile-picture"><a href="smb-page?some_user_id=<%=last10WallMessage.getSenderUserId()%>">
                    <img src="users_profile_picture?user_id=<%=last10WallMessage.getSenderUserId()%>" /></a></li>
                <li class="name"><a href="smb-page?some_user_id=<%=last10WallMessage.getSenderUserId()%>">
                    <%=last10WallMessage.getSenderUserFirstNameAndLastName()%></a></li>
                <li class="forum-theme">В подфоруме: <%=last10WallMessage.getForumThemeName()%></li>
                <li class="date-time"><%=last10WallMessage.getDateTime()%> написал(а): </li>

                <li class="header">Заголовок: <%=last10WallMessage.getMessageHeader()%></li>
                <li class="text"><%=last10WallMessage.getText()%></li>
                <li class="picture"><img src="wall_message_picture?wall_message_picture_id=<%=last10WallMessage.getId()%>" /></li>
                <li class="link">
                    <a href="forum-this-topic?this_forum_topic_id=<%=last10WallMessage.getId()%>"> ссылка на обсуждение </a>
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
