
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="controllers.WelcomeController" %>
<%@ page import="java.util.Collection" %>
<%@ page import="model.*" %>
<html>
<head>
    <%--<title><%=request.getAttribute(WelcomeController.WELCOME_KEY) %> Добро пожаловать</title>--%>
    <title>${requestScope.get(WelcomeController.WELCOME_KEY)} Добро пожаловать</title>
</head>
<body>

<%
    Collection<ForumTheme> forumThemes = (Collection<ForumTheme>) request.getAttribute(WelcomeController.ALL_FORUM_THEMES_KEY);
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



<%
    Collection<User> users = (Collection<User>) request.getAttribute(WelcomeController.ALL_USERS_KEY);
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

</table>


<%
    Collection<PhotoAlbum> photoAlbums = (Collection<PhotoAlbum>) request.getAttribute(WelcomeController.ALL_PHOTO_ALBUMS_KEY);
%>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>User</th>
        <th>Album Picture</th>
        <th>Description</th>
        <th>Date and time</th>
        <th>Status</th>
    </tr>
    <%
        for (PhotoAlbum photoAlbum: photoAlbums) {
    %>
    <tr>
        <td><%=photoAlbum.getId()%></td>
        <td><%=photoAlbum.getName()%></td>
        <td><%=photoAlbum.getUserFirstNameAndLastName()%></td>
        <td><%=photoAlbum.getAlbumPicture()%></td>
        <td><%=photoAlbum.getDescription()%></td>
        <td><%=photoAlbum.getDateTime()%></td>
        <td><%=photoAlbum.getStatus()%></td>
    </tr>
    <%
        }
    %>

</table>



<%
    Collection<Photo> photos = (Collection<Photo>) request.getAttribute(WelcomeController.ALL_PHOTOS_KEY);
%>

<table>
    <tr>
        <th>Id</th>
        <th>User</th>
        <th>PhotoAlbum</th>
        <th>Picture</th>
        <th>Description</th>
        <th>Date and time</th>
        <th>Status</th>
    </tr>
    <%
        for (Photo photo: photos) {
    %>
    <tr>
        <td><%=photo.getId()%></td>
        <td><%=photo.getUserFirstNameAndLastName()%></td>
        <td><%=photo.getPhotoAlbumName()%></td>
        <td><%=photo.getPicture()%></td>
        <td><%=photo.getDescription()%></td>
        <td><%=photo.getDateTime()%></td>
        <td><%=photo.getStatus()%></td>
    </tr>
    <%
        }
    %>

</table>



<%
    Collection<PrivateMessage> privateMessages = (Collection<PrivateMessage>) request.getAttribute(WelcomeController.ALL_PRIVATE_MESSAGES_KEY);
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
    Collection<WallMessage> wallMessages = (Collection<WallMessage>) request.getAttribute(WelcomeController.ALL_WALL_MESSAGES_KEY);
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
        <td><%=wallMessage.getPicture()%></td>
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

</body>

</html>
