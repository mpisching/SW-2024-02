package br.edu.ifsc.fln.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsc.fln.domain.Produto;
import br.edu.ifsc.fln.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	//@Autowired
	private ProdutoRepository produtoRepository;
	
	public ProdutoController(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	@GetMapping
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}
}
