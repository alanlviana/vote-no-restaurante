var Questionario = function (){
	this.perguntas = [];
	this.quantidade = 0;
	this.posicao = 0;
	
	this.restaurante1 = null;
	this.restaurante2 = null;
	
		
};

function isEmail(email) {
	  var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	  return regex.test(email);
}

Questionario.prototype.enviarQuestionario = function(event){
	console.log("Finalizar pesquisa!");
	event.preventDefault();

	$('#alertaEmail').hide();
	$('#alertaNome').hide();
	
	var email = $('#email').val();
	var nome = $('#nome').val();
	var erro = false;
	if (!isEmail(email)){
		$('#alertaEmail').html('<strong>Atenção!</strong> Endereço de email inválido.');
		$('#alertaEmail').slideDown(500);
		erro = true;
	}
	if (nome == ''){
		$('#alertaNome').html('<strong>Atenção!</strong> Informe seu nome antes de continuar!');
		$('#alertaNome').slideDown(500);
		erro = true;
	}
	
	if (erro){
		return;
	}
	
	//
	//for(i = 0;i < questionario.perguntas.lenght - 1;i++){

	//}
	
	var parametros = [];
	
	for(i =0 ; i < questionario.quantidade ;i++){
		parametros['restaurantes['+i+'].id']=questionario.perguntas[i].preferido;
	}
	
	parametros['nome'] = nome;
	parametros['email'] = email;
	
	
	$.ajax({
		  type: "POST",
		  url: 'questionario',
		  data: parametros
		}).done(function(){
			alert('done');
		}).fail(function(){
			alert('fail');
		}).always(function(){
			alert('always');
		});
	

};

Questionario.prototype.exibirPergunta = function(){
	
	$('#btnRestaurante1').html(questionario.restaurante1.nome);
	$('#btnRestaurante2').html(questionario.restaurante2.nome);	
	$('#imagemRestaurante1').attr('src','img/'+questionario.restaurante1.id+'.jpg');	
	$('#imagemRestaurante2').attr('src','img/'+questionario.restaurante2.id+'.jpg');	
	$('#statusQuestionario').html(' ('+(questionario.posicao+1)+'/'+questionario.quantidade+')');	
	
	
	$('#divQuestionario').slideDown(500);

};

Questionario.prototype.init = function(){
	
	// Obter informações das enquetes
	$.ajax({url: "enquete", success: function(result){
       questionario.perguntas = result;
	    
	   questionario.iniciarQuestionario();

    }});
};

Questionario.prototype.iniciarFormulario = function(){
	//
	$('#divQuestionario').slideUp(500, function(){
		$('#divFormulario').slideDown(500,function(){
			$('#email').focus();
		});
	});
	
	
	
};


Questionario.prototype.escolherRestaurante1 = function(event){
	console.log("Voto para restaurante 1!");
	event.preventDefault();
	
	questionario.perguntas[questionario.posicao]['preferido'] = questionario.restaurante1.id;
	
	questionario.posicao = questionario.posicao +1;
	if (questionario.posicao  == questionario.quantidade ){
		questionario.iniciarFormulario();
		return;
	}else{
		questionario.restaurante1 = questionario.perguntas[questionario.posicao].restaurante1;
		questionario.restaurante2 = questionario.perguntas[questionario.posicao].restaurante2;			
	}
	
	questionario.exibirPergunta();
};
Questionario.prototype.escolherRestaurante2 = function(event){
	console.log("Voto para restaurante 2!");
	event.preventDefault();
	
	questionario.perguntas[questionario.posicao]['preferido'] = questionario.restaurante2.id;
	
	questionario.posicao = questionario.posicao +1;
	
	if (questionario.posicao == questionario.quantidade ){
		questionario.iniciarFormulario();
		return;
	}else{
		questionario.restaurante1 = questionario.perguntas[questionario.posicao].restaurante1;
		questionario.restaurante2 = questionario.perguntas[questionario.posicao].restaurante2;			
	}	
	
	questionario.exibirPergunta();
};


Questionario.prototype.iniciarQuestionario = function(){
	questionario.quantidade = questionario.perguntas.length;
	questionario.posicao = 0;
	
	questionario.restaurante1 = questionario.perguntas[questionario.posicao].restaurante1;
	questionario.restaurante2 = questionario.perguntas[questionario.posicao].restaurante2;	
	
	questionario.exibirPergunta();
};


var questionario = new Questionario();

$( document ).ready( function(){
	$('#btnRestaurante1').click(questionario.escolherRestaurante1);
	$('#btnRestaurante2').click(questionario.escolherRestaurante2);	
	$('#formulario').on('submit',questionario.enviarQuestionario);
			
			
	questionario.init();
	
	
} )


