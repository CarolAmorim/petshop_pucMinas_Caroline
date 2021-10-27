package com.caroline.petshop.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.caroline.petshop.domain.enuns.SituacaoPagamento;

@Entity
public class PagDinheiro extends Pagamento {
	
	
	private static final long serialVersionUID = 1L;
	private Date dataPagamento;
	private double desconto;
	
	
	public PagDinheiro() {
		super();
	}
	public PagDinheiro(int id, SituacaoPagamento situacao, double valor,Date dataPagamento,Servico servico, double desconto) {
		super(id, situacao, valor, servico);
		this.dataPagamento = dataPagamento;
		this.desconto = desconto;
	}
	
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setData(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	
	

}
