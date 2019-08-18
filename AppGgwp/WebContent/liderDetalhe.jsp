<%@page import="java.text.SimpleDateFormat"%>
<%@page import="negocio.Lider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalhe do Lider</title>

<link rel="stylesheet" type="text/css" href="css/estilo.css">

</head>
<body>
	<%
	Lider lider = (Lider)request.getAttribute("lider");	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	%>
	
	<div>
	<form action="LiderController" method="post">
		<label>Nome</label>		
		<input type="text" name="nome" value= "<%= lider == null ? "" : lider.getNome()%>">
		
		<label>Sobrenome</label>
		<input type="text" name="sobrenome" value= "<%= lider == null ? "" : lider.getSobrenome()%>">
		
		<label>Ano de Nascimento</label>
		<input type="text" name="anoNascimento" value= "<%= lider == null ? "" : lider.getAnoNascimento()%>">
		
		<label>Estado</label>
		<input type="text" name="estado" value= "<%= lider == null ? "" : lider.getEstado()%>">
		
		<label>Cidade</label>
		<input type="text" name="cidade" value= "<%= lider == null ? "" : lider.getCidade()%>">
		
		<label>Genêro</label><br>		
		<input type="radio" name="genero" value="F" <%=lider == null ? "" : (lider.isGenero() ? "checked='checked'" : "")%>>Feminino<br> 
		<input type="radio" name="genero" value="M" <%=lider == null ? "" : (lider.isGenero() ? "" : "checked='checked'")%>>Masculinho<br>
				
		<label>E-mail</label>
		<input type="text" name="email" value= "<%= lider == null ? "" : lider.getEmail()%>">
		
		<label>Senha</label>
		<input type="password" name="senha" value= "<%= lider == null ? "" : lider.getSenha()%>">
		
		<label>Data do cadastro</label>
		<input type="text" name="DataCadastro" value="<%= lider == null ? "" : sdf.format(lider.getDataCadastro().getTime())%>">
		
		<hr>
		
		<input type="submit" value="Confirmar">
		<input type="hidden" name="id" value="">
	</form>
	</div>
</body>
</html>