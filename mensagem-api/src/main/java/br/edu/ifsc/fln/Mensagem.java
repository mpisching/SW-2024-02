package br.edu.ifsc.fln;

public class Mensagem {
	private final long id;
	
	private final String conteudo;
	
	public Mensagem(long id, String conteudo) {
		this.id = id;
		this.conteudo = conteudo;
	}

	public long getId() {
		return id;
	}

	public String getConteudo() {
		return conteudo;
	}
	
	
}
