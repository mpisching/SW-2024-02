package br.edu.ifsc.fln.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public Categoria buscar(@PathVariable int id) {
		return categoriaRepository.findById(id).get();
	}
	
	@GetMapping("/descricao/{descricao}")
	public List<Categoria> pesquisar(@PathVariable String descricao) {
		return categoriaRepository.findByDescricaoContaining(descricao);
	}
	
	@PostMapping
	public Categoria inserir(@RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	@PutMapping("/{id}")
	public Categoria atualizar(
			@PathVariable Integer id, 
			@RequestBody Categoria categoria) {
		if (categoriaRepository.existsById(id)) {
			categoria.setId(id);
			return categoriaRepository.save(categoria);
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Integer id) {
		if (!categoriaRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		} else {
			categoriaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
	}
}
