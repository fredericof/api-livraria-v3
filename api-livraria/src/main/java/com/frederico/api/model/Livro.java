package com.frederico.api.model;

public class Livro {
	
	private Long id_livro;
	private String titulo;
	private String autor;
	private String isbn;
	private Float preco;
	
	public Livro() {}
	
	public Livro(Long id_livro, String titulo, String autor, String isbn, Float preco) {
		this.id_livro = id_livro;
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.preco = preco;
	}

	public Long getId_livro() {
		return id_livro;
	}

	public void setId_livro(Long id_livro) {
		this.id_livro = id_livro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	};
	
}
