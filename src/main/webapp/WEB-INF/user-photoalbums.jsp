<%@ page import="controllers.UserOwnPageController" %>
<%@ page import="model.User" %>
<%@ page import="java.util.Collection" %>
<%@ page import="model.WallMessage" %>
<%@ page import="model.Photo" %>
<%@ page import="controllers.UserPhotosController" %>
<%@ page import="controllers.UserPhotoAlbumsController" %>
<%@ page import="model.PhotoAlbum" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<%
    Collection<PhotoAlbum> userPhotoAlbums = (Collection<PhotoAlbum>) request.getAttribute(UserPhotoAlbumsController.USER_PHOTOALBUMS_KEY);
%>

<table>
    <tr>
        <th>Album Picture</th>
        <th>Name</th>
        <th>Description</th>
    </tr>
    <%
        for (PhotoAlbum userPhotoAlbum: userPhotoAlbums) {
    %>
    <tr>
        <td><%=userPhotoAlbum.getAlbumPicture()%></td>
        <td><%=userPhotoAlbum.getName()%></td>
        <td><%=userPhotoAlbum.getDescription()%></td>
    </tr>
    <%
        }
    %>

</table>


</body>
</html>
