<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<style>
hr{
margin-left: 70px;
margin-right: 70px;
}
</style>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Países Cadastrados</title>
</head>
<body>
<c:import url="Menu.jsp" />
<div id="main" class="container-fluid">

<h1>Países Cadastrados</h1>

<!--<hr>  -->
	<div id="wrapper" style="text-align: center;">	
<!-- 		<a href="CadastroPais.jsp" class="btn btn-primary" style="position: center; top: 50%"> Cadastrar novo país </a> Criando um link -->	</div>
	<br>
	<table id="paises" class="center"> <!-- Fazendo uma tabela  -->
	 	<thead Style="color:black; background:white;" > <!-- cabeçalho -->
	 		<tr><!--  nomes do cabeçalho -->
	 			<th>#</th>
	 			<th>Nome</th>
	 			<th>Área</th>
	 			<th>População</th>
	 		</tr>
	 	</thead>
	 	<tbody><!--  corpo da tabela -->
	 		<c:forEach var="pais" items="${paises}"> 
		 		<tr> <!-- Cada Linha -->
		 			<td> ${pais.id} </td>
		 			<td> ${pais.nome} </td> <!-- Tem 3 linhas -->
		 			<td> ${pais.area} </td> <!-- Tem 3 linhas -->
		 			<td> ${pais.populacao} </td> <!-- Tem 3 linhas -->
		 		</tr> <!-- Cada Linha -->
	 		</c:forEach>
	 	</tbody>	
	</table>
	

</div>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>