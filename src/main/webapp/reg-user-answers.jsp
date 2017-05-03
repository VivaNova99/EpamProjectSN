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
    <%@ include file="WEB-INF/additional/header-reg-user.jsp" %>
</header>

<aside class="reg-user">
    <%@ include file="WEB-INF/additional/sidebar-reg-user.jsp" %>
</aside>

<section>

        <%
        Collection<WallMessage> answersWallMessages = (Collection<WallMessage>) request.getAttribute(MyAnswersController.USER_ANSWERS_KEY);
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
            for (WallMessage answersWallMessage: answersWallMessages) {
        %>
        <tr>
            <td><a href="smb-page?some_user_id=<%=answersWallMessage.getSenderUserId()%>">
                <img src="users_profile_picture?user_id=<%=answersWallMessage.getSenderUserId()%>" /></a></td>
            <td><a href="smb-page?some_user_id=<%=answersWallMessage.getSenderUserId()%>">
                <%=answersWallMessage.getSenderUserFirstNameAndLastName()%></a></td>
            <td><%=answersWallMessage.getSenderUserFirstNameAndLastName()%></td>
            <td><%=answersWallMessage.getDateTime()%></td>
            <td><%=answersWallMessage.getForumThemeName()%></td>
            <td><%=answersWallMessage.getMessageHeader()%></td>
            <td><%=answersWallMessage.getText()%></td>
            <td><img src="wall_message_picture?wall_message_picture_id=<%=answersWallMessage.getId()%>" /></td>
        </tr>
            <%
            }
        %>

    </table>


</section>

</body>
</html>
