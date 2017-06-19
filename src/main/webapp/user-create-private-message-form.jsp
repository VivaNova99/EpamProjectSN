<%@ page import="model.PhotoAlbum" %>
<%@ page import="java.util.Collection" %>
<%@ page import="servlets.BuildPhotoAlbumsList" %>
<%@ page import="servlets.BuildForumTopicsList" %>
<%@ page import="model.ForumTheme" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" session="true" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="POST" enctype="multipart/form-data" action="create_private_message">

    <%--<textarea class="your-message" name="private_message_text" placeholder="Ваше сообщение"></textarea>--%>
    Ваше сообщение: <input type="text" name="private_message_text">
    <input type="hidden" name="receiver_user_id" value="<%=request.getParameter("receiver_user_id")%>">
    <input type="hidden" name="sender_user_id" value="<%=request.getParameter("sender_user_id")%>">
    <input type="hidden" name="user_id" value="<%=request.getParameter("user_id")%>">
    <input type="hidden" name="email" value="<%=request.getParameter("email")%>">
        <%--<%System.out.println("In user-create-private-message-form.jsp: receiver_user_id - " + request.getParameter("receiver_user_id") + ", " +--%>
                <%--"sender_user_id - " + request.getParameter("sender_user_id") + ", " +--%>
                <%--"user_id from session - " + session.getAttribute("user_id") + ", " +--%>
                <%--"email from request - " + request.getParameter("email"));%>--%>

    <input type="submit" value="Отправить сообщение">

</form>

</body>
</html>