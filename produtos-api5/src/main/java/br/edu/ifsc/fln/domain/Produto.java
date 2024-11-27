package br.edu.ifsc.fln.domain;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "id_fornecedor" )
	@JsonIgnoreProperties("produtos")
	private Fornecedor fornecedor;
	
	@Getter
	@OneToOne(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties("produto")
	private Estoque estoque;
	
	public Produto() {
		this.estoque = new Estoque();
		this.estoque.setProduto(this);
	}
	
}
