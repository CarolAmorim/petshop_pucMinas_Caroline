package com.caroline.petshop.Services.Exceptions;

public class ObjetoNaoEncontradoException extends RuntimeException {


	private static final long serialVersionUID = 1L;
	
	public ObjetoNaoEncontradoException(String msg) {
		super(msg);
	}
	
	public ObjetoNaoEncontradoException(String msg, Throwable causa) {
		super(msg, causa);
	}

}
