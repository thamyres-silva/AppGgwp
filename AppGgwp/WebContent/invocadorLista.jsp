<%@page import="java.util.List"%>
<%@page import="negocio.Invocador"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invocador Lista</title>

<link rel="stylesheet" type="text/css" href="css/estilo.css">

</head>
<body>

	<%List<Invocador> invocadores = (List<Invocador>)request.getAttribute("lista");%>
	
	<h3>Invocador</h3>
		
	<%if(invocadores != null) {%>	
	<table border="1" id="customers">
		<tr>
			<th width="150">Nick</th>
			<th width="75">Servidor</th>
			<th width="75">Posição Primária</th>
			<th width="75">Posição Secundária</th>
			<th width="75">Elo</th>
			<th width="75">Dia da Semana</th>
			<th width="75">Operação</th>
			
		</tr>
		<%for(Invocador i : invocadores) {%>		
		<tr>
			<td align="center"><%=i.getNick()%></td>
			<td align="center"><%=i.getServidor()%></td>
			<td align="center"><%=i.getPosicaoPrimaria()%></td>
			<td align="center"><%=i.getPosicaoSecundaria()%></td>
			<td align="center"><%=i.getElo()%></td>
			<td align="center"><%=i.getDiasSemana()%></td>
			<td align="center">
				<form action="InvocadorController" method="get">
					<input type="hidden" name="id" value="<%=i.getId()%>">
					<input type="submit" name="operacao" value="Alterar">					
				</form>
				<form action="InvocadorController" method="get">
					<input type="hidden" name="id" value="<%=i.getId()%>">
					<input type="submit" name="operacao" value="Excluir">					
				</form>
			</td>
		</tr>
		<%}%>
	</table>
	<%}%>
	<hr>
	<form action="InvocadorController" method="get">
		<input type="submit" name="operacao" value="Incluir">	
	</form>
	<form action="AppController" method="get">
	<input type="hidden" name="tela" value="principal.jsp">
	<input type="submit" value="Voltar">
	</form>	
</body>
</html>