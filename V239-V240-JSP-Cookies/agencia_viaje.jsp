<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

h1{

text-align:center;

}

</style>
</head>
<body>

<h1>Agencia de Viajes</h1>

<%

	//Valor por defecto
	String ciudad_favorita="Madrid";

	//Lee la cookie de la petición del navegador
	Cookie[] lasCookies = request.getCookies();
	
	//Buscar las preferencias. la ciudad favorita
	if(lasCookies!=null){
		
		for(Cookie cookie_temporal: lasCookies){
			
			if("agencia_viajes.ciudad_favorita".equals(cookie_temporal.getName())){
				
				ciudad_favorita = cookie_temporal.getValue();
				
				break;
				
			}
			
		}
		
		
	}



%>

<h3>Vuelos a <%= ciudad_favorita %></h3>

<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>

<h3>Hoteles en <%= ciudad_favorita %></h3>

<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>

<h3>Descuentos en restaurantes en <%= ciudad_favorita %></h3>

<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>

</body>
</html>