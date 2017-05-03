<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="controllers.ForumThemeController" %>
<%@ page import="model.*" %>
<%@ page import="java.util.Collection"%>
<%@ page import="controllers.ForumTopicController" %>
<html>
<head>
    <title></title>

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Spirax">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <style>
        <%@include file="../../styles/main.css" %>
    </style>

</head>

<body>

<div class="forum-this-topic">

    <%
        Collection<WallMessage> thisTopicWallMessages = (Collection<WallMessage>) request.getAttribute(ForumTopicController.THIS_TOPIC_WALL_MESSAGES_KEY);
    %>

    <table>
        <tr>
            <th>Forum Theme</th>
            <th>Message Header</th>
            <th>Sender User</th>
            <th>Date and time</th>
            <th>Text</th>
            <th>Picture</th>
        </tr>
        <%
            for (WallMessage thisTopicWallMessage: thisTopicWallMessages) {
        %>
        <tr>
            <td><%=thisTopicWallMessage.getForumThemeName()%></td>
            <td><%=thisTopicWallMessage.getMessageHeader()%></td>
            <td><img src="users_profile_picture?user_id=<%=thisTopicWallMessage.getSenderUserId()%>" /></td>
            <td><%=thisTopicWallMessage.getSenderUserFirstNameAndLastName()%></td>
            <td><%=thisTopicWallMessage.getDateTime()%></td>
            <td><%=thisTopicWallMessage.getText()%></td>
            <td><%=thisTopicWallMessage.getPicture()%></td>
        </tr>
        <%
            }
        %>

    </table>

</div>

</body>
</html>
