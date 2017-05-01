<%@ page import="java.util.Collection" %>
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

        <%--проверка, что ссылка + метод работает--%>
        <%--<td><img src="<%=userPhotoAlbum.getFakePath("/img/default_large.png")%>" alt="WORK"></td>--%>

            <%--проверка, что можно открыть файл с диска--%>
        <%--<td><img src="/img/no_image.jpg"></td>--%>

            <%--проверка, что можно хранить изображения в файловой системе и генерить ссылку по id--%>
            <%--<td><img src="/img/<%=userPhotoAlbum.getId()%>.jpg"></td>--%>

            <%--попытка отправить атрибут в сервлет при помощи сессии - не отправляется--%>
            <%--<%request.getSession().setAttribute("photoalbum_id", userPhotoAlbum.getId());%>--%>

            <td><img src="photoalbum_picture?photoalbum_id=<%=userPhotoAlbum.getId()%>" /></td>


            <td><%=userPhotoAlbum.getName()%></td>
        <td><%=userPhotoAlbum.getDescription()%></td>

    </tr>
    <%
        }
    %>

</table>


</body>
</html>
