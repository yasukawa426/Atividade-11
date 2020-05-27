<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cadastrar</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<style>
  label {
    color: silver;
    text-align: right;
    clear: both;
    float:left;
    margin-right:15px;
}
</style>
</head>

<body>

	<c:import url="Menu.jsp" />

	<div id="main" class="container">
		<h1 class="page-header">Realize seu cadastro!</h1>
		<form action="FrontController" method="post">
			<!-- area de campos do form -->
			<div class="row">
				<div class="form-group col-md-6">
					<label for="email">E-mail</label> <input type="email"
						class="form-control" name="email" id="email" placeholder="E-mail"
						required>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="senha">Senha</label> <input type="password"
						class="form-control" name="senha" id="senha"
						placeholder="Insera sua senha"
						required>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="nome">Nome</label> <input type="text"
						class="form-control" name="nome" id="nome" placeholder="Nome"
						required>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="fone">Fone</label> <input type="text"
						class="form-control" name="fone" id="fone"
						placeholder="Telefone"
						required>
				</div>
			</div>
			<hr>
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="command" onclick="Cadastrado()"
						value="CriarUsuario">Cadastrar!</button>
				</div>
			</div>
		</form>
	</div>
	<script>
	function Cadastrado(){
		alert("Cadastrado com sucesso!");
	}	
	</script>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>