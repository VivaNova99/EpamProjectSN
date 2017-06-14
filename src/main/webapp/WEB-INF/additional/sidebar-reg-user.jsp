
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
        <%--<%String params = "email="+request.getParameter("email") + "&user_id="+request.getParameter("user_id");%>--%>

        <%--<li><a href="my-page?email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><i class="fa fa-home" aria-hidden="true"></i>Моя страница</a></li>--%>
        <%--<li><a href="reg-user-news?email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><i class="fa fa-newspaper-o" aria-hidden="true"></i>Новости</a></li>--%>
        <%--<li><a href="reg-user-private-messages?email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><i class="fa fa-comments" aria-hidden="true"></i>Сообщения</a></li>--%>
        <%--<li><a href="reg-user-all-friends?email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><i class="fa fa-users" aria-hidden="true"></i>Друзья</a></li>--%>
        <%--<li><a href="user-photos?email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><i class="fa fa-picture-o" aria-hidden="true"></i>Фотографии</a></li>--%>
        <%--<li><a href="user-photoalbums?user_id=<%=request.getParameter("user_id")%>&email=<%=request.getParameter("email")%>"><i class="fa fa-book" aria-hidden="true"></i>Фотоальбомы</a></li>--%>
        <%--&lt;%&ndash;<li><a href="user-photoalbums?<%=params%>"><i class="fa fa-book" aria-hidden="true"></i>Фотоальбомы</a></li>&ndash;%&gt;--%>
        <%--<li><a href="reg-user-forum.jsp?email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><i class="fa fa-comments-o" aria-hidden="true"></i>Форум</a></li>--%>
        <%--<li><a href="my-themes?email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><i class="fa fa-commenting" aria-hidden="true"></i>Мои темы</a></li>--%>
        <%--<li><a href="reg-user-answers?email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><i class="fa fa-commenting-o" aria-hidden="true"></i>Мои ответы</a></li>--%>
        <li><a href="my-page?email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><i class="fa fa-home" aria-hidden="true"></i>Моя страница</a></li>
        <li><a href="reg-user-news?email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><i class="fa fa-newspaper-o" aria-hidden="true"></i>Новости</a></li>
        <li><a href="reg-user-private-messages?email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><i class="fa fa-comments" aria-hidden="true"></i>Сообщения</a></li>
        <li><a href="reg-user-all-friends?email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><i class="fa fa-users" aria-hidden="true"></i>Друзья</a></li>
        <li><a href="user-photos?email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><i class="fa fa-picture-o" aria-hidden="true"></i>Фотографии</a></li>
        <li><a href="user-photoalbums?email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><i class="fa fa-book" aria-hidden="true"></i>Фотоальбомы</a></li>
        <li><a href="reg-user-forum.jsp?email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><i class="fa fa-comments-o" aria-hidden="true"></i>Форум</a></li>
        <li><a href="my-themes?email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><i class="fa fa-commenting" aria-hidden="true"></i>Мои темы</a></li>
        <li><a href="reg-user-answers?email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><i class="fa fa-commenting-o" aria-hidden="true"></i>Мои ответы</a></li>
        <%--<%System.out.println("In sidebar-reg-user.jsp11111 PARAMS = " + params);%>--%>
        <%System.out.println("In sidebar-reg-user.jsp: user_id - " + session.getAttribute("user_id") + ", " +
                "email - " + session.getAttribute("email") + ", " +
                "photoalbum_name - " + request.getParameter("photoalbum_name") + ", " +
                "description - " + request.getParameter("description"));%>
    </ul>
</div>
<%--<input type="hidden" name="j_id" value="<%=request.getParameter("j_id")%>" />--%>

</body>
</html>
