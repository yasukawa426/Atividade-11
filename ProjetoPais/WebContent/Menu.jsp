<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
 <div class="container-fluid">
  <div class="navbar-header">
   <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
    <span class="sr-only">Toggle navigation</span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
   </button>
   <button type="submit" class="btn btn-link" form="form" style="font-size : 25px;">Países</button>
  </div>
  <div id="navbar" class="navbar-collapse collapse">
   <form action="FrontController" method="post" name="form" id="form">
   <input type="hidden" class="form-control" name="command" id="command" value="ListarPaisCommand">
   </form>
   <ul class="nav navbar-nav navbar-right">
    <li><a href="Login.jsp">Login</a></li>
    <li><a href="Cadastro.jsp">Cadastrar</a></li>
    <li><a href="index.jsp">Listar Todos</a></li>
    <li><a href="View.jsp">Vizualizar/Remover</a></li>
    <li><a href="CadastroPais.jsp">Inserir</a></li>
    <li><a href="EditarPais.jsp">Editar</a></li>
   </ul>
  </div>
 </div>
</nav>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>