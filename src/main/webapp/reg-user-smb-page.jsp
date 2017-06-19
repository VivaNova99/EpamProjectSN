
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
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

<section class="create-private-message">

    <%
        User someUserForPM = (User)request.getAttribute(SmbPageController.SOME_USER_INFO_KEY);
    %>

    <form method="POST" action="user-create-private-message-form.jsp">

        <input type="hidden" name="receiver_user_id" value="<%=someUserForPM.getId()%>"/>
        <input type="hidden" name="sender_user_id" value="<%=session.getAttribute("user_id")%>"/>
        <input type="hidden" name="user_id" value="<%=session.getAttribute("user_id")%>"/>
        <input type="hidden" name="email" value="<%=session.getAttribute("email")%>"/>

        <%session.setAttribute("user_id", session.getAttribute("user_id"));
        session.setAttribute("email", session.getAttribute("email"));%>

        <%--<%System.out.println("In reg-user-smb-page.jsp: receiver_user_id - " + someUserForPM.getId() + ", " +--%>
        <%--"sender_user_id - " + session.getAttribute("user_id") + ", " +--%>
        <%--"user_id - " + session.getAttribute("user_id") + ", " +--%>
        <%--"email - " + session.getAttribute("email"));%>--%>


        <input type="submit" value="Написать личное сообщение"/>

    </form>

</section>
<section class="reg-user-smb-page">
    <%@ include file="WEB-INF/additional/smb-page.jsp" %>
</section>

</body>
</html>
