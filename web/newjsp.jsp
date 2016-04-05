<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <h2>Lista de contactos</h2>
        <!--TODO: Validar mensaje para mostrar si la lista viene vacia -->
        <c:choose>
            <c:when test="${true}">
                <i>La colección viene vacia</i>
            </c:when>
            <c:otherwise>
                <table>
                    <!--TODO: Listar contenido de la lista usando foreach-->
                </table>
            </c:otherwise>
        </c:choose>
    </body>
</html>
