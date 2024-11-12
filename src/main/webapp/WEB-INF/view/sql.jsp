<%@ page pageEncoding="utf-8"%>
<%@ page import="com.github.fishfly233.accountsystem.datamodels.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Index</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/sql.css">
</head>
<body>
    <div class="card" style="text-align: center">
          <h1 class="block_element">
              <%
                  var user = (User) session.getAttribute("user");
                  out.print(String.format("Hello, %s!", user.getUsername()));
              %>
          </h1>
          <label class="block_element" for="sql_input">Input SQL Here</label>
          <textarea id="sql_input"></textarea>
          <div style="text-align: right">
              <button class="md_button" onclick="executeSQL()">Execute</button>
          </div>
        </div>
</body>
<script src="${pageContext.request.contextPath}/static/js/sql.js"></script>
</html>