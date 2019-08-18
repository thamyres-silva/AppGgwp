<%@page import="negocio.Busca"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalhe da Busca</title>

<link rel="stylesheet" type="text/css" href="css/estilo.css">

</head>
<body>

	<%Busca busca = (Busca)request.getAttribute("busca");%>
	
	<div>
	<form action="BuscaController" method="post">
	
		<label>Nome</label>
		<input type="text" name="nome" value= "<%= busca == null ? "" : busca.getNome()%>">
		
		<label>Elo</label>
		<input type="text" name="elo" value= "<%= busca == null ? "" : busca.getElo()%>">
		
		<label>Cidade</label>
		<input type="text" name="cidade" value= "<%= busca == null ? "" : busca.getCidade()%>" >
		
		<label>Equipe</label>
		<input type="text" name="equipe" value= "<%= busca == null ? "" : busca.getEquipe()%>" >
		
		<hr>
		<input type="submit" value="Buscar">
	</form>
	</div>
</body>
</html>