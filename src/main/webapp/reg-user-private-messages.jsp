<%@ page import="controllers.MyPrivateMessageController" %>
<%@ page import="model.PrivateMessage" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: veraivanova
  Date: 08.04.17
  Time: 7:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<section class="reg-user">

    <%
        Collection<PrivateMessage> myPrivateMessages = (Collection<PrivateMessage>) request.getAttribute(MyPrivateMessageController.MY_PRIVATE_MESSAGES_KEY);
    %>

    <table>
        <tr>
            <th>Sender User</th>
            <th>Receiver User</th>
            <th>Date and time</th>
            <th>Text</th>
        </tr>
        <%
            for (PrivateMessage myPrivateMessage: myPrivateMessages) {
        %>
        <tr>
            <td><%=myPrivateMessage.getSenderUserFirstNameAndLastName()%></td>
            <td><%=myPrivateMessage.getReceiverUserFirstNameAndLastName()%></td>
            <td><%=myPrivateMessage.getDateTime()%></td>
            <td><%=myPrivateMessage.getText()%></td>
        </tr>
        <%
            }
        %>

    </table>

</section>

</body>
</html>
