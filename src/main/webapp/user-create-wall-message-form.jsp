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

<form method="POST" enctype="multipart/form-data" action="create_wall_message">
    Ваше сообщение: <input type="text" name="wall_message_text" value="<%=request.getAttribute("wall_message_text")%>"><br/>
    Заголовок сообщения: <input type="text" name="wall_message_header"><br/>
    Добавьте картинку: <input type="file" name="upfile"><br/>


    <%
        Collection<ForumTheme> forumThemes = (Collection<ForumTheme>) request.getAttribute(BuildForumTopicsList.ALL_FORUM_THEMES_KEY);
    %>


    <select name="forum_theme_name" required><option>Выберите тему на форуме</option>
        <%
            for (ForumTheme forumTheme: forumThemes) {
        %>
        <option><%=forumTheme.getName()%></option>
        <%
            }
        %>
    </select> <br/>

    <input type="hidden" name="user_id" value="<%=session.getAttribute("user_id")%>"/>
    <input type="hidden" name="email" value="<%=session.getAttribute("email")%>"/>

    <input type="submit" value="Отправить сообщение на стену и в форум">

</form>

</body>
</html>