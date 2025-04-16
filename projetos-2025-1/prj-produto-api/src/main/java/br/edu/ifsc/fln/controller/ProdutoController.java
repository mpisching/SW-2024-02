package br.edu.ifsc.fln.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsc.fln.model.datasource.ProdutoDataSource;
import br.edu.ifsc.fln.model.domain.Produto;

@RestController
public class ProdutoController {
	
	@RequestMapping(value = "/produtos")
	public List<Produto> listar() {
		return ProdutoDataSource.getListaProdutos();
	}
	
	@RequestMapping(value = "/produtos/{id}")
	public double precoVenda(@PathVariable("id") int id) {
		return ProdutoDataSource.encontrarPrecoVenda(id);
	}
	
	@RequestMapping(value = "/produtos/{id}/{nome}/{quantidade}/{preco}/{margemLucro}")
	public Produto novo(
			@PathVariable("id") int id, 
			@PathVariable("nome") String nome, 
			@PathVariable("quantidade") int quantidade, 
			@PathVariable("preco") double preco, 
			@PathVariable("margemLucro") int margemLucro) {
		Produto produto = new Produto(id, nome, quantidade, preco, margemLucro);
		return ProdutoDataSource.adicionar(produto);
	}
}
