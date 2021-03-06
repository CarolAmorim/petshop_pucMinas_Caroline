package com.caroline.petshop.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

//import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.caroline.petshop.domain.Categoria;
import com.caroline.petshop.domain.Cidade;
import com.caroline.petshop.domain.Cliente;
import com.caroline.petshop.domain.Endereco;
import com.caroline.petshop.domain.Especie;
import com.caroline.petshop.domain.Estado;
import com.caroline.petshop.domain.Funcionario;
import com.caroline.petshop.domain.PagCartao;
import com.caroline.petshop.domain.PagDinheiro;
import com.caroline.petshop.domain.Pet;
import com.caroline.petshop.domain.Produto;
import com.caroline.petshop.domain.Raca;
import com.caroline.petshop.domain.Servico;
import com.caroline.petshop.domain.enuns.SituacaoPagamento;
import com.caroline.petshop.repositories.CategoriaRepository;
import com.caroline.petshop.repositories.CidadeRepository;
import com.caroline.petshop.repositories.EnderecoRepository;
import com.caroline.petshop.repositories.EspecieRepository;
import com.caroline.petshop.repositories.EstadoRepository;
import com.caroline.petshop.repositories.PagamentoRepository;
import com.caroline.petshop.repositories.PessoaRepository;
import com.caroline.petshop.repositories.PetRepository;
import com.caroline.petshop.repositories.ProdutoRepository;
import com.caroline.petshop.repositories.RacaRepository;
import com.caroline.petshop.repositories.ServicoRepository;

@Component
public class PopulaDados {
	
	/*
	 *  injeção de dependencia
	 */
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	EspecieRepository especieRepository;
	
	@Autowired
	RacaRepository racaRepository;
	
	@Autowired
	PetRepository petRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	ServicoRepository servicoRepository;
	
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	
	
	//@PostConstruct
	public void cadastrar() throws ParseException {
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
			
		//
		Especie esp1 = new Especie(null,"Cachorro");
		Especie esp2 = new Especie(null,"Gato");
		
		Raca raca1 = new Raca(null,"Shitzu");
		Raca raca2 = new Raca(null,"Akita");
		Raca raca3 = new Raca(null,"Persa");
		
		Pet pet1 = new Pet(null,"John",6,esp1,raca1);
		Pet pet2 = new Pet(null,"Hana",5,esp1,raca2);
		Pet pet3 = new Pet(null,"Mewth",6,esp2,raca3);
		
	
		especieRepository.saveAll(Arrays.asList(esp1,esp2));
		racaRepository.saveAll(Arrays.asList(raca1,raca2,raca3));
		petRepository.saveAll(Arrays.asList(pet1,pet2,pet3));
		
		//
		Estado uf1 = new Estado(null,"MG");
		Estado uf2 = new Estado(null,"SP");
		
		Cidade cid1 = new Cidade(null,"Belo Horizonte",uf1);
		Cidade cid2 = new Cidade(null,"Capelinha",uf1);
		Cidade cid3 = new Cidade(null,"São Paulo",uf2);
		
		uf1.getCidades().addAll(Arrays.asList(cid1,cid2));
		uf2.getCidades().addAll(Arrays.asList(cid3));
		
		estadoRepository.saveAll(Arrays.asList(uf1,uf2));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));
		
		
		//
		Cliente clt1 = new Cliente(null, "Jose Maria", "jose@mail.com", "335.194.320-21", "FISICA");
		clt1.getTelefone().addAll(Arrays.asList("3516-2000","9191-0000"));
		
		Funcionario fnc1 = new Funcionario(null, "Maria Jose", "maria@mail.com", "551.872.200.12", "Tosador");
		fnc1.getTelefone().addAll(Arrays.asList("3279-0001","9090-0002"));
		
		Endereco end1 = new Endereco(null, "Rua Tupis", "500", "Apto 101", "Pindorama", "30111222", clt1, cid1);
		Endereco end2 = new Endereco(null, "Av. Tamoios", "100", "Casa", "Oca", "3968000", fnc1, cid2);
		Endereco end3 = new Endereco(null, "Rua Aranãs", "10", "Apto 201", "Centro", "01153000", fnc1, cid3);
		
		pessoaRepository.saveAll(Arrays.asList(clt1,fnc1));
		enderecoRepository.saveAll(Arrays.asList(end1,end2,end3));
		
		//
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy HH:mm");
		
		Servico srv1 = new Servico(null, sdf.parse("27/10/2021 09:00"), sdf.parse("27/10/2021 12:00"), "tosa", clt1, fnc1,pet1);
		Servico srv2 = new Servico(null, sdf.parse("27/10/2021 09:00"), sdf.parse("28/10/2021 12:00"), "hotel", clt1, fnc1,pet2);
		Servico srv3 = new Servico(null, sdf.parse("28/10/2021 16:00"), sdf.parse("28/10/2021 16:30"), "vermifugação", clt1, fnc1,pet3);
		
				
		PagCartao pag1 = new PagCartao(null, SituacaoPagamento.QUITADO, 60.00, srv2, 6);
		srv2.setPagamento(pag1);
		
		PagDinheiro pag2 = new PagDinheiro(null, SituacaoPagamento.PENDENTE, 100, sdf.parse("20/10/2021 00:00"), srv1, 0.0);
		srv1.setPagamento(pag2);
		
		PagDinheiro pag3 = new PagDinheiro(null, SituacaoPagamento.QUITADO, 75, sdf.parse("28/10/2021 16:30"), srv3, 0.0);
		srv3.setPagamento(pag3);
		
		clt1.getServicos().addAll(Arrays.asList(srv1,srv2));
		fnc1.getServicos().addAll(Arrays.asList(srv1,srv2));
		
		srv2.getProdutos().addAll(Arrays.asList(prod1,prod2,prod4));
		srv3.getProdutos().addAll(Arrays.asList(prod3));		
		
		servicoRepository.saveAll(Arrays.asList(srv1,srv2,srv3));
		pagamentoRepository.saveAll(Arrays.asList(pag1,pag2,pag3));
	}

}
