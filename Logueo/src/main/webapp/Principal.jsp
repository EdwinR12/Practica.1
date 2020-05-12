<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Principal</title>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>

<%
HttpSession seccion =(HttpSession) request.getSession();
String variabledeseccion = (String)seccion.getAttribute("usuario");

if(variabledeseccion==null){
	response.sendRedirect("index.jsp");
}
%>
<body >
<form action="serveletUser" method="post">
<input type="submit" value="CERRAR" name="btncerrar">
</form>
<a href="historialusuarios.jsp">Ver historial de los usuarios</a>
<h1><b><i class="fas fa-clipboard">Hola Bienvenido</i></b></h1>
</body>
</html>