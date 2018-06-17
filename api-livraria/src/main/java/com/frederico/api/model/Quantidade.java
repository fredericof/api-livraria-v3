package com.frederico.api.model;

public class Quantidade {
	
	private Long id_livro;
	private String quantidade;
	
	public Quantidade(){}
	
	public Quantidade(Long id_livro, String quantidade) {
		this.id_livro = id_livro;
		this.quantidade = quantidade;
	}

	public Long getId_livro() {
		return id_livro;
	}

	public void setId_livro(Long id_livro) {
		this.id_livro = id_livro;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	
}
