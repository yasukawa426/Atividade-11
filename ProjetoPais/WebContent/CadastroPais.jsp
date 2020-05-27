<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Cadastro de Páis</title>
<style>
  label {
    color: silver;
</style>
</head>
<body>
<c:import url="Menu.jsp" />

<div id="main" class="container-fluid">
		<h1  style="color:silver">Cadastrar País</h1>
		<form action="FrontController" method="post">
			<div class="row">
				<div class="form-group col-md-12">
					<label for="nome">Nome: </label>
					<input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="Digite o Nome do País">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="area">Área: </label>
					<input type="text" class="form-control" name="area" id="area" required maxlength="20" placeholder="Digite a Área do País">
				</div>
				<div class="form-group col-md-6">
					<label for="populacao">População: </label>
					<input type="text" class="form-control" name="populacao" id="populacao" required maxlength="20" placeholder="Digite a  População do País">
				</div>
			</div>
			<br>
			<div id="action" class="row">
				<div class= "col-md-12">
					<input type="hidden" class="form-control" name="command" id="command" value="ManterPaisCommand">
					<button type="submit" class="btn btn-primary" name="acao" value="Criar"> 
						Cadastrar 
					</button>
				</div>
			</div>
		</form>
		<form action="FrontController" method="post">
						<input type="hidden" class="form-control" name="command" id="command" value="ListarPaisCommand">
						<button type="submit" class="btn">Cancelar</button>
					</form>
	</div>
	
		
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>