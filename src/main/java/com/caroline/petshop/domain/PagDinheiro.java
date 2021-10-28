package com.caroline.petshop.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.caroline.petshop.domain.enuns.SituacaoPagamento;

@Entity
public class PagDinheiro extends Pagamento {
	
	
	private static final long serialVersionUID = 1L;
	private Date dataVencimento;
	private Double desconto;
	
	
	public PagDinheiro() {
		super();
	}
	public PagDinheiro(Integer id, SituacaoPagamento situacao, double valor,Date dataVencimento,Servico servico, Double desconto) {
		super(id, situacao, valor, servico);
		this.dataVencimento = dataVencimento;
		this.desconto = desconto;
	}
	
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	

}
