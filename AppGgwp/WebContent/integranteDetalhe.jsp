<%@page import="java.text.SimpleDateFormat"%>
<%@page import="negocio.Integrante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalhe do Integrante</title>

<link rel="stylesheet" type="text/css" href="css/estilo.css">

</head>
<body>

	<%
	Integrante integrante = (Integrante)request.getAttribute("integrante");
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	%>
	
	<div>	
	<form action="IntegranteController" method="post">
		<label>Nome</label>
		<input type="text" name="nome" value= "<%= integrante == null ? "" : integrante.getNome()%>">
		
		<label>Sobrenome</label>
		<input type="text" name="sobrenome" value="<%= integrante == null ? "" : integrante.getSobrenome()%>">
		
		<label>Ano de Nascimento</label>
		<input type="text" name="anoNascimento" value="<%= integrante == null ? "" : integrante.getAnoNascimento()%>">
		
		<label>Estado</label>
		<input type="text" name="estado" value= "<%= integrante == null ? "" : integrante.getEstado()%>">
		
		<label>Cidade</label>
		<input type="text" name="cidade" value="<%= integrante == null ? "" : integrante.getCidade()%>">
		
		<label>Genêro</label><br>		
		<input type="radio" name="genero" value="F" <%=integrante == null ? "" : (integrante.isGenero() ? "checked='checked'" : "")%>>Feminino<br> 
		<input type="radio" name="genero" value="M" <%=integrante == null ? "" : (integrante.isGenero() ? "" : "checked='checked'")%>>Masculinho<br>
				
		<br>
				
		<label>E-mail</label>
		<input type="text" name="email" value="<%= integrante == null ? "" : integrante.getEmail()%>">
		
		<label>Senha</label><br>
		<input type="password" name="senha" value="<%= integrante == null ? "" : integrante.getSenha()%>">
		
		<label>Data do cadastro</label>
		<input type="text" name="DataCadastro" value="<%= integrante == null ? "" : sdf.format(integrante.getDataCadastro().getTime())%>">
				
		
		<hr>
		<input type="submit" value="Confirmar">
	</form>
	</div>
</body>
</html>