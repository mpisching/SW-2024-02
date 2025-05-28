package br.edu.ifsc.fln.controller;

import java.util.List;

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
import br.edu.ifsc.fln.repository.FornecedorRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

	//@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public FornecedorController(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository; 
	}
	
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
	public Fornecedor inserir(@Valid @RequestBody Fornecedor Fornecedor) {
		Fornecedor = fornecedorRepository.save(Fornecedor);
		return Fornecedor;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Fornecedor> atualizar(@PathVariable Integer id, 
											 @RequestBody Fornecedor Fornecedor) {
		if (!fornecedorRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		} else {
			Fornecedor.setId(id);
			Fornecedor FornecedorAtualizado = fornecedorRepository.save(Fornecedor);
			return ResponseEntity.ok(FornecedorAtualizado);
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
