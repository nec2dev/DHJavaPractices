<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Actualizar Registro</h2>
<form id="form1" name="form1" method="get" action="ControladorProductos">
  <input type="hidden" name="instruccion" value="actualizarBBDD">
  <input type="hidden" name="codArt" value="${ProductoActualizar.codArt}">
  <table width="50%" border="0">
   
    <tr>
      <td>Sección</td>
      <td><label for="seccion"></label>
      <input type="text" name="seccion" id="seccion" value="${ProductoActualizar.seccion}"></td>
    </tr>
    <tr>
      <td>Nombre Artículo</td>
      <td><label for="numArticulo"></label>
      <input type="text" name="numArticulo" id="numArticulo" value="${ProductoActualizar.numArt}"></td>
    </tr>
    <tr>
      <td>Fecha</td>
      <td><label for="fecha"></label>
      <input type="text" name="fecha" id="fecha" value="${ProductoActualizar.precio}"></td>
    </tr>
    <tr>
      <td>Precio</td>
      <td><label for="precio"></label>
      <input type="text" name="precio" id="precio" value="${ProductoActualizar.fecha}"></td>
    </tr>
    <tr>
      <td>Importado</td>
      <td><label for="importado"></label>
      <input type="text" name="importado" id="importado" value="${ProductoActualizar.importado}"></td>
    </tr>
    <tr>
      <td>país de Origen</td>
      <td><label for="paisOrigen"></label>
      <input type="text" name="paisOrigen" id="paisOrigen" value="${ProductoActualizar.paisOrigen}"></td>
    </tr>
    <tr>
      <td><input type="submit" name="enviar" id="enviar" value="Enviar" /></td>
      <td><input type="submit" name="restablecer" id="reestablecer" value="Reestablecer" /></td>
    </tr>
  </table>
</form>

</body>
</html>