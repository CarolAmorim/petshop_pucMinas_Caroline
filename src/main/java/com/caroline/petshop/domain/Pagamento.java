package com.caroline.petshop.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.caroline.petshop.domain.enuns.SituacaoPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	private double valor;	
	private Integer situacao;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "id_servico")
	@MapsId
	private Servico servico;
	
	public Pagamento() {}
	
	public Pagamento(Integer id, SituacaoPagamento situacao, double valor,Servico servico) {
		super();
		this.id = id;
		this.situacao = situacao.getCod();
		this.valor = valor;
		this.setServico(servico);
	}
	
	public static SituacaoPagamento toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		for (SituacaoPagamento sp : SituacaoPagamento.values()) {
			if (cod.equals(sp.getCod())) {
				return sp;
			}				
		}
		
		throw new IllegalArgumentException();		
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (id != other.id)
			return false;
		return true;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SituacaoPagamento getSituacao() {
		return SituacaoPagamento.toEnum(situacao);
	}
	public void setSituacao(SituacaoPagamento situacao) {
		this.situacao = situacao.getCod();
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	

}
