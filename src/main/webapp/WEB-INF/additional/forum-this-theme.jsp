
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
        <%@include file="../../styles/main.css" %>
        <%@include file="../../styles/forum-this-theme.css" %>
    </style>

</head>

<body>

<section class="forum-this-theme">

    <%
        Collection<WallMessage> thisThemeWallMessages = (Collection<WallMessage>) request.getAttribute(ForumThemeController.THIS_THEME_WALL_MESSAGES_KEY);
        String subforumName = null;
    %>

    <ul>
        <%
            for (WallMessage thisThemeWallMessage: thisThemeWallMessages) {
        %>
        <li>
            <ul>
                <li class="header"><a href="forum-this-topic?this_forum_topic_id=<%=thisThemeWallMessage.getId()%>"><%=thisThemeWallMessage.getMessageHeader()%></a></li>
                <li class="name"><%=thisThemeWallMessage.getSenderUserFirstNameAndLastName()%></li>
                <li class="date-time"><%=thisThemeWallMessage.getDateTime()%></li>
            </ul>

        </li>
        <%
                subforumName = thisThemeWallMessage.getForumThemeName();
            }
        %>

        <li class="forum-theme"><p1><%=subforumName%></p1></li>

    </ul>

</section>

</body>
</html>
