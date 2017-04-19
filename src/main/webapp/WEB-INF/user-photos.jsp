<%@ page import="controllers.UserOwnPageController" %>
<%@ page import="model.User" %>
<%@ page import="java.util.Collection" %>
<%@ page import="model.WallMessage" %>
<%@ page import="model.Photo" %>
<%@ page import="controllers.UserPhotosController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<%
    Collection<Photo> userPhotos = (Collection<Photo>) request.getAttribute(UserPhotosController.USER_PHOTOS_KEY);
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
        for (Photo userPhoto: userPhotos) {
    %>
    <tr>
        <td><%=userPhoto.getId()%></td>
        <td><%=userPhoto.getUserFirstNameAndLastName()%></td>
        <td><%=userPhoto.getPhotoAlbumName()%></td>
        <td><%=userPhoto.getPicture()%></td>
        <td><%=userPhoto.getDescription()%></td>
        <td><%=userPhoto.getDateTime()%></td>
        <td><%=userPhoto.getStatus()%></td>
    </tr>
    <%
        }
    %>

</table>


</body>
</html>
