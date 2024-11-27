package br.edu.ifsc.fln.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {
	private Integer id;
	private String nome;
	private String descricaoProduto;
	private String descricaoCategoria;
}
