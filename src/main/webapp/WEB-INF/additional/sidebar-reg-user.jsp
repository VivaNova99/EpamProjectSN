
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Spirax">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <style>
        <%@include file="../../styles/main.css" %>
        <%@include file="../../styles/sidebar-reg-user.css" %>
    </style>
</head>
<body>

<div class="sidebar-reg-user">
    <ul>
        <li><a href="my-page?j_username=<%=session.getAttribute("j_username")%>"><i class="fa fa-home" aria-hidden="true"></i>Моя страница</a></li>
        <%--<li><a href="my-page"><i class="fa fa-home" aria-hidden="true"></i>Моя страница</a></li>--%>
        <li><a href="reg-user-news?j_username=<%=session.getAttribute("j_username")%>"><i class="fa fa-newspaper-o" aria-hidden="true"></i>Новости</a></li>
        <li><a href="reg-user-private-messages?j_username=<%=session.getAttribute("j_username")%>"><i class="fa fa-comments" aria-hidden="true"></i>Сообщения</a></li>
        <li><a href="reg-user-all-friends?j_username=<%=session.getAttribute("j_username")%>"><i class="fa fa-users" aria-hidden="true"></i>Друзья</a></li>
        <li><a href="user-photos?j_username=<%=session.getAttribute("j_username")%>"><i class="fa fa-picture-o" aria-hidden="true"></i>Фотографии</a></li>
        <li><a href="user-photoalbums?j_username=<%=session.getAttribute("j_username")%>"><i class="fa fa-book" aria-hidden="true"></i>Фотоальбомы</a></li>
        <li><a href="reg-user-forum.jsp"><i class="fa fa-comments-o" aria-hidden="true"></i>Форум</a></li>
        <li><a href="my-themes?j_username=<%=session.getAttribute("j_username")%>"><i class="fa fa-commenting" aria-hidden="true"></i>Мои темы</a></li>
        <li><a href="reg-user-answers?j_username=<%=session.getAttribute("j_username")%>"><i class="fa fa-commenting-o" aria-hidden="true"></i>Мои ответы</a></li>
        <%--<li>user Id - <%=session.getAttribute("j_id")%></li>--%>
    </ul>
</div>
<%--<input type="hidden" name="j_id" value="<%=request.getParameter("j_id")%>" />--%>

</body>
</html>
