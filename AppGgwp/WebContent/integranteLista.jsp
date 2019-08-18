<%@page import="java.text.SimpleDateFormat"%>
<%@page import="auxiliar.Constante"%>
<%@page import="java.util.List"%>
<%@page import="negocio.Integrante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Integrante Lista</title>

<link rel="stylesheet" type="text/css" href="css/estilo.css">

</head>
<body>

	<%
	List<Integrante> integrantes = (List<Integrante>)request.getAttribute("lista");
 	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	%>
	
	<h3>Integrante</h3>
		
	<%if(integrantes != null) {%>	
	<table border="1" id="customers">
		<tr>
			<th width="150">Nome</th>
			<th width="150">Sobrenome</th>
			<th width="75">Ano de Nascimento</th>
			<th width="75">Estado</th>
			<th width="150">Cidade</th>
			<th width="75">Genero</th>
			<th width="150">Email</th>
			<th width="75">Senha</th>
			<th width="75">Data do Cadastro</th>
			<th width="75">Operação</th>
		</tr>
		<%for(Integrante i : integrantes) {%>		
		<tr>
			<td align="center"><%=i.getNome()%></td>
			<td align="center"><%=i.getSobrenome()%></td>
			<td align="center"><%=i.getAnoNascimento()%></td>
			<td align="center"><%=i.getEstado()%></td>
			<td align="center"><%=i.getCidade()%></td>
			<td align="center"><%=i.isGenero() ? "Feminino" : "Masculino"%></td>
			<td align="center"><%=i.getEmail()%></td>
			<td align="center"><%=i.getSenha()%></td>
			<td align="center"><%=sdf.format(i.getDataCadastro().getTime())%></td>
			<td align="center">
				<form action="IntegranteController" method="get">
					<input type="hidden" name="id" value="<%=i.getId()%>">
					<input type="submit" name="operacao" value="Alterar">
				</form>
				<form action="IntegranteController" method="get">
					<input type="hidden" name="id" value="<%=i.getId()%>">
					<input type="submit" name="operacao" value="Excluir">
				</form>
			</td>
		</tr>
		<%}%>
	</table>
	<%}%>
	<hr>
	<form action="IntegranteController" method="get">
		<input type="submit" name="operacao" value="Incluir">	
	</form>	
	<form action="AppController" method="get">
	<input type="hidden" name="tela" value="principal.jsp">
	<input type="submit" value="Voltar">
	</form>	
</body>
</html>