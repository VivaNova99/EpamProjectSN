<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="controllers.MyAnswersController" %>
<%@ page import="model.*" %>
<%@ page import="java.util.Collection"%>
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
        Collection<WallMessage> answersWallMessages = (Collection<WallMessage>) request.getAttribute(MyAnswersController.USER_ANSWERS_KEY);
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
            for (WallMessage answersWallMessage: answersWallMessages) {
        %>
        <tr>
            <td><%=answersWallMessage.getId()%></td>
            <td><%=answersWallMessage.getSenderUserFirstNameAndLastName()%></td>
            <td><%=answersWallMessage.getText()%></td>
            <td><%=answersWallMessage.getPicture()%></td>
            <td><%=answersWallMessage.getDateTime()%></td>
            <td><%=answersWallMessage.getForumThemeName()%></td>
            <td><%=answersWallMessage.getMessageHeader()%></td>
            <td><%=answersWallMessage.getParent()%></td>
            <td><%=answersWallMessage.getParentMessageText()%></td>
            <td><%=answersWallMessage.getStatus()%></td>
        </tr>
            <%
            }
        %>

    </table>


</section>

</body>
</html>
