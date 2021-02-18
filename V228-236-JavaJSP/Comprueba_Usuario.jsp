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
	
	String usuario=request.getParameter("usuario");
	
	String contra=request.getParameter("contra");
	
	Class.forName("com.mysql.jdbc.Driver");
	
	try{
	
	Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp?&useSSL=false", "root", "BrizuelaMySQL1999");
	
	PreparedStatement c_preparada = miConexion.prepareStatement("SELECT * FROM USUARIOS WHERE USUARUIO=? AND CONTRASENA=?");
	
	c_preparada.setString(1, usuario);
	
	c_preparada.setString(2, contra);
	
	ResultSet miResultSet = c_preparada.executeQuery();
	
	if(miResultSet.absolute(1)) out.println("Usuario autorizado");
	
	else out.println("No existen usuarios con esos datos ");
	
	}catch(Exception e){
		
		e.printStackTrace();
		
	}
%>

</body>
</html>