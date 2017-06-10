
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="POST" action="registration">

    Введите Ваш e-mail <input type="text" name="email" title="Login"/><br>
    Введите выбранный пароль <input type="text" name="password" title="Password"/><br>
    Введите Ваше имя <input type="text" name="first_name" title="First Name"/><br>
    Введите Вашу фамилию <input type="text" name="last_name" title="Last Name"/><br>
    Введите дату Вашего рождения <input type="date" name="date_of_birth" title="Date of Birth" value="1990-01-01"/><br>
    Введите Ваш город <input type="text" name="city" title="City"/><br>

    <input type="submit" value="submit"/>

</form>

<a href="/">Вернуться на главную страницу</a>


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
