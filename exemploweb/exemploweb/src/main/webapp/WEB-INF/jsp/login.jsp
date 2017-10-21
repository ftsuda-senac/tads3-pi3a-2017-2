<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <div>
      <h1>Entrar no sistema</h1>
      <c:if test="${not empty msgErro}">
        <h2><c:out value="${msgErro}" /></h2>
      </c:if>
      <c:if test="${not empty msgLogout}">
        <h2><c:out value="${msgLogout}" /></h2>
      </c:if>
      <form action="${pageContext.request.contextPath}/login" method="post">
        <div>
          <label for="txtusername">Nome de usuário</label>
          <input type="text" id="txtusername" name="username" />
        </div>
        <div>
          <label for="txtsenha">Senha</label>
          <input type="password" id="txtsenha" name="senha" />
        </div>
        <div>
          <button type="submit">Enviar</button>
        </div>
      </form>

    </div>
    <h1></h1>
  </body>
</html>
