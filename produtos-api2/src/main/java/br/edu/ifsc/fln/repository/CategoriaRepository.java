package br.edu.ifsc.fln.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsc.fln.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	//https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
	List<Categoria> findByDescricaoContaining(String descricao);
	List<Categoria> findByDescricao(String descricao);
}
