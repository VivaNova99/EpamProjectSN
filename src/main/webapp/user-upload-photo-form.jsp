<%@ page import="model.PhotoAlbum" %>
<%@ page import="java.util.Collection" %>
<%@ page import="servlets.BuildPhotoAlbumList" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="POST" enctype="multipart/form-data" action="upload_users_profile_picture">
    Выберите файл: <input type="file" name="upfile"><br/>
    <%--Добавьте описание: <input type="text" name="description"><br/>--%>
    <br/>

    <%--TODO: передать параметр с номером фотоальбома--%>

    <input type="hidden" name="user_id" value="<%=request.getParameter("user_id")%>"/>
    <input type="hidden" name="email" value="<%=request.getParameter("email")%>"/>

    <input type="submit" value="Загрузить файл">

</form>

<%
    Collection<PhotoAlbum> userPhotoAlbums = (Collection<PhotoAlbum>) request.getAttribute(BuildPhotoAlbumList.USER_PHOTOALBUMS_KEY);
%>

<section class="all-user-photoalbums">

    <h1 class="my-photoalbums">Мои фотоальбомы</h1>

    <ul>
        <li>
            <%
                for (PhotoAlbum userPhotoAlbum: userPhotoAlbums) {
            %>
            <ul>
                <li class="photoalbum"><%=userPhotoAlbum.getName()%></li>
                <li class="user-photoalbum">
                    <img src="photoalbum_picture?photoalbum_id=<%=userPhotoAlbum.getId()%>" />
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
