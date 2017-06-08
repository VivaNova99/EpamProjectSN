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

    <input type="hidden" name="user_id" value="<%=request.getParameter("user_id")%>"/>
    <input type="hidden" name="email" value="<%=request.getParameter("email")%>"/>

    <input type="submit" value="Загрузить файл">

</form>

</body>
</html>
