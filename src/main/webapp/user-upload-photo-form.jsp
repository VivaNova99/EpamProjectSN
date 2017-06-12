<%@ page import="model.PhotoAlbum" %>
<%@ page import="java.util.Collection" %>
<%@ page import="servlets.BuildPhotoAlbumsList" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="POST" enctype="multipart/form-data" action="upload_users_photo_picture">
    Выберите файл: <input type="file" name="upfile"><br/>
    Добавьте описание: <input type="text" name="description"><br/>

     <%
    Collection<PhotoAlbum> userPhotoAlbums = (Collection<PhotoAlbum>) request.getAttribute(BuildPhotoAlbumsList.USER_PHOTOALBUMS_KEY);
%>


    <select name="photoalbum_name" required><option>Выберите фотоальбом</option>
        <%
            for (PhotoAlbum userPhotoAlbum: userPhotoAlbums) {
        %>
        <option><%=userPhotoAlbum.getName()%></option>
        <%
            }
        %>
    </select> <br/>

    <%--<input type="hidden" name="user_id" value="<%=request.getAttribute("user_id")%>"/>--%>

    <input type="hidden" name="user_id" value="<%=request.getParameter("user_id")%>"/>
    <input type="hidden" name="email" value="<%=request.getParameter("email")%>"/>

    <input type="submit" value="Загрузить файл">

</form>

</body>
</html>