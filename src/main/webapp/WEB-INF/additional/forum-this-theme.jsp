
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true"
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
                <li class="header"><a href="forum-this-topic?this_forum_topic_id=<%=thisThemeWallMessage.getId()%>&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><%=thisThemeWallMessage.getMessageHeader()%></a></li>
                <li class="name"><%=thisThemeWallMessage.getSenderUserFirstNameAndLastName()%></li>
                <li class="date-time"><%=thisThemeWallMessage.getDateTime()%></li>
            </ul>

        </li>
        <%
                subforumName = thisThemeWallMessage.getForumThemeName();
            }
        %>

        <li class="forum-theme"><h1><%=subforumName%></h1></li>

    </ul>

</section>

</body>
</html>
