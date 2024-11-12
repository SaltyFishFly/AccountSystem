<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css">
</head>
<body>
    <form>
        <div class="block_element">
            <h1>Login</h1>
        </div>
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
<script src="${pageContext.request.contextPath}/static/js/login.js"></script>
</html>
