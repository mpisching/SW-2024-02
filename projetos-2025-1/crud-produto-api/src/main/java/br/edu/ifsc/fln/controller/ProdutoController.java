package br.edu.ifsc.fln.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsc.fln.domain.Produto;
import br.edu.ifsc.fln.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping("/novo")
	public Produto novo(@RequestBody Produto produto) {
		return produtoService.novo(produto);
	}
	
	@GetMapping("/todos")
	public List<Produto> getAll() {
		return produtoService.getAll();
	}
	
	@GetMapping("/get/{id}")
	public Produto get(@PathVariable int id) {
		return produtoService.get(id);
	}
}
