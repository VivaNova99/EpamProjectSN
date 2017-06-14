
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
    <%@ include file="WEB-INF/additional/user-page.jsp" %>
    <%--<%session.setAttribute("j_id", session.getAttribute("j_id"));%>--%>
    <%--<input type="hidden" name="j_id" value="<%=session.getAttribute("j_id")%>">--%>
    <%--<input type="hidden" name="j_id" value="<%=request.getParameter("j_id")%>" />--%>
    <%System.out.println("In reg-user-own-page.jsp: user_id - " + session.getAttribute("user_id") + ", " +
            "email - " + session.getAttribute("email") + ", " +
            "photoalbum_name - " + request.getParameter("photoalbum_name") + ", " +
            "description - " + request.getParameter("description"));%>
</section>


</body>
</html>
