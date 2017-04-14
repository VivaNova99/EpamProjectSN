
<%@ page contentType="text/html;charset=UTF-8" language="java"
import="controllers.NewsController" %>
<%@ page import="model.*" %>
<%@ page import="java.util.Collection" %>

<html>
<head>
    <title></title>
</head>
<body>

<header class="reg-user">
    <%@ include file="WEB-INF/header-reg-user.jsp" %>
</header>

<aside class="reg-user">
    <%@ include file="WEB-INF/sidebar-reg-user.jsp" %>
</aside>

<section>

    <%
        Collection<WallMessage> last10WallMessages = (Collection<WallMessage>) request.getAttribute(NewsController.LAST_10_WALL_MESSAGES_KEY);
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
            for (WallMessage last10WallMessage: last10WallMessages) {
        %>
        <tr>
            <td><%=last10WallMessage.getId()%></td>
            <td><%=last10WallMessage.getSenderUserFirstNameAndLastName()%></td>
            <td><%=last10WallMessage.getText()%></td>
            <td><%=last10WallMessage.getPicture()%></td>
            <td><%=last10WallMessage.getDateTime()%></td>
            <td><%=last10WallMessage.getForumThemeName()%></td>
            <td><%=last10WallMessage.getMessageHeader()%></td>
            <td><%=last10WallMessage.getParent()%></td>
            <td><%=last10WallMessage.getParentMessageText()%></td>
            <td><%=last10WallMessage.getStatus()%></td>
        </tr>
        <%
            }
        %>

    </table>


</section>

</body>
</html>
