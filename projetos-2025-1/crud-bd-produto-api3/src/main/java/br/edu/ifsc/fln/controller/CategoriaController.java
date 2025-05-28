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
import br.edu.ifsc.fln.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> pesquisar(@PathVariable int id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if (categoria.isPresent()) {
			return ResponseEntity.ok(categoria.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Categoria>> pesquisar(@PathVariable String descricao) {
		//List<Categoria> categorias = categoriaRepository.findByDescricaoContaining(descricao);
		List<Categoria> categorias = categoriaRepository.findByDescricao(descricao);
		if (categorias.size() > 0) {
			return ResponseEntity.ok(categorias);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria inserir(@RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> atualizar(
			@PathVariable int id, 
			@RequestBody Categoria categoria) {
		if (!categoriaRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		} else {
			categoria.setId(id);
			Categoria entidadeAtualizada = categoriaRepository.save(categoria);
			return ResponseEntity.ok(entidadeAtualizada);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable int id) {
		if (!categoriaRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		} else {
			categoriaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
	}
}
