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

    <style>
        <%@include file="styles/main.css" %>
        <%@include file="styles/private-messages.css" %>
    </style>

</head>
<body>

<header class="reg-user">
    <%@ include file="WEB-INF/additional/header-reg-user.jsp" %>
</header>

<aside class="reg-user">
    <%@ include file="WEB-INF/additional/sidebar-reg-user.jsp" %>
</aside>

<section class="reg-user private-messages">

    <%
        Collection<PrivateMessage> myPrivateMessages = (Collection<PrivateMessage>) request.getAttribute(MyPrivateMessageController.MY_PRIVATE_MESSAGES_KEY);
    %>

    <ul>
        <%
            for (PrivateMessage myPrivateMessage: myPrivateMessages) {
        %>
        <li>
            <ul>
                <li>
                    <ul class="receiver">
                        <li class="receiver-profile-picture">Получатель: <a href="smb-page?some_user_id=<%=myPrivateMessage.getReceiverUserId()%>">
                            <img src="users_profile_picture?user_id=<%=myPrivateMessage.getReceiverUserId()%>" /></a></li>
                        <li class="receiver-name"><a href="smb-page?some_user_id=<%=myPrivateMessage.getReceiverUserId()%>">
                            <%=myPrivateMessage.getReceiverUserFirstNameAndLastName()%></a></li>
                    </ul>
                </li>
                <li>
                    <ul class="sender">
                        <li class="sender-profile-picture">Отправитель: <a href="smb-page?some_user_id=<%=myPrivateMessage.getSenderUserId()%>">
                            <img src="users_profile_picture?user_id=<%=myPrivateMessage.getSenderUserId()%>" /></a></li>
                        <li class="sender-name"><a href="smb-page?some_user_id=<%=myPrivateMessage.getSenderUserId()%>">
                            <%=myPrivateMessage.getSenderUserFirstNameAndLastName()%></a></li>
                    </ul>
                </li>
                <li class="date-time"><%=myPrivateMessage.getDateTime()%> написал(а): </li>
                <li class="text"><%=myPrivateMessage.getText()%></li>
            </ul>
        </li>
        <%
            }
        %>

    </ul>

</section>

</body>
</html>
