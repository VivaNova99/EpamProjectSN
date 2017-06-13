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

<form method="POST" enctype="multipart/form-data" action="create_users_photoalbum">
    Введите название альбома: <input type="text" name="photoalbum_name"><br/>
    Выберите картинку для обложки альбома: <input type="file" name="upfile"><br/>
    Добавьте описание: <input type="text" name="description"><br/>

    <input type="hidden" name="user_id" value="<%=request.getParameter("user_id")%>"/>
    <input type="hidden" name="email" value="<%=request.getParameter("email")%>"/>

    <input type="submit" value="Создать альбом">

    <%System.out.println("In user-create-photoalbum-form.jsp: user_id - " + request.getParameter("user_id") + ", " +
            "email - " + request.getParameter("email") + ", " +
            "photoalbum_name - " + request.getParameter("photoalbum_name") + ", " +
            "description - " + request.getParameter("description"));%>

</form>

</body>
</html>