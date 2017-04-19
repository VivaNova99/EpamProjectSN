
<%@ page contentType="text/html;charset=UTF-8" language="java"
import="controllers.MyNewsController" %>
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
        Collection<WallMessage> last10WallMessages = (Collection<WallMessage>) request.getAttribute(MyNewsController.LAST_10_WALL_MESSAGES_KEY);
    %>

    <table>
        <tr>
            <th>Sender User</th>
            <th>Date and time</th>
            <th>Forum Theme</th>
            <th>Message Header</th>
            <th>Text</th>
            <th>Picture</th>
        </tr>
        <%
            for (WallMessage last10WallMessage: last10WallMessages) {
        %>
        <tr>
            <td><%=last10WallMessage.getSenderUserFirstNameAndLastName()%></td>
            <td><%=last10WallMessage.getDateTime()%></td>
            <td><%=last10WallMessage.getForumThemeName()%></td>
            <td><%=last10WallMessage.getMessageHeader()%></td>
            <td><%=last10WallMessage.getText()%></td>
            <td><%=last10WallMessage.getPicture()%></td>
        </tr>
        <%
            }
        %>

    </table>


</section>

</body>
</html>
