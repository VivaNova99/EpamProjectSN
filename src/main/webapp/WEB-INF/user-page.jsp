<%@ page import="controllers.UserOwnPageController" %>
<%@ page import="model.User" %>
<%@ page import="java.util.Collection" %>
<%@ page import="model.WallMessage" %>
<%@ page import="model.Photo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<%
    User user = (User) request.getAttribute(UserOwnPageController.USER_INFO_KEY);
%>

<table>

    <tr>
        <td><%=user.getFirstName()%></td>
        <td><%=user.getLastName()%></td>
        <td><%=user.getDateOfBirth()%></td>
        <td><%=user.getProfilePhoto()%></td>
        <td><%=user.getStatusOnWall()%></td>
        <td><%=user.getCity()%></td>
    </tr>

</table>


<%
    Collection<WallMessage> last10ForUserWallMessages = (Collection<WallMessage>) request.getAttribute(UserOwnPageController.LAST_10_FOR_USER_WALL_MESSAGES_KEY);
%>

<table>
    <%
        for (WallMessage last10ForUserWallMessage: last10ForUserWallMessages) {
    %>
    <tr>
        <td><%=last10ForUserWallMessage.getDateTime()%></td>
        <td><%=last10ForUserWallMessage.getMessageHeader()%></td>
        <td><%=last10ForUserWallMessage.getText()%></td>
        <td><%=last10ForUserWallMessage.getPicture()%></td>
    </tr>
    <%
        }
    %>
</table>


<%
    Collection<Photo> last5ForUserPhotos = (Collection<Photo>) request.getAttribute(UserOwnPageController.LAST_5_FOR_USER_PHOTOS_KEY);
%>

<table>
    <%
        for (Photo last5ForUserPhoto: last5ForUserPhotos) {
    %>
    <tr>
        <td><%=last5ForUserPhoto.getPicture()%></td>
    </tr>
    <%
        }
    %>

</table>


</body>
</html>
