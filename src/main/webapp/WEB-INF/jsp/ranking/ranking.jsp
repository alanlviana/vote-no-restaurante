<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="description" content="">
<meta name="author" content="Alan Luiz Viana">
<!-- link rel="icon" href="../../favicon.ico" -->

<title>Vote no Restaurante! - Enquete</title>

<!-- Bootstrap -->
<link href="dist/css/bootstrap.min.css" rel="stylesheet">

<link
	href='http://fonts.googleapis.com/css?family=Lato&subset=latin,latin-ext'
	rel='stylesheet' type='text/css'>
<link href="css/enquete.css" rel="stylesheet">
</head>

<body>

	<div class="container">
		<div class="header clearfix">
			<div class="row">
				<div class="col-sm-12 col-md-8">
					<img class='img-responsive' src="VoteNoRestaurante.png" />
					<!--h3 class="text-muted">Vote no Restaurante</h3 -->
				</div>

			</div>
		</div>
		<div id='divGlobal'>
			<div class="row">
				<c:if test="${rankingUsuario != null}">
					<div class="col-sm-12 col-md-6">
						<h3>Seu Ranking</h3>
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th>#</th>
										<th>Restaurante</th>
										<th>Votos</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${rankingUsuario}" var="usuario">
										<tr>
											<td>${usuario.posicao}</td>
											<td>${usuario.restaurante.nome}</td>
											<td>${usuario.quantidade}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

				</c:if>
				<div class="col-sm-12 col-md-6">
					<h3>Ranking da Comunidade</h3>
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>#</th>
									<th>Restaurante</th>
									<th>Votos</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${rankingGlobal}" var="global">
									<tr>
										<td>${global.posicao}</td>
										<td>${global.restaurante.nome}</td>
										<td>${global.quantidade}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- /container -->

		<script src='js/jquery-3.0.0.min.js'></script>
		<script src='js/enquete.js'></script>
</body>
</html>
