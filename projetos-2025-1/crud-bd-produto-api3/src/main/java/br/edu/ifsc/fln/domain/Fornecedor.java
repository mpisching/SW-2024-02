package br.edu.ifsc.fln.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
public class Fornecedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message="O nome do fornecedor é obrigatório.")
	@Size(max=50, message="O nome não pode ter mais do que 50 caracteres.")
	private String nome;
	private String email;
	private String fone;
	
	@OneToMany(mappedBy="fornecedor")
	@JsonIgnoreProperties("fornecedor")
	private List<Produto> produtos = new ArrayList<>();
}
