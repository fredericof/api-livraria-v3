package com.frederico.api.model;

public class Item{
	
	private Long quantidade = new Long(7);
	private Livro livro = new Livro();
	
	public Item() {}
	
	public Item(Long quantidade, Livro livro) {
		this.quantidade = quantidade;
		this.livro = livro;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}
