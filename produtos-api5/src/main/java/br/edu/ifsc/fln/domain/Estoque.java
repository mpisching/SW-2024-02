package br.edu.ifsc.fln.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
public class Estoque {
	@Id
	@Column(name = "id_produto")
	private int id;
	@Getter
	private int quantidade;
	@Column(name = "qtd_maxima")
	private int quantidadeMaxima;
	@Column(name = "qtd_minima")
	private int quantidadeMinima;
	@Enumerated(EnumType.STRING)
	private ESituacao situacao = ESituacao.ATIVO;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "id_produto")
	@JsonIgnoreProperties("estoque")
	private Produto produto;

	public void repor(int quantidade) throws Exception{
		if (this.situacao != ESituacao.ATIVO) {
			throw new IllegalStateException("Estoque inativo ou bloqueado.");
		}
		if (this.quantidade + quantidade > this.quantidadeMaxima) {
			throw new IllegalStateException(
					"Quantidade excede a quantidade máxima estabelecida.");
		}
		this.quantidade += quantidade;
	}
	
	public void retirar(int quantidade) throws Exception {
		if (this.situacao != ESituacao.ATIVO) {
			throw new IllegalStateException("Estoque inativo ou bloqueado.");
		}
		if (this.quantidade - quantidade < 0) {
			throw new IllegalStateException(
					"Quantidade insuficiente para retirada.");
		}
		this.quantidade -= quantidade;	
	}
}
