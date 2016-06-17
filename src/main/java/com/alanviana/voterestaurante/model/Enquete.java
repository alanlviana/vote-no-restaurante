package com.alanviana.voterestaurante.model;

public class Enquete  {
	
	private final Restaurante restaurante1;
	private final Restaurante restaurante2;
	
	public Enquete(Restaurante restaurante1, Restaurante restaurante2) {
		super();
		this.restaurante1 = restaurante1;
		this.restaurante2 = restaurante2;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (obj == null){
			return false;
		}
		
		if (!(obj instanceof Enquete)) {
			return false;
		}
		
		Enquete enqueteComparada = (Enquete) obj;
		
		boolean condicao1 = (this.restaurante1.equals(enqueteComparada.restaurante1)) && (this.restaurante2.equals(enqueteComparada.restaurante2));
		boolean condicao2 = (this.restaurante1.equals(enqueteComparada.restaurante2)) && (this.restaurante2.equals(enqueteComparada.restaurante1));		
		
		if (condicao1 || condicao2){
			return true;
		}
		
		return false;
	}
	
	
    
}

