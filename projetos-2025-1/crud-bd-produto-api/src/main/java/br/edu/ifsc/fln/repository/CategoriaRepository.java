package br.edu.ifsc.fln.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsc.fln.domain.Categoria;

@Repository
public interface CategoriaRepository 
		extends JpaRepository<Categoria, Integer> {
	
	public List<Categoria> findByDescricao(String descricao);
	public List<Categoria> findByDescricaoContaining(String descricao);
}
