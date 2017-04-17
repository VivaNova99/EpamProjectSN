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
        <%@include file="../styles/main.css" %>
    </style>

</head>

<body>

<div class="forum-this-topic">

    <%
        Collection<WallMessage> thisTopicWallMessages = (Collection<WallMessage>) request.getAttribute(ForumTopicController.THIS_TOPIC_WALL_MESSAGES_KEY);
    %>

    <table>
        <tr>
            <th>Id</th>
            <th>Sender User</th>
            <th>Text</th>
            <th>Picture</th>
            <th>Date and time</th>
            <th>Forum Theme</th>
            <th>Message Header</th>
            <th>Is Parent?</th>
            <th>Parent Message</th>
            <th>Status</th>
        </tr>
        <%
            for (WallMessage thisTopicWallMessage: thisTopicWallMessages) {
        %>
        <tr>
            <td><%=thisTopicWallMessage.getId()%></td>
            <td><%=thisTopicWallMessage.getSenderUserFirstNameAndLastName()%></td>
            <td><%=thisTopicWallMessage.getText()%></td>
            <td><%=thisTopicWallMessage.getPicture()%></td>
            <td><%=thisTopicWallMessage.getDateTime()%></td>
            <td><%=thisTopicWallMessage.getForumThemeName()%></td>
            <td><%=thisTopicWallMessage.getMessageHeader()%></td>
            <td><%=thisTopicWallMessage.getParent()%></td>
            <td><%=thisTopicWallMessage.getParentMessageText()%></td>
            <td><%=thisTopicWallMessage.getStatus()%></td>
        </tr>
        <%
            }
        %>

    </table>

</div>

</body>
</html>
