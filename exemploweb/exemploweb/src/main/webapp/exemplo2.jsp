<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Exemplo JSP 2</title>
  </head>
  <body>
    <h1>Exemplo JSP 2</h1>
    <c:forEach begin="1" end="99" varStatus="i">
      <c:if test="${i.count % 2 == 0}">
	<p><c:out value="${i.count}" /></p>
      </c:if>
    </c:forEach>
  </body>
</html>
