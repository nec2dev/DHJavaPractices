<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import="java.sql.*" %>

<%

	String nombre=request.getParameter("nombre");

	String apellido=request.getParameter("apellido");
	
	String usuario=request.getParameter("usuario");
	
	String contra=request.getParameter("contra");
	
	String pais=request.getParameter("pais");
	
	String tecno=request.getParameter("tecnologias");
	
	Class.forName("com.mysql.jdbc.Driver");
	
	try{
	
	Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp?&useSSL=false", "root", "BrizuelaMySQL1999");
	
	Statement miStatement=miConexion.createStatement();
	
	String instruccionSql="INSERT INTO USUARIOS (Nombre, Apellido, Usuario, Contrasena, Pais, Tecnologia) VALUES ('" + nombre + "','" + apellido + "','" + usuario + "','" + contra + "','" + pais + "','" + tecno + "')";

	miStatement.executeUpdate(instruccionSql);
	
	out.println("Registrado con éxito");
	
	}catch(Exception e){
		
		e.printStackTrace();
		
	}
%>

</body>
</html>