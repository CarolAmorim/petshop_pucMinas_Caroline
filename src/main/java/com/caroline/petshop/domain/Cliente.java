package com.caroline.petshop.domain;

import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa {
	
	private static final long serialVersionUID = 1L;
	private String tipo;

	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nome, String email, String codNac, String tipo) {
		super(id, nome, email, codNac);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
