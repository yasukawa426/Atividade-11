<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Editar Páis</title>
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

<div id="main" class="container-fluid" >
		<h1  style="color:silver">Editar País</h1> <br>
		<div class="container" style=" text-align:left" >
			<form action="FrontController" method="post">
					<div class="form-group col-md-5" style="display:flex; flex-direction: row; justify-content: center; align-items: center" > 
						<label for="id">Digite o id do país: </label>
						<input type="text" class="form-control" name="id" id="id" value="${pais.id}" required maxlength="3" placeholder="Digite o id do país q deseja carregar">
						<input type="hidden" class="form-control" name="command" id="command" value="CarregarPaisCommand">
						<button type="submit" class="btn btn-primary" name="carregar" value="Carregar">Carregar</button>
						
					</div>
					<div class="form-group col-md-1" > 
					</div>
					<div class="form-group col-md-1" > 
					</div>
			</form>
		</div>
		
		<form action="FrontController" method="post">
			<div class="row">
				<div class="form-group col-md-6">
						<label for="id">Id: </label>
						<input type="text" class="form-control" value="${pais.id}" name="id" id="id" required maxlength="3" readonly>
				</div>
				<div class="form-group col-md-6">
					<label for="nome">Nome: </label>
					<input type="text" class="form-control" value="${pais.nome}" name="nome" id="nome" required maxlength="100" placeholder="Digite o Nome do País">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="area">Área: </label>
					<input type="text" class="form-control" name="area" id="area" value="${pais.area}" required maxlength="20" placeholder="Digite a Área do País">
				</div>
				<div class="form-group col-md-6">
					<label for="populacao">População: </label>
					<input type="text" class="form-control" name="populacao" id="populacao" value="${pais.populacao}" required maxlength="20" placeholder="Digite a  População do País">
				</div>
			</div>
			<br>
			<div id="action" class="row">
				<div class= "col-md-12">
					<input type="hidden" class="form-control" name="command" id="command" value="EditarPaisCommand">
					<button type="submit" class="btn btn-primary" name="acao" value="Criar" onclick="Atualizado()"> 
						Editar 
					</button>
				</div>
			</div>
			
		</form>
		<form action="FrontController" method="post">
						<input type="hidden" class="form-control" name="command" id="command" value="ListarPaisCommand">
						<button type="submit" class="btn">Voltar</button>
					</form>
	</div>
	
		
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script>
	function Atualizado(){
		alert("País Atualizado!");
	}
	</script>
</body>
</html>