<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tela principal</title>

<link rel="stylesheet" type="text/css" href="css/estilo.css">

</head>
<body>	
	<form action="AppController" method="get">
		<input type="hidden" name="tela" value="buscaLista.jsp">			
		<input type="submit" value="Busca">
	</form>
	
	<br>
		
	<form action="AppController" method="get">
		<input type="hidden" name="tela" value="equipeLista.jsp">		
		<input type="submit" value="Equipe">
	</form>
	
	<br>
	
	<form action="AppController" method="get">
		<input type="hidden" name="tela" value="integranteLista.jsp">		
		<input type="submit" value="Integrante">
	</form>
	
	<br>
	
	<form action="AppController" method="get">
		<input type="hidden" name="tela" value="liderLista.jsp">	
		<input type="submit" value="Lider">
	</form>
	
	<br>
	
	<form action="AppController" method="get">
		<input type="hidden" name="tela" value="invocadorLista.jsp">	
		<input type="submit" value="Invocador">
	</form>
</body>
</html>

