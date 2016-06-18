<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<div id='divQuestionario'>
			<div class="row">
				<div class="col-sm-6 col-md-4">
					<h3>
						Você prefere?<small id='statusQuestionario'> (1/10)</small>
					</h3>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-6 col-sm-6 col-md-6">
					<div class="thumbnail thumbnail-sem-borda">
						<img id="imagemRestaurante1" src="" width=400 height=400
							alt="Outback Logo">
						<div class="caption-votar">
							<p>
								<a href='#' id='btnRestaurante1'
									class="btn btn-success btn-block" role="button"></a>
							</p>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-6">
					<div class="thumbnail thumbnail-sem-borda">
						<img id="imagemRestaurante2" src="" width=400 height=400
							alt="The Fifties Logo">
						<div class="caption-votar">
							<p>
								<a href='#' id='btnRestaurante2'
									class="btn btn-success btn-block" role="button"></a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id='divFormulario'>
			<div class="row">
				<div class="col-sm-12 col-md-12">
					<h4>Informe seus dados de contato para finalizar a pesquisa:</h4>
				</div>
				<div class="col-sm-12 col-md-12">
					<form role="form">
						<div class="form-group">
							<label for="email">Email:</label> <input type="email"
								class="form-control" id="email">
						</div>
						<div id="alertaEmail" class="alert alert-warning">
							<strong>Atenção!</strong> Informe seu endereço de email antes de continuar!
						</div>
						<div class="form-group">
							<label for="nome">Nome:</label> <input type="text"
								class="form-control" id="nome">
						</div>
						<div id="alertaNome" class="alert alert-warning">
							<strong>Atenção!</strong> Informe seu nome antes de continuar!
						</div>

					</form>
				</div>

			</div>

			<div class="row">
				<div class="col-sm-12 col-md-12">
					<p>
						<a id="btnFinalizarPesquisa" href="#" class="btn btn-success btn-block" role="button">
							Finalizar Pesquisa
						</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<!-- /container -->

	<script src='js/jquery.mobile-1.4.5.js'></script>
	<script src='js/enquete.js'></script>

</body>
</html>
