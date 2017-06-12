<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="POST" action="change-user-info">

    Изменить пароль <input type="text" name="password" title="Password"/><br>
    Изменить имя <input type="text" name="first_name" title="First Name" value="<%=request.getParameter("first_name")%>"/><br>
    Изменить фамилию <input type="text" name="last_name" title="Last Name" value="<%=request.getParameter("last_name")%>"/><br>
    Изменить дату рождения <input type="date" name="date_of_birth" title="Date of Birth" value="<%=request.getParameter("dob")%>"/><br>
    Изменить город <input type="text" name="city" title="City" value="<%=request.getParameter("city")%>"/><br>
    Изменить статус <input type="text" name="status" title="Status" value="<%=request.getParameter("status")%>"/><br>
    <input type="hidden" name="user_id" value="<%=request.getParameter("user_id")%>"/>
    <input type="hidden" name="email" value="<%=request.getParameter("email")%>"/>

    <input type="submit" value="submit"/>

</form>

<a href="my-page">Вернуться на свою страницу</a>


<div class="text-article">
    <c:if test="${notif ne null}">
        <div class="notif">
            <span>${notif}</span>
        </div>
    </c:if>
    <form method="POST" action="registration">
    </form>
</div>


</body>
</html>
