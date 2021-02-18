<html>
<body>
<h1 style="text-align:center">Ejemplo de Declaraciones</h1>

<%!

private int resultado;

public int metodoSuma(int num1, int num2){

resultado= num1+num2;

return resultado;
}

public int metodoResta(int num1, int num2){

resultado= num1-num2;

return resultado;
}


public int metodoMultiplica(int num1, int num2){

resultado= num1*num2;

return resultado;
}

%>

El resultado de la suma es:

<%= metodoSuma(7,5) %>

<br>

El resultado de la resta es:

<%= metodoResta(7,5) %>

<br>

El resultado de la multiplicacion es:

<%= metodoMultiplica(7,5) %>

<br>



</body>
</html>