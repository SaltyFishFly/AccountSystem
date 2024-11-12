<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css">
</head>
<body>
    <div class="card">
        <div class="block_element">
            <h1 style="font-size: 24px">Log In</h1>
        </div>
        <div class="md_input">
            <input id="username" type="text" name="username"/>
            <label for="username">Username</label>
        </div>
        <div class="md_input">
            <input id="password" type="password" name="password"/>
            <label for="password">Password</label>
        </div>
        <div style="text-align: right">
            <button class="md_button" type="button" onclick="register()">Register</button>
            <button class="md_button" type="button" onclick="login()">Log In</button>
        </div>
    </div>
</body>
<script src="${pageContext.request.contextPath}/static/js/login.js"></script>
</html>
