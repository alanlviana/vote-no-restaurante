package com.alanviana.voterestaurante.model;

import java.security.InvalidParameterException;

public class PosicaoRanking implements Comparable<PosicaoRanking> {

	private Integer posicao;
	private final Restaurante restaurante;
	private final Integer quantidade;

	public PosicaoRanking(Restaurante restaurante, Integer quantidade) {
		
		if (restaurante == null){
			throw new InvalidParameterException("Restaurante não pode ser nulo.");
		}
		
		if (quantidade == null){
			throw new InvalidParameterException("Quantidade não pode ser nula.");
		}
		
		this.restaurante = restaurante;
		this.quantidade = quantidade;

	}

	public Integer getPosicao() {
		return posicao;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public Integer getQuantidade() {
		return quantidade;
	}
	
	@Override
	public boolean equals(Object object){
		
		if (object == null){
			return false;
		}
		
		if (!(object instanceof PosicaoRanking)){
			return false;
		}
		
		PosicaoRanking referencia = (PosicaoRanking)object; 
		
		return restaurante.equals(referencia.getRestaurante());
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
		
		if (posicao <= 0) {
			throw new InvalidParameterException("Posição não pode ser menor que 1.");
		}
	}

	@Override
	public int compareTo(PosicaoRanking arg0) {
		return this.quantidade.compareTo(arg0.quantidade);
	}

	
	
}
