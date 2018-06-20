package com.frederico.api.model;

public class Quantidade {
	
	private String usuario;
	private String senha;
	private Long id_livro;
	private String quantidade;
	
	public Quantidade(){}
	
	public Quantidade(String usuario, String senha, Long id_livro, String quantidade) {
		this.usuario = usuario;
		this.senha = senha;
		this.id_livro = id_livro;
		this.quantidade = quantidade;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
