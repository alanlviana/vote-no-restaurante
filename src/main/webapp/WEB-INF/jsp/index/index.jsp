<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="description" content="Queremos saber qual a melhor comida do mundo! Responda a enquete!">
<meta name="author" content="Alan Luiz Viana">

<title>Vote no Prato! - Enquete</title>

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
				<div class="col-sm-12">
					<h1 class="text-muted">Vote no Prato!</h1>
					<div class="box-separador">
						<hr/>
						<span></span>
					</div>					
				</div>
			</div>
		</div>
		<div id='divQuestionario'>

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
				<div class="col-xs-6 col-sm-6 col-md-6 pull-right">
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
					<form role="form" id="formulario">
						<div class="form-group">
							<label for="email">Email:</label> <input type="email"
								class="form-control" id="email">
						</div>
						<div id="alertaEmail" class="alert alert-warning">
							<strong>Atenção!</strong> Informe seu endereço de email antes de
							continuar!
						</div>
						<div class="form-group">
							<label for="nome">Nome:</label> <input type="text"
								class="form-control" id="nome">
						</div>
						<div id="alertaNome" class="alert alert-warning">
							<strong>Atenção!</strong> Informe seu nome antes de continuar!
						</div>

						<div id="erroEnvio" class="alert alert-error"></div>

						<div class="form-group">
							<input id="btnFinalizarQuestionario"
								value="Finalizar Questionário" type="submit"
								class="btn btn-success btn-block" class="form-control">
						</div>

					</form>
				</div>

			</div>

		</div>
		<div id='divAgradecimento'>
			<div class="row">
				<div class="col-sm-12 col-md-12">
					<h2>Muito obrigado pela sua contribuição!</h2>
				</div>
				<div class="col-sm-12 col-md-12">
					<a href='ranking' id='btnRanking'
									class="btn btn-success btn-block" role="button">Exibir Ranking</a>
				</div>				
			</div>
		</div>
		<!-- /container -->

		<script src='js/jquery-3.0.0.min.js'></script>
		<script src='js/enquete.js'></script>
</body>
</html>
