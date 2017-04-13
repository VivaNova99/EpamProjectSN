
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
            for (WallMessage wallMessage: last10WallMessages) {
        %>
        <tr>
            <td><%=wallMessage.getId()%></td>
            <td><%=wallMessage.getSenderUserFirstNameAndLastName()%></td>
            <td><%=wallMessage.getText()%></td>
            <td><%=wallMessage.getPicture()%></td>
            <td><%=wallMessage.getDateTime()%></td>
            <td><%=wallMessage.getForumThemeName()%></td>
            <td><%=wallMessage.getMessageHeader()%></td>
            <td><%=wallMessage.getParent()%></td>
            <td><%=wallMessage.getParentMessageText()%></td>
            <td><%=wallMessage.getStatus()%></td>
        </tr>
        <%
            }
        %>

    </table>


</section>

</body>
</html>
