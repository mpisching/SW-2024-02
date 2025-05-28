package br.edu.ifsc.fln.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsc.fln.domain.Categoria;
import br.edu.ifsc.fln.domain.Produto;
import br.edu.ifsc.fln.repository.CategoriaRepository;
import br.edu.ifsc.fln.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	//@Autowired
	private ProdutoRepository produtoRepository;
	private CategoriaRepository categoriaRepository;
	
	public ProdutoController(ProdutoRepository produtoRepository, 
			CategoriaRepository categoriaRepository) {
		this.produtoRepository = produtoRepository;
		this.categoriaRepository = categoriaRepository;
	}
	
	@GetMapping
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> pesquisar(@PathVariable Integer id) {
		return produtoRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto inserir(@RequestBody Produto produto) {
		produto = produtoRepository.save(produto);
		
		Optional<Categoria> c = categoriaRepository
				.findById(produto.getCategoria().getId());
		produto.setCategoria(c.get());
		return produto;
	}
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Integer id, 
											 @RequestBody Produto produto) {
		if (!produtoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		} else {
			produto.setId(id);
			Produto produtoAtualizado = produtoRepository.save(produto);
			Optional<Categoria> c = categoriaRepository
					.findById(produto.getCategoria().getId());
			produtoAtualizado.setCategoria(c.get());
			return ResponseEntity.ok(produtoAtualizado);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Integer id) {
		if (!produtoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		} else {
			produtoRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
	}
	
}
