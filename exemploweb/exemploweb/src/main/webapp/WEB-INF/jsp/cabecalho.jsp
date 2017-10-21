<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header style="background-color: pink">
  <h2>Usuario logado: <c:out value="${sessionScope.usuario.nomeCompleto}" /></h2>
  <p><c:out value="${sessionScope.usuario.hashSenha}" /></p>
  <p><a href="${pageContext.request.contextPath}/logout">Sair</a></p>
</header>
