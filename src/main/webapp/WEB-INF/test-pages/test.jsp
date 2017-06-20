
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true"
         import="controllers.WelcomeController" %>
<%@ page import="java.util.Collection" %>
<%@ page import="model.*" %>
<%@ page import="controllers.TestPageController" %>
<html>
<head>
    <%--<title><%=request.getAttribute(WelcomeController.WELCOME_KEY) %> Добро пожаловать</title>--%>
    <title>${requestScope.get(WelcomeController.WELCOME_KEY)} Добро пожаловать</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Spirax">

        <style>
            <%@include file="../../styles/main.css" %>
        </style>

</head>
<body>

<header>
    <%@ include file="../additional/header-unreg.jsp" %>
    <%@ include file="../additional/header-reg-user.jsp" %>
</header>

<aside>
    <%@ include file="../additional/sidebar-reg-user.jsp" %>
</aside>

<section>

    <%@ include file="../additional/forum-themes.jsp" %>

    <img src="http://minionomaniya.ru/wp-content/uploads/2015/08/%D0%9C%D0%B8%D0%BD%D1%8C%D0%BE%D0%BD-%D0%91%D0%BE%D0%B1.jpg">
    <img src="/img/default_large.png" width="200" height="200">

<%
    Collection<ForumTheme> forumThemes = (Collection<ForumTheme>) request.getAttribute(TestPageController.ALL_FORUM_THEMES_KEY);
%>

<table>
    <tr>
        <th>Id</th>
        <th>Theme order</th>
        <th>Name</th>
    </tr>
    <%
        for (ForumTheme forumTheme: forumThemes) {
    %>
    <tr>
        <td><%=forumTheme.getId()%></td>
        <td><%=forumTheme.getThemeOrder()%></td>
        <td><%=forumTheme.getName()%></td>
    </tr>
    <%
        }
    %>

</table>



<%--<%--%>
    <%--Collection<User> users = (Collection<User>) request.getAttribute(TestPageController.ALL_USERS_KEY);--%>
<%--%>--%>

<%--<table>--%>
    <%--<tr>--%>
        <%--<th>Id</th>--%>
        <%--<th>First Name</th>--%>
        <%--<th>Last Name</th>--%>
        <%--<th>Date of birth</th>--%>
        <%--<th>Access Level</th>--%>
        <%--<th>Email</th>--%>
        <%--<th>Password hash</th>--%>
        <%--<th>Profile photo</th>--%>
        <%--<th>Status on wall</th>--%>
        <%--<th>City</th>--%>
    <%--</tr>--%>
    <%--<%--%>
        <%--for (User user: users) {--%>
    <%--%>--%>
    <%--<tr>--%>
        <%--<td><%=user.getId()%></td>--%>
        <%--<td><%=user.getFirstName()%></td>--%>
        <%--<td><%=user.getLastName()%></td>--%>
        <%--<td><%=user.getDateOfBirth()%></td>--%>
        <%--<td><%=user.getAccessLevel()%></td>--%>
        <%--<td><%=user.getEmail()%></td>--%>
        <%--<td><%=user.getPasswordHash()%></td>--%>
        <%--<td><img src="users_profile_picture?user_id=<%=user.getId()%>" /></td>--%>
        <%--<td><%=user.getStatusOnWall()%></td>--%>
        <%--<td><%=user.getCity()%></td>--%>
    <%--</tr>--%>
    <%--<%--%>
        <%--}--%>
    <%--%>--%>

<%--</table>--%>


<%--<%--%>
    <%--Collection<PhotoAlbum> photoAlbums = (Collection<PhotoAlbum>) request.getAttribute(TestPageController.ALL_PHOTO_ALBUMS_KEY);--%>
<%--%>--%>

<%--<table>--%>
    <%--<tr>--%>
        <%--<th>Id</th>--%>
        <%--<th>Name</th>--%>
        <%--<th>User</th>--%>
        <%--<th>Album Picture</th>--%>
        <%--<th>Description</th>--%>
        <%--<th>Date and time</th>--%>
        <%--<th>Status</th>--%>
    <%--</tr>--%>
    <%--<%--%>
        <%--for (PhotoAlbum photoAlbum: photoAlbums) {--%>
    <%--%>--%>
    <%--<tr>--%>
        <%--<td><%=photoAlbum.getId()%></td>--%>
        <%--<td><%=photoAlbum.getName()%></td>--%>
        <%--<td><%=photoAlbum.getUserFirstNameAndLastName()%></td>--%>
        <%--<td><img src="photoalbum_picture?photoalbum_id=<%=photoAlbum.getId()%>" /></td>--%>
        <%--<td><%=photoAlbum.getDescription()%></td>--%>
        <%--<td><%=photoAlbum.getDateTime()%></td>--%>
        <%--<td><%=photoAlbum.getStatus()%></td>--%>
    <%--</tr>--%>
    <%--<%--%>
        <%--}--%>
    <%--%>--%>

<%--</table>--%>



<%--<%--%>
    <%--Collection<Photo> photos = (Collection<Photo>) request.getAttribute(TestPageController.ALL_PHOTOS_KEY);--%>
<%--%>--%>

<%--<table>--%>
    <%--<tr>--%>
        <%--<th>Id</th>--%>
        <%--<th>User</th>--%>
        <%--<th>PhotoAlbum</th>--%>
        <%--<th>Picture</th>--%>
        <%--<th>Description</th>--%>
        <%--<th>Date and time</th>--%>
        <%--<th>Status</th>--%>
    <%--</tr>--%>
    <%--<%--%>
        <%--for (Photo photo: photos) {--%>
    <%--%>--%>
    <%--<tr>--%>
        <%--<td><%=photo.getId()%></td>--%>
        <%--<td><%=photo.getUserFirstNameAndLastName()%></td>--%>
        <%--<td><%=photo.getPhotoAlbumName()%></td>--%>
        <%--<td><img src="photo_picture?photo_id=<%=photo.getId()%>" /></td>--%>
        <%--<td><%=photo.getDescription()%></td>--%>
        <%--<td><%=photo.getDateTime()%></td>--%>
        <%--<td><%=photo.getStatus()%></td>--%>
    <%--</tr>--%>
    <%--<%--%>
        <%--}--%>
    <%--%>--%>

<%--</table>--%>


<%
    Collection<PrivateMessage> privateMessages = (Collection<PrivateMessage>) request.getAttribute(TestPageController.ALL_PRIVATE_MESSAGES_KEY);
%>

<table>
    <tr>
        <th>Id</th>
        <th>Sender User</th>
        <th>Receiver User</th>
        <th>Text</th>
        <th>Date and time</th>
        <th>Status</th>
    </tr>
    <%
        for (PrivateMessage privateMessage: privateMessages) {
    %>
    <tr>
        <td><%=privateMessage.getId()%></td>
        <td><%=privateMessage.getSenderUserFirstNameAndLastName()%></td>
        <td><%=privateMessage.getReceiverUserFirstNameAndLastName()%></td>
        <td><%=privateMessage.getText()%></td>
        <td><%=privateMessage.getDateTime()%></td>
        <td><%=privateMessage.getStatus()%></td>
    </tr>
    <%
        }
    %>

</table>


<%
    Collection<WallMessage> wallMessages = (Collection<WallMessage>) request.getAttribute(TestPageController.ALL_WALL_MESSAGES_KEY);
%>

<table>
    <tr>
        <th>Id</th>
        <th>Sender User</th>
        <th>Text</th>
        <th>Picture</th>
        <th>Date and time</th>
        <th>Forum Theme</th>
        <th>Message Header</th>
        <th>Is Parent?</th>
        <th>Parent Message</th>
        <th>Status</th>
    </tr>
    <%
        for (WallMessage wallMessage: wallMessages) {
    %>
    <tr>
        <td><%=wallMessage.getId()%></td>
        <td><%=wallMessage.getSenderUserFirstNameAndLastName()%></td>
        <td><%=wallMessage.getText()%></td>
        <td><img src="wall_message_picture?wall_message_picture_id=<%=wallMessage.getId()%>" /></td>
        <td><%=wallMessage.getDateTime()%></td>
        <td><%=wallMessage.getForumThemeName()%></td>
        <td><%=wallMessage.getMessageHeader()%></td>
        <td><%=wallMessage.getParent()%></td>
        <td><%=wallMessage.getParentMessageText()%></td>
        <td><%=wallMessage.getStatus()%></td>
    </tr>
    <%
        }
    %>

</table>

</section>

</body>

</html>
