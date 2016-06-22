var Questionario = function (){
	this.perguntas = [];
	this.quantidade = 0;
	this.posicao = 0;
	
	this.restaurante1 = null;
	this.restaurante2 = null;
	
	this.email = '';
	this.nome = '';
		
};

function isEmail(email) {
	  var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	  return regex.test(email);
}

Questionario.prototype.enviarQuestionario = function(event){
	console.log("Finalizar pesquisa!");

	$('#alertaEmail').hide();
	$('#alertaNome').hide();
	
	this.email = $('#email').val();
	this.nome = $('#nome').val();
	var erro = false;
	if (!isEmail(this.email)){
		$('#alertaEmail').html('<strong>Atenção!</strong> Endereço de email inválido.');
		$('#alertaEmail').slideDown(500);
		erro = true;
	}
	if (this.nome == ''){
		$('#alertaNome').html('<strong>Atenção!</strong> Informe seu nome antes de continuar!');
		$('#alertaNome').slideDown(500);
		erro = true;
	}
	
	if (erro){
		return;
	}
	
	var parametros = new Object();
	
	for(i =0 ; i < this.quantidade ;i++){
		parametros['restaurantes['+i+'].id'] = this.perguntas[i].preferido;
	}
	
	parametros['nome'] = this.nome;
	parametros['email'] = this.email;
	
	$('#btnFinalizarQuestionario').attr('disabled',true);
	
	$.ajax({
		  type: "POST",
		  url: 'questionario',
		  data: $.param(parametros)
		}).done(function(){
			$('#divFormulario').slideUp(500, function(){
				$('#divAgradecimento').slideDown(500);
			});
		}).fail(function(jqXHR, status, thrownError){
			var responseText = jQuery.parseJSON(jqXHR.responseText);
			$('#erroEnvio').html(responseText.message);
			$('#erroEnvio').slideDown(500);			
			
		}).always(function(){
			$('#btnFinalizarQuestionario').attr('disabled',false) 
		});
	

};

Questionario.prototype.exibirPergunta = function(){
	
	$('#btnRestaurante1').html(this.restaurante1.nome);
	$('#btnRestaurante2').html(this.restaurante2.nome);	
	$('#imagemRestaurante1').attr('src','img/'+this.restaurante1.id+'.jpg');	
	$('#imagemRestaurante2').attr('src','img/'+this.restaurante2.id+'.jpg');	
	$('#statusQuestionario').html(' ('+(this.posicao+1)+'/'+this.quantidade+')');	
	
	
	$('#divQuestionario').slideDown(500);

};

Questionario.prototype.init = function(){
	
	// Obter informações das enquetes
	$.ajax({url: "enquete",context:this, success: function(result){
       this.perguntas = result;
	    
	   this.iniciarQuestionario();

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


Questionario.prototype.escolherRestaurante1 = function(){
	console.log("Voto para restaurante 1!");
	console.log(this);
	this.perguntas[this.posicao]['preferido'] = this.restaurante1.id;
	
	this.posicao = this.posicao +1;
	if (this.posicao  == this.quantidade ){
		this.iniciarFormulario();
		return;
	}else{
		this.restaurante1 = this.perguntas[this.posicao].restaurante1;
		this.restaurante2 = this.perguntas[this.posicao].restaurante2;			
	}
	
	this.exibirPergunta();
};
Questionario.prototype.escolherRestaurante2 = function(){
	console.log("Voto para restaurante 2!");
	console.log(this);
	this.perguntas[this.posicao]['preferido'] = this.restaurante2.id;
	
	this.posicao = this.posicao +1;
	
	if (this.posicao == this.quantidade ){
		this.iniciarFormulario();
		return;
	}else{
		this.restaurante1 = this.perguntas[this.posicao].restaurante1;
		this.restaurante2 = this.perguntas[this.posicao].restaurante2;			
	}	
	
	this.exibirPergunta();
};


Questionario.prototype.iniciarQuestionario = function(){
	this.quantidade = this.perguntas.length;
	this.posicao = 0;
	
	this.restaurante1 = this.perguntas[this.posicao].restaurante1;
	this.restaurante2 = this.perguntas[this.posicao].restaurante2;	
	
	this.exibirPergunta();
};

function trataAnimacao(elemento, event, callback){
	var col = elemento.parents('.col-xs-6');

	col.siblings().fadeOut();
	
	setTimeout(function(){

		var centro = ($('#divQuestionario').width() * 0.5) - (col.width() * 0.5);

		if (col.hasClass('pull-right')){
			col.animate({
				marginRight: centro
			});
		}
		else{
			col.animate({
				marginLeft: centro
			});
		}

		setTimeout(function(){
			col.fadeOut(400,function(){
				callback();
			});

			
			
			setTimeout(function(){
				var todasColunas = $('#divQuestionario .col-xs-6');

				todasColunas.css('margin-left','0').css('margin-right','0');

				todasColunas.fadeIn();
				
			},600)
		},600);
	},500);
	
	
}


var questionario = new Questionario();

$( document ).ready( function(){
	$('#btnRestaurante1').click(function(event){
		event.preventDefault();
		$('#btnRestaurante1').attr('disabled',true);
		trataAnimacao($(this), event,function(){
			questionario.escolherRestaurante1();
			$('#btnRestaurante1').attr('disabled',false);
		});
	});
	$('#btnRestaurante2').click(function(event){
		event.preventDefault();
		$('#btnRestaurante2').attr('disabled',true);
		trataAnimacao($(this), event,function(){
			questionario.escolherRestaurante2();
			$('#btnRestaurante2').attr('disabled',false) ;
		});
	});	
	$('#formulario').on('submit',function(event){
		event.preventDefault();
		questionario.enviarQuestionario();
	});
					
	questionario.init();
	
} );

