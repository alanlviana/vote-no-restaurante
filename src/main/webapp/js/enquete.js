var Questionario = function (){
	this.perguntas = [];
	this.quantidade = 0;
	this.posicao = 0;
	
		
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
	
	
	
	if (!isEmail(email)){
		$('#alertaEmail').html('<strong>Atenção!</strong> Endereço de email inválido.');
		$('#alertaEmail').slideDown(500);
	}
	
	if (nome == ''){
		$('#alertaNome').html('<strong>Atenção!</strong> Informe seu nome antes de continuar!');
		$('#alertaNome').slideDown(500);
	}

};

Questionario.prototype.exibirPergunta = function(){
	
	$('#btnRestaurante1').html(questionario.perguntas[questionario.posicao].restaurante1.nome);
	$('#btnRestaurante2').html(questionario.perguntas[questionario.posicao].restaurante2.nome);	
	$('#imagemRestaurante1').attr('src','img/'+questionario.perguntas[questionario.posicao].restaurante1.id+'.jpg');	
	$('#imagemRestaurante2').attr('src','img/'+questionario.perguntas[questionario.posicao].restaurante2.id+'.jpg');	
	$('#statusQuestionario').html(' ('+(questionario.posicao+1)+'/'+questionario.quantidade+')');	
	
	
	$('#divQuestionario').slideDown(500);

};

Questionario.prototype.init = function(){
	
	// Obter informações das enquetes
	$.ajax({url: "enquete", success: function(result){
       questionario.perguntas = result;
	    
	   questionario.iniciarQuestionario();

	    // Realizar preloading das imagens
		$('<img/>')[0].src = 'img/3.jpg';
		$('<img/>')[0].src = 'img/4.jpg';
		$('<img/>')[0].src = 'img/5.jpg';
		   
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
	questionario.posicao = questionario.posicao +1;
	
	if (questionario.posicao  == questionario.quantidade ){
		questionario.iniciarFormulario();
		return;
	}
	
	questionario.exibirPergunta();
};
Questionario.prototype.escolherRestaurante2 = function(event){
	console.log("Voto para restaurante 2!");
	event.preventDefault();
	questionario.posicao = questionario.posicao +1;
	
	if (questionario.posicao == questionario.quantidade ){
		questionario.iniciarFormulario();
		return;
	}	
	
	questionario.exibirPergunta();
};


Questionario.prototype.iniciarQuestionario = function(){
	questionario.quantidade = questionario.perguntas.length;
	questionario.exibirPergunta();
};


var questionario = new Questionario();

$( document ).ready( function(){
	$('#btnRestaurante1').click(questionario.escolherRestaurante1);
	$('#btnRestaurante2').click(questionario.escolherRestaurante2);	
	$('#formulario').on('submit',questionario.enviarQuestionario);
			
			
	questionario.init();
	
	
} )


