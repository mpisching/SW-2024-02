package br.edu.ifsc.fln.model.domain;

public class Produto {
	private int id;
	private String nome;
	private int quantidade;
	private double preco;
	private int margemLucro;
	public Produto(int id, String nome, int quantidade, double preco, int margemLucro) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		this.margemLucro = margemLucro;
	}
	public Produto() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getMargemLucro() {
		return margemLucro;
	}
	public void setMargemLucro(int margemLucro) {
		this.margemLucro = margemLucro;
	}
	
	public double calcularPrecoVenda() {
		return preco + (preco * margemLucro / 100);
	}
}
