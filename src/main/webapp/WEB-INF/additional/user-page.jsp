<%@ page import="controllers.UserOwnPageController" %>
<%@ page import="model.User" %>
<%@ page import="java.util.Collection" %>
<%@ page import="model.WallMessage" %>
<%@ page import="model.Photo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

    <style>
        <%@include file="../../styles/main.css" %>
        <%@include file="../../styles/user-page.css" %>
    </style>

</head>
<body>

<div class="user-page">

    <%
        User user = (User) request.getAttribute(UserOwnPageController.USER_INFO_KEY);
    %>

    <div class="user-profile-picture"><img src="users_profile_picture?user_id=<%=user.getId()%>" /></div>

    <section class="user-info">

        <div class="user-name"><%=user.getFirstName()%> <%=user.getLastName()%></div>
        <div class="user-status-on-wall"><%=user.getStatusOnWall()%></div>
        <div class="user-dob"><%=user.getDateOfBirth()%></div>
        <div class="user-city"><%=user.getCity()%></div>
    </section>

<%
    Collection<Photo> last5ForUserPhotos = (Collection<Photo>) request.getAttribute(UserOwnPageController.LAST_5_FOR_USER_PHOTOS_KEY);
%>

    <div class="user-last-5-photos">

        <h1>Мои фотографии</h1>
        <%
            for (Photo last5ForUserPhoto: last5ForUserPhotos) {
        %>

        <div class="user-last-photo"><img src="photo_picture?photo_id=<%=last5ForUserPhoto.getId()%>"></div>

        <%
            }
        %>

    </div>


    <div class="user-last-10-wall-messages">
    <textarea class="whats-new" placeholder="Что у Вас нового?"></textarea>

<%
    Collection<WallMessage> last10ForUserWallMessages = (Collection<WallMessage>) request.getAttribute(UserOwnPageController.LAST_10_FOR_USER_WALL_MESSAGES_KEY);
%>

    <table>
        <caption>Мои записи</caption>
        <%
            for (WallMessage last10ForUserWallMessage: last10ForUserWallMessages) {
        %>
        <tr>
            <td class="user-last-wall-message-header"><%=last10ForUserWallMessage.getMessageHeader()%></td>
        </tr>
        <tr>
            <td class="user-last-wall-message-date-time"><%=last10ForUserWallMessage.getDateTime()%></td>
        </tr>
        <tr>
            <td class="user-last-wall-message-text"><%=last10ForUserWallMessage.getText()%></td>
        </tr>
        <tr>
            <td class="user-last-wall-message-picture"><img src="wall_message_picture?wall_message_picture_id=<%=last10ForUserWallMessage.getId()%>" /></td>
        </tr>
        <%
            }
        %>
    </table>
    </div>

</div>

</body>
</html>
