<%@ page pageEncoding="utf-8"%>
<%@ page import="com.github.fishfly233.accountsystem.datamodels.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Index</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/index.css">
</head>
<body>
    <h1 class="block_element">Hello
        <%
            var user = (User) session.getAttribute("user");
            out.print(user != null ? " " + user.getUsername() : ", Please Login");
        %>
        !
    </h1>
</body>
</html>