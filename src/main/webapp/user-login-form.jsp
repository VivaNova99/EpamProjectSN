
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<%--<form method="POST" action="my-page">--%>
<form method="POST" action="login">
    <input type="text" name="email" title="Login"/><br>
    <input type="password" name="password" autocomplete="off" title="Password"/><br>
    <%--<input type="text" name="j_username" title="Login"/><br>--%>
    <%--<input type="password" name="j_password" autocomplete="off" title="Password"/><br>--%>
    <input type="submit" value="submit"/>

    <%--<%System.out.println("In user-login-form.jsp: user_id - " + session.getAttribute("user_id") + ", " +--%>
            <%--"email - " + session.getAttribute("email") + ", " +--%>
            <%--"photoalbum_name - " + request.getParameter("photoalbum_name") + ", " +--%>
            <%--"description - " + request.getParameter("description"));%>--%>
<%--</form>--%>

<a href="/">Вернуться на главную страницу</a>

</body>
</html>
