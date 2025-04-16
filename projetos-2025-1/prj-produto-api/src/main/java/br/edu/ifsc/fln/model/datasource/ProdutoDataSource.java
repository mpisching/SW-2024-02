package br.edu.ifsc.fln.model.datasource;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsc.fln.model.domain.Produto;

public class ProdutoDataSource {
	private static List<Produto> listaProdutos = new ArrayList<>();
	
	public static void criarLista() {
		listaProdutos.add(new Produto(1, "TV", 10, 1200, 20));
		listaProdutos.add(new Produto(2, "CELULAR", 40, 3210, 90));
		listaProdutos.add(new Produto(3, "TABLET", 5, 2400, 50));
		listaProdutos.add(new Produto(4, "NOTEBOOK", 8, 3500, 80));
	}

	public static List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public static void setListaProdutos(List<Produto> listaProdutos) {
		ProdutoDataSource.listaProdutos = listaProdutos;
	}
	
	public static double encontrarPrecoVenda(int id) {
		for (Produto p : listaProdutos) {
			if (p.getId() == id) {
				return p.calcularPrecoVenda();
			}
		}
		return 0.0;
	}
	
	public static Produto adicionar(Produto produto) {
		listaProdutos.add(produto);
		return produto;
	}
	
	
}
