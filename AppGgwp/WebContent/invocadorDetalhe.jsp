<%@page import="negocio.Invocador"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalhe do Invocador</title>

<link rel="stylesheet" type="text/css" href="css/estilo.css">

</head>
<body>
	<%Invocador invocador = (Invocador)request.getAttribute("invocador");%>
	
	<div>	
	<form action="InvocadorController" method="post">
		<label>Nick</label>
		<input type="text" name="nick" value= "<%= invocador == null ? "" : invocador.getNick()%>">
		
		<label>Servidor</label>
		<input type="text" name="servidor" value= "<%= invocador == null ? "" : invocador.getServidor()%>">
		
		<label>posição Primária</label>
		<input type="text" name="posicaoPrimaria" value= "<%= invocador == null ? "" : invocador.getPosicaoPrimaria()%>">
		
		<label>posição Secundária</label>
		<input type="text" name="posicaoSecundaria" value= "<%= invocador == null ? "" : invocador.getPosicaoSecundaria()%>">
		
		<label>Elo</label>
		<input type="text" name="elo" value= "<%= invocador == null ? "" : invocador.getElo()%>">
		
		<label>Dia da Semana</label>
		<input type="text" name="diasSemana" value= "<%= invocador == null ? "" : invocador.getDiasSemana()%>">
		
		<hr>
		
		<input type="submit" value="Confirmar">
		<input type="hidden" name="id" value="">
	</form>
	</div>
</body>
</html>