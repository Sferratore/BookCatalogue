<html>
<body>
<%String visitor = request.getParameter("name");
if (visitor == null) visitor = "World"; %>
<h2>Hello, <%= visitor%>!</h2>
</body>
</html>
