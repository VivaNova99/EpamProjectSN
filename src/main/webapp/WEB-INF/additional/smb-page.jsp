<%@ page import="controllers.UserOwnPageController" %>
<%@ page import="model.User" %>
<%@ page import="java.util.Collection" %>
<%@ page import="model.WallMessage" %>
<%@ page import="model.Photo" %>
<%@ page import="controllers.SmbPageController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
<head>
    <title></title>

    <style>
        <%@include file="../../styles/main.css" %>
        <%@include file="../../styles/user-page.css" %>
    </style>

</head>
<body>

<div class="user-page unreg-user-page">

    <%
        User user = (User) request.getAttribute(SmbPageController.SOME_USER_INFO_KEY);
    %>

    <div class="user-profile-picture"><img src="users_profile_picture?user_id=<%=user.getId()%>" /></div>

    <section class="user-info">

        <div class="user-name"><%=user.getFirstName()%> <%=user.getLastName()%></div>
        <div class="user-status-on-wall"><%=user.getStatusOnWall()%></div>
        <div class="user-dob">День рождения: <%=user.getDateOfBirth()%></div>
        <div class="user-city">Город: <%=user.getCity()%></div>
    </section>

<%
    Collection<Photo> last5ForUserPhotos = (Collection<Photo>) request.getAttribute(SmbPageController.LAST_5_FOR_SOME_USER_PHOTOS_KEY);
%>

    <section class="user-photos">

        <h1 class="my-photos">Фотографии</h1>

        <ul>
            <%
                for (Photo last5ForUserPhoto: last5ForUserPhotos) {
            %>
            <li class="user-last-photo">
                <a rel="nofollow" target="_blank" href="photo_picture?photo_id=<%=last5ForUserPhoto.getId()%>">
                    <img height="150" src="photo_picture?photo_id=<%=last5ForUserPhoto.getId()%>">
                </a>
            </li>
            <%
                }
            %>
        </ul>

    </section>


    <section class="smb-user-wall-messages">
    <%--<textarea class="whats-new" placeholder="Что у Вас нового?"></textarea>--%>

        <%
            Collection<WallMessage> last10ForUserWallMessages = (Collection<WallMessage>) request.getAttribute(UserOwnPageController.LAST_10_FOR_USER_WALL_MESSAGES_KEY);
        %>

        <ul class="my-wall">
            <li class="my-notes"><h1>Записи</h1></li>
            <%
                for (WallMessage last10ForUserWallMessage: last10ForUserWallMessages) {
            %>
            <ul>
                <li class="header">
                    <%=last10ForUserWallMessage.getMessageHeader()%>
                </li>
                <li class="date-time">
                    <%=last10ForUserWallMessage.getDateTime()%> написал(а):
                </li>
                <li class="text">
                    <%=last10ForUserWallMessage.getText()%>
                </li>
                <li class="picture">
                    <img src="wall_message_picture?wall_message_picture_id=<%=last10ForUserWallMessage.getId()%>" />
                </li>
                <li class="link">
                    <a href="forum-this-topic?this_forum_topic_id=<%=last10ForUserWallMessage.getId()%>"> ссылка на обсуждение </a>
                </li>
            </ul>
            <%
                }
            %>
        </ul>
    </section>

</div>

</body>
</html>
