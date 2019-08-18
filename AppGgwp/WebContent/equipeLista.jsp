<%@page import="java.util.List"%>
<%@page import="negocio.Equipe"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Equipe Lista</title>

<link rel="stylesheet" type="text/css" href="css/estilo.css">

</head>
<body>
	<%List<Equipe> equipes = (List<Equipe>)request.getAttribute("lista");%>
	<h3>Equipe</h3>
		
	<%if(equipes != null) {%>	
	<table border="1" id="customers">
		<tr>
			<th width="150">Criar Equipe</th>
			<th width="75">Nome da Equipe</th>
			<th width="75">Operação</th>
		</tr>
		<%for(Equipe e : equipes) {%>		
		<tr>
			<td align="center"><%=e.isCriarEquipe() ? "Sim" : "Não"%></td>
			<td align="center"><%=e.getNomeEquipe()%></td>
			<td align="center">
				<form action="EquipeController" method="get">
					<input type="hidden" name="id" value="<%=e.getId()%>">
					<input type="submit" name="operacao" value="Alterar">
				</form>
				<form action="EquipeController" method="get">
					<input type="hidden" name="id" value="<%=e.getId()%>">
					<input type="submit" name="operacao" value="Excluir">
				</form>
			</td>
		</tr>
		<%}%>
	</table>
	<%}%>
	<hr>
	<form action="EquipeController" method="get">
		<input type="submit" name="operacao" value="Incluir">	
	</form>
	<form action="AppController" method="get">
	<input type="hidden" name="tela" value="principal.jsp">
	<input type="submit" value="Voltar">
	</form>	
</body>
</html>