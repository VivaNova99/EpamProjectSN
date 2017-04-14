
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="controllers.ThemeController" %>
<%@ page import="model.*" %>
<%@ page import="java.util.Collection"%>
<html>
<head>
    <title></title>

</head>
<body>

<header class="unreg">
    <%@ include file="WEB-INF/header-unreg.jsp" %>
</header>

<section>

    <%
        Collection<WallMessage> thisThemeWallMessages = (Collection<WallMessage>) request.getAttribute(ThemeController.THIS_THEME_WALL_MESSAGES_KEY);
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
            for (WallMessage thisThemeWallMessage: thisThemeWallMessages) {
        %>
        <tr>
            <td><%=thisThemeWallMessage.getId()%></td>
            <td><%=thisThemeWallMessage.getSenderUserFirstNameAndLastName()%></td>
            <td><%=thisThemeWallMessage.getText()%></td>
            <td><%=thisThemeWallMessage.getPicture()%></td>
            <td><%=thisThemeWallMessage.getDateTime()%></td>
            <td><%=thisThemeWallMessage.getForumThemeName()%></td>
            <td><%=thisThemeWallMessage.getMessageHeader()%></td>
            <td><%=thisThemeWallMessage.getParent()%></td>
            <td><%=thisThemeWallMessage.getParentMessageText()%></td>
            <td><%=thisThemeWallMessage.getStatus()%></td>
        </tr>
        <%
            }
        %>

    </table>


</section>

</body>
</html>
