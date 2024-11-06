<% User user; %>
<%@ page import="com.github.fishfly233.accountsystem.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Index</title>
</head>
<body>
    <h1>Hello
        <%=user = (User) session.getAttribute("user")%>
        <%=out.print(user != null ? user.getUsername() : "World!")%>
        !
    </h1>
    <button onclick="">Register</button>
    <button onclick="">Login</button>
</body>
</html>