package com.caroline.petshop.domain.enuns;

public enum SituacaoPagamento {
	
	QUITADO(1,"Quitado"),
	CANCELADO(2,"Cancelado"),
	PENDENTE(3,"Pendente");
	
	private Integer cod;
	private String descricao;
	
	public int getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	private SituacaoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public static SituacaoPagamento toEnum(Integer cod) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
