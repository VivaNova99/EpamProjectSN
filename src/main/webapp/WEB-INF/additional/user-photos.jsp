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

    <style>
        <%@include file="../../styles/main.css" %>
        <%@include file="../../styles/photos.css" %>
    </style>

</head>
<body>

<%
    Collection<Photo> userPhotos = (Collection<Photo>) request.getAttribute(UserPhotosController.USER_PHOTOS_KEY);
%>

<section class="all-user-photos">

    <h1 class="my-photos">Мои фотографии</h1>

    <ul>
        <li>
            <%
                for (Photo userPhoto: userPhotos) {
            %>
            <ul>
                <li class="photoalbum"><%=userPhoto.getPhotoAlbumName()%></li>
                <li class="user-photo">
                    <img src="photo_picture?photo_id=<%=userPhoto.getId()%>">
                </li>
                <li class="date-time"><%=userPhoto.getDateTime()%></li>
                <li class="description"><%=userPhoto.getDescription()%></li>
                <%
                    }
                %>
            </ul>
        </li>
    </ul>

</section>


</body>
</html>
