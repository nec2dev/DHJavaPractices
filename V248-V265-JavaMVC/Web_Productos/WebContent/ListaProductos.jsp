<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">

.cabecera{

	font-size:1.2em;
	font-weight:bold;
	color:white;
	background-color:blue;
	border-bottom: solid blue 2px;

}
.filas{

	text-align:center;
	background-color:cyan;
}

#contenedorBoton{

	margin-left:50px;

}

table{

	float:left;

}

</style>
</head>


<body>

<table>
<tr>

<td class="cabecera">Código artículo</td>
<td class="cabecera">Sección</td>
<td class="cabecera">Nombre Artículo</td>
<td class="cabecera">Fecha</td>
<td class="cabecera">Precio</td>
<td class="cabecera">Importado</td>
<td class="cabecera">País de origen</td>
<td class="cabecera">Accion</td>

</tr>

	<c:forEach var="TempProductos" items="${LISTAPRODUCTOS}">

	<!-- Link para cada producto con su campo clave-->
	
	<c:url var="linkTemp" value="ControladorProductos">
	
		<c:param name="instruccion" value="cargar"></c:param>
		
		<c:param name="CArticulo" value="${tempProductos.codArt}"></c:param>
		
	</c:url>
	
	<!-- Link para cada eliminar cada registro  con su campo clave-->
	
	<c:url var="linkTempEliminar" value="ControladorProductos">
	
		<c:param name="instruccion" value="eliminar"></c:param>
		
		<c:param name="CArticulo" value="${tempProductos.codArt}"></c:param>
		
	</c:url>
	
	<tr>
	
	<td class="filas">${tempProductos.codArt}</td>
	<td class="filas">${tempProductos.seccion}</td>
	<td class="filas">${tempProductos.numArt}</td>
	<td class="filas">${tempProductos.fecha}</td>
	<td class="filas">${tempProductos.precio}</td>
	<td class="filas">${tempProductos.importado}</td>
	<td class="filas">${tempProductos.paisOrigen}</td>
	<td class="filas"><a href="${linkTemp}">Actualizar</a>&nbsp;&nbsp;<a href="${linkTempEliminar}">Eliminar</a></td>

	</tr>
	
</c:forEach>

</table>

<div id="contenedorBoton">
<input type="button" value="Insertar Registro" onclick="window.location.href='inserta_producto.jsp'"/>
</div>

</body>

	
</html>