package br.edu.ifsc.fln.controller;

import java.util.List;

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

import br.edu.ifsc.fln.domain.Fornecedor;
import br.edu.ifsc.fln.domain.Produto;
import br.edu.ifsc.fln.repository.FornecedorRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
	
	//@Autowired
	private FornecedorRepository fornecedorRepository;
	
	//construtor criado pelo lombok (com AllArgsConstructor)
//	public FornecedorController(FornecedorRepository fornecedorRepository) {
//		this.fornecedorRepository = fornecedorRepository;
//	}
	
	@GetMapping
	public List<Fornecedor> listar() {
		return fornecedorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Fornecedor> pesquisar(@PathVariable Integer id) {
		return fornecedorRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Fornecedor inserir(@RequestBody Fornecedor fornecedor) {
		fornecedor = fornecedorRepository.save(fornecedor);
		return fornecedor;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Fornecedor> atualizar(
			@PathVariable Integer id, 
			@RequestBody Fornecedor fornecedor) {
		if (!fornecedorRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		} else {
			fornecedor.setId(id);
			return ResponseEntity.ok(fornecedorRepository.save(fornecedor));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Integer id) {
		if (!fornecedorRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		} else {
			fornecedorRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
	}		
}
