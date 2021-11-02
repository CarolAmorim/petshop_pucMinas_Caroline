package com.caroline.petshop.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caroline.petshop.Services.exceptions.ObjetoNaoEncontradoException;
import com.caroline.petshop.domain.Servico;
import com.caroline.petshop.repositories.ServicoRepository;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository repo;
	
	public Servico find(Integer id) {
		Optional<Servico> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(
				"Objeto não encontrado. ID: "+ id + ", tipo: " + Servico.class.getName()));
	}

}
