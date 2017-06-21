 <%@ page import="java.util.Collection" %>
<%@ page import="controllers.UserPhotoAlbumsController" %>
<%@ page import="model.PhotoAlbum" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
<head>
    <title></title>

    <style>
        <%@include file="styles/main.css" %>
        <%@include file="styles/photoalbums.css" %>
    </style>

</head>
<body>

<header class="unreg">
    <%@ include file="WEB-INF/additional/header-unreg.jsp" %>
</header>

<section class="unreg all-user-photoalbums">

      <%
    Collection<PhotoAlbum> userPhotoAlbums = (Collection<PhotoAlbum>) request.getAttribute(UserPhotoAlbumsController.USER_PHOTOALBUMS_KEY);
%>

    <h1 class="my-photoalbums">Фотоальбомы</h1>

    <ul>
        <li>
            <%
                for (PhotoAlbum userPhotoAlbum: userPhotoAlbums) {
            %>
            <ul>
                <li class="photoalbum"><%=userPhotoAlbum.getName()%></li>
                <li class="user-photoalbum"><a href="user-photos-in-photoalbum?email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>&photoalbum_id=<%=userPhotoAlbum.getId()%>">
                    <img src="photoalbum_picture?photoalbum_id=<%=userPhotoAlbum.getId()%>" /></a>
                </li>
                <li class="description"><%=userPhotoAlbum.getDescription()%></li>
                <%
                    }
                %>
            </ul>
        </li>
    </ul>

</section>

</body>
</html>
