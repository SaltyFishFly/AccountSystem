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
<script src="${pageContext.request.contextPath}/static/js/main.js"></script>
<body>
    <h1 class="block_element">Hello
        <%
            var user = (User) session.getAttribute("user");
            out.print(user != null ? " " + user.getUsername() : ", Please Login");
        %>
        !
    </h1>
    <form>
        <div class="block_element">
            <label for="username">Username:</label>
            <input id="username" class="md_input" type="text" name="username"/>
        </div>
        <div class="block_element">
            <label for="password">Password:</label>
            <input id="password" class="md_input" type="password" name="password"/>
        </div>
        <div>
            <button class="md_button" type="button" onclick="register()">Register</button>
            <button class="md_button" type="button" onclick="login()">Login</button>
        </div>
    </form>
</body>
</html>