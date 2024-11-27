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
import br.edu.ifsc.fln.domain.Fornecedor;
import br.edu.ifsc.fln.domain.Produto;
import br.edu.ifsc.fln.dto.ProdutoDTO;
import br.edu.ifsc.fln.repository.CategoriaRepository;
import br.edu.ifsc.fln.repository.FornecedorRepository;
import br.edu.ifsc.fln.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@GetMapping
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Produto buscar(@PathVariable int id) {
		return produtoRepository.findById(id).get();
	}
	
	@GetMapping("/busca/{id}")
	public ResponseEntity<ProdutoDTO> buscarOtimizado(@PathVariable int id) {
		return produtoRepository.findById(id)
				.map(produto -> {
					var produtoDTO = new ProdutoDTO();
					produtoDTO.setId(produto.getId());
					produtoDTO.setNome(produto.getNome());
					produtoDTO.setDescricaoProduto(produto.getDescricao());
					produtoDTO.setDescricaoCategoria(produto.getCategoria().getDescricao());
					return produtoDTO;
				})
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto inserir(@RequestBody Produto produto) {
		//return produtoRepository.save(produto); //essa instrução grava o produto e retorno o novo objeto, porém sem os detalhes da categoria
		produto = produtoRepository.save(produto);
		Optional<Categoria> categoria = categoriaRepository.findById(produto.getCategoria().getId());
		produto.setCategoria(categoria.get());
		Optional<Fornecedor> fornecedor = 
				fornecedorRepository.findById(produto.getFornecedor().getId());
		produto.setFornecedor(fornecedor.get());
		return produto;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(
			@PathVariable Integer id, 
			@RequestBody Produto produto) {
		if (!produtoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		} else {
			produto.setId(id);
			return ResponseEntity.ok(produtoRepository.save(produto));
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
