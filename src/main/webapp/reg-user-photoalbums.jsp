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

<html> 

<head> 
<title></title>
 </head>

 <body>  

<header class="reg-user"> 
    <%@ include file="WEB-INF/additional/header-reg-user.jsp" %> 
</header>  

<aside class="reg-user"> 
    <%@ include file="WEB-INF/additional/sidebar-reg-user.jsp" %>
</aside>



<section class="reg-user all-user-photoalbums">

      <%
    Collection<PhotoAlbum> userPhotoAlbums = (Collection<PhotoAlbum>) request.getAttribute(UserPhotoAlbumsController.USER_PHOTOALBUMS_KEY);
%>

    <h1 class="my-photoalbums">Мои фотоальбомы</h1>

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

<section class="reg-user create-photoalbum">
    <%--<form method="POST" action="photoalbums_parameters">--%>
        <form method="POST" action="user-create-photoalbum-form.jsp">

            <input type="hidden" name="user_id" value="<%=session.getAttribute("user_id")%>"/>
            <input type="hidden" name="email" value="<%=session.getAttribute("email")%>"/>

            <input type="submit" value="Создать новый фотоальбом"/>

        <%--<%System.out.println("In reg-user-photoalbums.jsp: user_id - " + session.getAttribute("user_id") + ", " +--%>
                <%--"email - " + session.getAttribute("email") + ", " +--%>
                <%--"photoalbum_name - " + request.getParameter("photoalbum_name") + ", " +--%>
                <%--"description - " + request.getParameter("description"));%>--%>
        </form>
</section>

</body>

 </html>