package com.alanviana.voterestaurante.model;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeradorRanking {
	
	List<PosicaoRanking> contagemVotos;
	
	public GeradorRanking(){
		contagemVotos = new ArrayList<>();		
	}

	public void adicionarRestaurante(Restaurante restaurante, Integer quantidadeVotos) {
		if (restaurante == null) {
			throw new InvalidParameterException("Não é possivel adicionar um restaurante Nulo ao Ranking.");
		}
		if (quantidadeVotos == null) {
			throw new InvalidParameterException("Não é possivel adicionar um restaurante com votos nulos ao Ranking.");
		}
		
		PosicaoRanking posicaoRanking = new PosicaoRanking(restaurante, quantidadeVotos);
		
		if (contagemVotos.contains(posicaoRanking)) {
			throw new InvalidParameterException("Não é possivel adicionar um restaurante duas vezes ao Ranking.");
		}
		
		contagemVotos.add(posicaoRanking);
	}

	public List<PosicaoRanking> gerarListaPosicoes() {
		if (contagemVotos.isEmpty()){
			throw new IllegalStateException("Não há itens para gerar o ranking.");
		}
		
		List<PosicaoRanking> copia = new ArrayList<>(contagemVotos);
		Collections.sort(copia);
		Collections.reverse(copia);
		
		Integer ultimaQuantidade = -1;
		Integer ultimaPosicao = 0;
		for (int i = 0; i <= copia.size() - 1; i++){
			
			PosicaoRanking posicao = copia.get(i);
			if (! ultimaQuantidade.equals(posicao.getQuantidade())){
				ultimaPosicao = i+1;
			}
			
			copia.get(i).setPosicao(ultimaPosicao);
			ultimaQuantidade = posicao.getQuantidade();			
		}
		
		
		
		return copia;
	}
	
	
	
	
	
}
