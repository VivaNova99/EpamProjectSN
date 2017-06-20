
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
<head>
    <title>  </title>

</head>
<body>

<header class="reg-user">
    <%@ include file="WEB-INF/additional/header-reg-user.jsp" %>
</header>

<aside class="reg-user">
    <%@ include file="WEB-INF/additional/sidebar-reg-user.jsp" %>
</aside>

<section class="reg-user">
    <%@ include file="WEB-INF/additional/forum-this-topic.jsp" %>
</section>

<section class="reg-user forum-this-topic answer">
    <form method="POST" action="answer_forum_message">

        <textarea class="your-answer" name="forum_message_text" placeholder="Ответить в этой теме"></textarea>

        <input type="hidden" name="forum_theme_id" value="<%=request.getAttribute("forum_theme_id")%>"/>
        <input type="hidden" name="parent_message_id" value="<%=request.getAttribute("parent_message_id")%>"/>
        <input type="hidden" name="user_id" value="<%=session.getAttribute("user_id")%>"/>
        <input type="hidden" name="email" value="<%=session.getAttribute("email")%>"/>

        <input type="submit" value="Ответить"/>

        <%System.out.println("In reg-user-forum-this-topic.jsp: user_id - " + session.getAttribute("user_id") + ", " +
        "email - " + session.getAttribute("email") + ", " +
        "parent_message_id - " + request.getAttribute("parent_message_id") + ", " +
        "text - " + request.getParameter("forum_message_text"));%>
    </form>
</section>

</body>
</html>
