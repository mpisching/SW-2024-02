package br.edu.ifsc.fln.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsc.fln.domain.Fornecedor;

public interface FornecedorRepository extends 
	JpaRepository<Fornecedor, Integer>{

}
