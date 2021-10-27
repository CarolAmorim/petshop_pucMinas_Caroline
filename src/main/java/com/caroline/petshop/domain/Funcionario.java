package com.caroline.petshop.domain;

import javax.persistence.Entity;

@Entity
public class Funcionario extends Pessoa {
	
	private static final long serialVersionUID = 1L;
	private String funcao;

	public Funcionario() {
		super();
	}

	public Funcionario(Integer id, String nome, String email, String codNac, String funcao) {
		super(id, nome, email, codNac);
		this.funcao = funcao;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	

}
