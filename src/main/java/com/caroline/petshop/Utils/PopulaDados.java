package com.caroline.petshop.Utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.caroline.petshop.domain.Categoria;
import com.caroline.petshop.domain.Produto;
import com.caroline.petshop.repositories.CategoriaRepository;
import com.caroline.petshop.repositories.ProdutoRepository;

@Component
public class PopulaDados {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@PostConstruct
	public void cadastrar() {
		Categoria cat1 = new Categoria(null,"Alimento");
		Categoria cat2 = new Categoria(null,"Remédio");
		Categoria cat3 = new Categoria(null,"Cosmético");
		
		
		Produto prod1 = new Produto(null,"Ração",100);
		Produto prod2 = new Produto(null,"Sachê",80);
		Produto prod3 = new Produto(null,"Shampoo",50);
		Produto prod4 = new Produto(null,"Vermífugo",20);
		
		cat1.getProdutos().addAll(Arrays.asList(prod1,prod2));
		cat2.getProdutos().addAll(Arrays.asList(prod3,prod4));
		cat3.getProdutos().addAll(Arrays.asList(prod3));
		
		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1));
		prod3.getCategorias().addAll(Arrays.asList(cat2,cat3));
		prod4.getCategorias().addAll(Arrays.asList(cat2));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));	
		produtoRepository.saveAll(Arrays.asList(prod1,prod2,prod3,prod4));
	}

}
