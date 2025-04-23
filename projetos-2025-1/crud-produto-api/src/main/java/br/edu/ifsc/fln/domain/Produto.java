package br.edu.ifsc.fln.domain;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {
	private int id;
	private String nome;
	private String descricao;
	private BigDecimal valor;
	private int quantidade;
}
