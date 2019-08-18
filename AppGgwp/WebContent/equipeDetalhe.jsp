<%@page import="negocio.Equipe"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalhe da Equipe</title>

<link rel="stylesheet" type="text/css" href="css/estilo.css">

</head>
<body>

	<%Equipe equipe = (Equipe)request.getAttribute("equipe");%>

	<div>
	<form action="EquipeController" method="post">
		<label for="Equipe">Criar Equipe</label><br>	
		<input type="radio" name="criarEquipe" value="s" >Sim<br>
		<input type="radio" name="criarEquipe" value="n">Não<br>
		
		<br>
		
		<label for="NomeEquipe">Nome da Equipe</label>
		<input type="text" name="nomeEquipe" value= "<%= equipe == null ? "" : equipe.getNomeEquipe()%>">
		
		<hr>
		
		<input type="submit" value="Criar equipe">
	</form>
	</div>
</body>
</html>