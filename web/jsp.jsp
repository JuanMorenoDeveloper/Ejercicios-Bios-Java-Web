<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contactos en JSP</title>
</head>
<body>
	<h2>Total de contactos</h2>
	${totalContactos}
	<br>
	<a href="index.html">Regresar</a>
</body>
</html>
