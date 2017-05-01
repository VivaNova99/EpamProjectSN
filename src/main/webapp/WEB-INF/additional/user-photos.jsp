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
        <th>Picture</th>
        <th>Description</th>
        <th>Date and time</th>
        <th>PhotoAlbum</th>
    </tr>
    <%
        for (Photo userPhoto: userPhotos) {
    %>
    <tr>
        <td><img src="photo_picture?photo_id=<%=userPhoto.getId()%>" /></td>
        <td><%=userPhoto.getDescription()%></td>
        <td><%=userPhoto.getDateTime()%></td>
        <td><%=userPhoto.getPhotoAlbumName()%></td>
    </tr>
    <%
        }
    %>

</table>


</body>
</html>
