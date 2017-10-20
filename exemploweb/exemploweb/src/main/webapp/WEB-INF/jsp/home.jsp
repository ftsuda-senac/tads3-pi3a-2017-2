<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <header>
      <h2>Usuario logado: <c:out value="${sessionScope.usuario.nomeCompleto}" /></h2>
    </header>
    <h1>Home page</h1>

  </body>
</html>
