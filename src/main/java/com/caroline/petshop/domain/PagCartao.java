package com.caroline.petshop.domain;

import javax.persistence.Entity;

import com.caroline.petshop.domain.enuns.SituacaoPagamento;

@Entity
public class PagCartao extends Pagamento {

	private static final long serialVersionUID = 1L;
	private Integer parcelas;	

	public PagCartao() {
		super();
	}

	public PagCartao(int id, SituacaoPagamento situacao, double valor,Servico servico, Integer parcelas) {
		super(id, situacao, valor, servico);
		this.parcelas = parcelas;
	}


	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}
	
	
}
