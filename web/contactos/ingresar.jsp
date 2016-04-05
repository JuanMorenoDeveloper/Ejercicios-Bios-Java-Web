<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Agenda</title>
<!-- Bootstrap core CSS -->
<link href="../webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<style type="text/css">
.form-contact {
	max-width: 330px;
	padding: 15px; 
}
.form-contact .form-contact-heading, .form-contact {
		margin-bottom: 10px; 
}
.form-contact .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}
.form-contact .form-control:focus {
	z-index: 2;
}
.form-contact input[type="email"], input[type="text"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}
</style>
<script src="../webjars/jquery/1.11.1/jquery.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<form class="form-contact" method='POST'
			action='../AddContactosController'>
			<h2 class="form-contact-heading">Ingrese un contacto</h2>
			<label for="nombre" class="sr-only">Nombre</label> <input type="text"
				id="nombre" name="nombre" class="form-control" placeholder="Nombre"
				required autofocus> <label for="email" class="sr-only">Email</label>
			<input type="email" id="email" name="email" class="form-control"
				placeholder="Email" required autofocus>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Guardar</button>
			<a href="../index.html">Regresar</a>
		</form>
	</div>
</html>
