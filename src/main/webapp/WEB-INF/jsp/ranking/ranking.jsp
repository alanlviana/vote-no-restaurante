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


<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<!--script src="../../assets/js/ie-emulation-modes-warning.js"></script -->

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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
				<c:if test="${rakingGlobal != null}">
					<div class="col-sm-12 col-md-6">
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
									<c:forEach items="${rakingGlobal}" var="posicao">
										<tr>
											<td>${posicao.posicao}</td>
											<td>${posicao.restaurante.nome}</td>
											<td>${posicao.quantidade}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

				</c:if>


			</div>
		</div>
		<!-- /container -->

		<script src='js/jquery-3.0.0.min.js'></script>
		<script src='js/enquete.js'></script>
</body>
</html>
