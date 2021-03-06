<%@ page contentType="text/html;charset=UTF-8" language="java" session="true"
         import="controllers.MyAnswersController" %>
<%@ page import="model.*" %>
<%@ page import="java.util.Collection"%>
<html>
<head>
    <title></title>

    <style>
        <%@include file="styles/main.css" %>
        <%@include file="styles/answers.css" %>
    </style>

</head>
<body>

<header class="reg-user">
    <%@ include file="WEB-INF/additional/header-reg-user.jsp" %>
</header>

<aside class="reg-user">
    <%@ include file="WEB-INF/additional/sidebar-reg-user.jsp" %>
</aside>

<section class="answers">

        <%
        Collection<WallMessage> answersWallMessages = (Collection<WallMessage>) request.getAttribute(MyAnswersController.USER_ANSWERS_KEY);
    %>

    <ul>
        <%
            for (WallMessage answersWallMessage: answersWallMessages) {
        %>
        <li>
            <ul>
                <li class="header"> На Ваш вопрос: <%=answersWallMessage.getMessageHeader()%></li>
                <li class="forum-theme"> В подфоруме: <%=answersWallMessage.getForumThemeName()%></li>
                <li class="profile-picture"><a href="smb-page?some_user_id=<%=answersWallMessage.getSenderUserId()%>">
                    <img src="users_profile_picture?users_profile_picture_id=<%=answersWallMessage.getSenderUserId()%>" /></a></li>
                <li class="name"><a href="smb-page?some_user_id=<%=answersWallMessage.getSenderUserId()%>&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>">
                    <%=answersWallMessage.getSenderUserFirstNameAndLastName()%></a></li>
                <li class="date-time"><%=answersWallMessage.getDateTime()%> Ответил(а): </li>
                <li class="text"><%=answersWallMessage.getText()%></li>
                <li class="picture"><img src="wall_message_picture?wall_message_picture_id=<%=answersWallMessage.getId()%>" /></li>
                <li class="link">
                    <a href="forum-this-topic?this_forum_topic_id=<%=answersWallMessage.getId()%>&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"> ссылка на обсуждение </a>
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
