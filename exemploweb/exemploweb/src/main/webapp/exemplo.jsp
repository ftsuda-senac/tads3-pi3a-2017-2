<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Exemplo JSP</title>
  </head>
  <body>
    <h1>Exemplo JSP</h1>
    <%
      for (int i = 1; i < 100; i++) {
	if (i % 2 == 0) {
    %>
    <p><%= i %></p>
    <%
	}
      }
     %>
  </body>
</html>
