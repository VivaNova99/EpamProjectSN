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
        User someUser = (User) request.getAttribute(SmbPageController.SOME_USER_INFO_KEY);
    %>

    <div class="user-profile-picture"><img src="users_profile_picture?users_profile_picture_id=<%=someUser.getId()%>" /></div><br>

    <section class="some-user-info">

        <div class="user-name"><%=someUser.getFirstName()%> <%=someUser.getLastName()%></div>
        <div class="user-status-on-wall"><%=someUser.getStatusOnWall()%></div>
        <div class="user-dob">День рождения: <%=someUser.getDateOfBirth()%></div>
        <div class="user-city">Город: <%=someUser.getCity()%></div>
    </section>

<%
    Collection<Photo> last5ForSomeUserPhotos = (Collection<Photo>) request.getAttribute(SmbPageController.LAST_5_FOR_SOME_USER_PHOTOS_KEY);
%>

    <section class="user-photos">

        <h1 class="my-photos">Фотографии</h1>

        <ul>
            <%
                for (Photo last5ForSomeUserPhoto: last5ForSomeUserPhotos) {
            %>
            <li class="user-last-photo">
                <a rel="nofollow" target="_blank" href="photo_picture?photo_id=<%=last5ForSomeUserPhoto.getId()%>">
                    <img height="150" src="photo_picture?photo_id=<%=last5ForSomeUserPhoto.getId()%>">
                </a>
            </li>
            <%
                }
            %>
        </ul>

    </section>


    <section class="some-user-wall-messages">
    <%--<textarea class="whats-new" placeholder="Что у Вас нового?"></textarea>--%>

        <%
            Collection<WallMessage> last10ForSomeUserWallMessages = (Collection<WallMessage>) request.getAttribute(UserOwnPageController.LAST_10_FOR_USER_WALL_MESSAGES_KEY);
        %>

        <ul class="my-wall">
            <li class="my-notes"><h1>Записи</h1></li>
            <%
                for (WallMessage last10ForSomeUserWallMessage: last10ForSomeUserWallMessages) {
            %>
            <ul>
                <li class="header">
                    <%=last10ForSomeUserWallMessage.getMessageHeader()%>
                </li>
                <li class="date-time">
                    <%=last10ForSomeUserWallMessage.getDateTime()%> написал(а):
                </li>
                <li class="text">
                    <%=last10ForSomeUserWallMessage.getText()%>
                </li>
                <li class="picture">
                    <img src="wall_message_picture?wall_message_picture_id=<%=last10ForSomeUserWallMessage.getId()%>" />
                </li>
                <li class="link">
                    <a href="forum-this-topic?this_forum_topic_id=<%=last10ForSomeUserWallMessage.getId()%>&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"> ссылка на обсуждение </a>
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
