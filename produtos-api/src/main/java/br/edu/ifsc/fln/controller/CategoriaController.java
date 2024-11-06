package br.edu.ifsc.fln.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsc.fln.domain.Categoria;
import br.edu.ifsc.fln.repository.CategoriaRepository;

@RestController
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping("/categorias")
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}
	
	@GetMapping("/categorias/{id}")
	public Categoria buscar(@PathVariable int id) {
		return categoriaRepository.findById(id).get();
	}
}
