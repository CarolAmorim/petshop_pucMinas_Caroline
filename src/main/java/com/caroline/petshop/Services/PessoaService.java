package com.caroline.petshop.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caroline.petshop.Services.exceptions.ObjetoNaoEncontradoException;
import com.caroline.petshop.domain.Pessoa;
import com.caroline.petshop.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;
	
	public Pessoa find(Integer id) {
		Optional<Pessoa> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(
				"Objeto não encontrado. ID: "+ id + ", tipo: " + Pessoa.class.getName()));
	}

}
