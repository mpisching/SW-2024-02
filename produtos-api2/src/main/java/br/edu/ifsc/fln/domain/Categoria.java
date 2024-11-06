package br.edu.ifsc.fln.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(of = {"id"})
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@EqualsAndHashCode.Include
	private int id;
	
	private String descricao;
	
}
