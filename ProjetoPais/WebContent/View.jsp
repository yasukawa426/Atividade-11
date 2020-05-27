<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<meta charset="UTF-8">
<title>View Páis</title>
<style>
p{
color:white;
}
  strong {
    color: silver;
    font-size:16px
    
  }
  label {
    color: silver;
    text-align: right;
    clear: both;
    float:left;
    margin-right:15px;
}
#main{
  margin: 0 auto;
  width: 70%;
  border: 3px solid white;
  padding: 10px;
  text-align:center;
  
}
</style>
</head>
<body>
<c:import url="Menu.jsp" />

<!-- Modal -->
<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="modalLabel">Excluir País</h4>
      </div>
      <div class="modal-body">
        Deseja realmente excluir ${pais.nome}?
      </div>
      <div class="modal-footer">
        <button type="submit" class="btn btn-primary" form="deletar">Sim</button>
 <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
      </div>
    </div>
  </div>
</div> <!-- /.modal -->

<div id="main" >
		<h1  style="color:silver;">País: ${pais.nome}</h1>
			<div class="row" style="text-align:center; width: 90%;" >
				<form action="FrontController" method="post">
					<div class="form-group col-md-12" style="display:flex; flex-direction: row; justify-content: center; align-items: center " >
						<label for="id">Digite o id do país: </label>
						<input type="text" class="form-control" name="id" id="id" value="${pais.id}" required maxlength="3" placeholder="Digite o id do país q deseja carregar">
						<input type="hidden" class="form-control" name="command" id="command" value="ViewPaisCommand2">
						<button type="submit" class="btn btn-primary" name="carregar" value="Carregar">Carregar</button>
					</div>
				</form>
				<br>
				<div class="form-group col-md-4">
					<p><strong>Nome:  </strong> ${pais.nome} </p>
				</div>
			
				<div class="form-group col-md-4">
					<p><strong>Área:  </strong> ${pais.area} km²</p>
				</div>
				<div class="form-group col-md-4">
					<p><strong>População:  </strong> ${pais.populacao} </p>
				</div>
			</div>
			<br>
			<div id="carregar" class="row">
				<div class= "col-md-12">
					<form action="FrontController" method="post">	
						<input type="hidden" class="form-control" name="command" id="command" value="CarregarPaisCommand">
						<button type="submit" class="btn btn-primary" name="carregar" value="Carregar">Editar</button>
						<a href="#" class="btn btn-danger" data-toggle="modal" data-target="#delete-modal">Excluir</a>
						
						<input type="hidden" class="form-control" name="id" id="id" value="${pais.id}" maxlength="3" >
					</form>
					<form action="FrontController" method="post">
						<input type="hidden" class="form-control" name="command" id="command" value="ListarPaisCommand">
						<button type="submit" class="btn">Voltar</button>
					</form>
					
					
				</div>
			</div>
			<form action="FrontController" method="post" id="deletar">
				<label for="deletId">  </label>
				<input type="hidden" class="form-control" name="command" id="command" value="DeletarPaisCommand">
				<input type="hidden" class="form-control" name="deletId" id="deletId" value="${pais.id}" maxlength="3" >			
			</form>
	</div>
	
		
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>