
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
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

<section class="reg-user">
    <%@ include file="WEB-INF/additional/user-photos.jsp" %>
</section>
<section class="reg-user">
    <form method="POST" action="photoalbums_list">

        <input type="hidden" name="user_id" value="<%=session.getAttribute("user_id")%>"/>
        <input type="hidden" name="email" value="<%=session.getAttribute("email")%>"/>

        <input type="submit" value="Загрузить фотографию"/>

        <%--<%System.out.println("In reg-user-photoalbums.jsp: user_id - " + session.getAttribute("user_id") + ", " +--%>
        <%--"email - " + session.getAttribute("email") + ", " +--%>
        <%--"photoalbum_name - " + request.getParameter("photoalbum_name") + ", " +--%>
        <%--"description - " + request.getParameter("description"));%>--%>

    </form>
</section>

</body>
</html>
