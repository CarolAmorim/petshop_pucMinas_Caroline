package com.caroline.petshop.dto;

import java.io.Serializable;

import com.caroline.petshop.domain.Pessoa;

public class PessoaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String email;
	private String codNac;
	
	public PessoaDTO(Pessoa obj) {
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.codNac = obj.getCodNac();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodNac() {
		return codNac;
	}

	public void setCodNac(String codNac) {
		this.codNac = codNac;
	}
	
	

}
