<%@ page import="java.util.Collection" %>
<%@ page import="controllers.UserPhotoAlbumsController" %>
<%@ page import="model.PhotoAlbum" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

    <style>
        <%@include file="../../styles/main.css" %>
        <%@include file="../../styles/photoalbums.css" %>
    </style>

</head>
<body>

<%
    Collection<PhotoAlbum> userPhotoAlbums = (Collection<PhotoAlbum>) request.getAttribute(UserPhotoAlbumsController.USER_PHOTOALBUMS_KEY);
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

    <%--проверка, что ссылка + метод работает--%>
    <%--<td><img src="<%=userPhotoAlbum.getFakePath("/img/default_large.png")%>" alt="WORK"></td>--%>

    <%--проверка, что можно открыть файл с диска--%>
    <%--<td><img src="/img/no_image.jpg"></td>--%>

    <%--проверка, что можно хранить изображения в файловой системе и генерить ссылку по id--%>
    <%--<td><img src="/img/<%=userPhotoAlbum.getId()%>.jpg"></td>--%>

    <%--попытка отправить атрибут в сервлет при помощи сессии - не отправляется--%>
    <%--<%request.getSession().setAttribute("photoalbum_id", userPhotoAlbum.getId());%>--%>

</section>


</body>
</html>
