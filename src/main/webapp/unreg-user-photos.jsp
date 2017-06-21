<%@ page import="java.util.Collection" %>
<%@ page import="model.Photo" %>
<%@ page import="controllers.UserPhotosController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
<head>
    <title></title>

    <style>
        <%@include file="styles/main.css" %>
        <%@include file="styles/photos.css" %>
    </style>

</head>

<body>

<header class="unreg">
    <%@ include file="WEB-INF/additional/header-unreg.jsp" %>
</header>

<section class="unreg all-user-photos">

    <%
        Collection<Photo> userPhotos = (Collection<Photo>) request.getAttribute(UserPhotosController.USER_PHOTOS_KEY);
    %>

    <h1 class="my-photos">Фотографии</h1>

    <ul>
        <li>
            <%
                for (Photo userPhoto: userPhotos) {
            %>
            <ul>
                <li class="photoalbum"><%=userPhoto.getPhotoAlbumName()%></li>
                <li class="user-photo">
                    <a rel="nofollow" target="_blank" href="photo_picture?photo_id=<%=userPhoto.getId()%>">
                        <img height="250" src="photo_picture?photo_id=<%=userPhoto.getId()%>">
                    </a>
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
