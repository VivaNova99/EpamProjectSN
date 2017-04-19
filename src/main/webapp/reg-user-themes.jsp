<%@ page import="controllers.MyThemesController" %>
<%@ page import="model.WallMessage" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: veraivanova
  Date: 11.04.17
  Time: 8:01
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
        Collection<WallMessage> myThemes = (Collection<WallMessage>) request.getAttribute(MyThemesController.MY_THEMES_KEY);
    %>

    <table>
        <tr>
            <th>Forum Theme</th>
            <th>Message Header</th>
            <th>Date and time</th>
            <th>Text</th>
            <th>Picture</th>
        </tr>
        <%
            for (WallMessage myTheme: myThemes) {
        %>
        <tr>
            <td><%=myTheme.getForumThemeName()%></td>
            <td><%=myTheme.getMessageHeader()%></td>
            <td><%=myTheme.getDateTime()%></td>
            <td><%=myTheme.getText()%></td>
            <td><%=myTheme.getPicture()%></td>
        </tr>
        <%
            }
        %>

    </table>

</section>

</body>
</html>
