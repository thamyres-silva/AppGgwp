<%@page import="java.util.List"%>
<%@page import="negocio.Busca"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Busca Lista</title>

<link rel="stylesheet" type="text/css" href="css/estilo.css">

</head>
<body>	

	<%List<Busca> buscas = (List<Busca>)request.getAttribute("lista");%>		

	<h3>Buscas</h3>
		
	<%if(buscas != null) {%>	
	<table border="1" id="customers">
		<tr>
			<th width="150">Nome</th>
			<th width="75">Elo</th>
			<th width="75">Cidade</th>
			<th width="75">Equipe</th>
			<th width="75">Operação</th>
		</tr>
		<%for(Busca b : buscas) {%>		
		<tr>
			<td align="center"><%=b.getNome()%></td>
			<td align="center"><%=b.getElo()%></td>
			<td align="center"><%=b.getCidade()%></td>
			<td align="center"><%=b.getEquipe()%></td>
			<td align="center">
				<form action="BuscaController" method="get">
					<input type="hidden" name="id" value="<%=b.getId()%>">
					<input type="submit" name="operacao" value="Alterar">
				</form>
				<form action="BuscaController" method="get">
					<input type="hidden" name="id" value="<%=b.getId()%>">		
					<input type="submit" name="operacao" value="Excluir">		
				</form>
			</td>
		</tr>
		<%}%>
	</table>
	<%}%>
	<hr>	
	<form action="BuscaController" method="get">		
	<input type="submit" name="operacao" value="Incluir">	
	</form>
	<hr>
	<form action="AppController" method="get">
	<input type="hidden" name="tela" value="principal.jsp">
	<input type="submit" value="Voltar">	
	</form>	
</body>
</html>