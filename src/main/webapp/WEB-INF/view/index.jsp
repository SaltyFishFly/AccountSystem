<%@ page import="com.github.fishfly233.accountsystem.datamodels.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Index</title>
</head>
<script src="${pageContext.request.contextPath}/static/js/main.js"></script>
<body>
    <h1>Hello
        <%
            var user = (User) session.getAttribute("user");
            out.print(user != null ? " " + user.getUsername() : ", Please Login");
        %>
        !
    </h1>
    <form>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required />
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required />
        <br>
        <button type="button" onclick="register()">Register</button>
        <button type="button" onclick="login()">Login</button>
    </form>
</body>
</html>