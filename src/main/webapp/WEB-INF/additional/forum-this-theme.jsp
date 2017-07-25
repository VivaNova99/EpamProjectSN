
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true"
         import="controllers.ForumThemeController" %>
<%@ page import="model.*" %>
<%@ page import="java.util.Collection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <%--<c:forEach var="thisThemeWallMessage" items="${requestScope.thisThemeWallMessages}" varStatus="counter">--%>
        <%--&lt;%&ndash;<c:set var="subforumName" scope="page" value="${thisThemeWallMessage.getForumThemeName()}"/>&ndash;%&gt;--%>

    <%--&lt;%&ndash;&lt;%&ndash;%>--%>
        <%--&lt;%&ndash;Collection<WallMessage> thisThemeWallMessages = (Collection<WallMessage>) request.getAttribute(ForumThemeController.THIS_THEME_WALL_MESSAGES_KEY);&ndash;%&gt;--%>
        <%--&lt;%&ndash;String subforumName = null;&ndash;%&gt;--%>
    <%--&lt;%&ndash;%>&ndash;%&gt;--%>

    <%--<ul>--%>

        <%--<li>--%>
            <%--<ul>--%>
                <%--<li class="topic-header"><a href="forum-this-topic?this_forum_topic_id=<c:out value="${thisThemeWallMessage.id}"/>&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><c:out value="${thisThemeWallMessage.messageHeader}"/></a></li>--%>
                <%--<li class="name"><c:out value="${thisThemeWallMessage.senderUserFirstNameAndLastName}"/></li>--%>
                <%--<li class="date-time"><c:out value="${thisThemeWallMessage.dateTime}"/></li>--%>
            <%--</ul>--%>

        <%--</li>--%>


        <%--&lt;%&ndash;<li class="forum-theme"><h1><c:out value="subforumName"/></h1></li>&ndash;%&gt;--%>

    <%--</ul>--%>



   <%--</c:forEach>--%>

    <%
//        Collection<WallMessage> thisThemeWallMessages = (Collection<WallMessage>) request.getAttribute(ForumThemeController.THIS_THEME_WALL_MESSAGES_KEY);
        Collection<WallMessage> thisThemeWallMessages = (Collection<WallMessage>) request.getAttribute("thisThemeWallMessages1");
        String subforumName = null;
    %>

    <ul>
        <%
            for (WallMessage thisThemeWallMessage: thisThemeWallMessages) {
        %>
        <li>
            <ul>
                <li class="header"><a href="forum-this-topic?this_forum_topic_id=<%=thisThemeWallMessage.getId()%>&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><%=thisThemeWallMessage.getMessageHeader()%></a></li>
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
