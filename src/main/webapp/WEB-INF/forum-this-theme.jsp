
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="controllers.ForumThemeController" %>
<%@ page import="model.*" %>
<%@ page import="java.util.Collection"%>
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

<div class="forum-this-theme">

    <%
        Collection<WallMessage> thisThemeWallMessages = (Collection<WallMessage>) request.getAttribute(ForumThemeController.THIS_THEME_WALL_MESSAGES_KEY);
    %>

    <table>
        <tr>
            <th>Message Header</th>
            <th>Sender User</th>
            <th>Date and time</th>
            <th>Text</th>
            <th>Picture</th>
            <th>Forum Theme</th>
        </tr>
        <%
            for (WallMessage thisThemeWallMessage: thisThemeWallMessages) {
        %>
        <tr>
            <td><a href="forum-this-topic"><%=thisThemeWallMessage.getMessageHeader()%></a></td>
            <td><%=thisThemeWallMessage.getSenderUserFirstNameAndLastName()%></td>
            <td><%=thisThemeWallMessage.getDateTime()%></td>
            <td><%=thisThemeWallMessage.getText()%></td>
            <td><%=thisThemeWallMessage.getPicture()%></td>
            <td><%=thisThemeWallMessage.getForumThemeName()%></td>
        </tr>
        <%
            }
        %>

    </table>

</div>

</body>
</html>
