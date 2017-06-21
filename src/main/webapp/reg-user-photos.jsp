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

<header class="reg-user">
    <%@ include file="WEB-INF/additional/header-reg-user.jsp" %>
</header>

<aside class="reg-user">
    <%@ include file="WEB-INF/additional/sidebar-reg-user.jsp" %>
</aside>

<section class="reg-user all-user-photos">

    <%
        Collection<Photo> userPhotos = (Collection<Photo>) request.getAttribute(UserPhotosController.USER_PHOTOS_KEY);
    %>

    <h1 class="my-photos">Мои фотографии</h1>

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
                <li class="delete-photo">
                    <form method="POST" action="delete_photo">

                        <input type="hidden" name="photo_id" value="<%=userPhoto.getId()%>"/>
                        <input type="hidden" name="user_id" value="<%=session.getAttribute("user_id")%>"/>
                        <input type="hidden" name="email" value="<%=session.getAttribute("email")%>"/>

                        <input type="submit" value="Удалить эту фотографию"/>

                    </form>
                </li>
                <%
                    }
                %>
            </ul>
        </li>
    </ul>

</section>

<section class="reg-user create-photo">
    <form method="POST" action="photoalbums_list">

        <input type="hidden" name="user_id" value="<%=session.getAttribute("user_id")%>"/>
        <input type="hidden" name="email" value="<%=session.getAttribute("email")%>"/>

        <input type="submit" value="Загрузить новую фотографию"/>

        <%--<%System.out.println("In reg-user-photoalbums.jsp: user_id - " + session.getAttribute("user_id") + ", " +--%>
        <%--"email - " + session.getAttribute("email") + ", " +--%>
        <%--"photoalbum_name - " + request.getParameter("photoalbum_name") + ", " +--%>
        <%--"description - " + request.getParameter("description"));%>--%>

    </form>
</section>

</body>
</html>
