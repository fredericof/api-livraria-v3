package com.frederico.api.model;

public class Pagamento {
	
	private String usuario;
	private String senha;
	private String numeroCartaoCreditor;
	
	public Pagamento(){}
	
	public Pagamento(String usuario, String senha, String numeroCartaoCreditor) {
		this.usuario = usuario;
		this.senha = senha;
		this.numeroCartaoCreditor = numeroCartaoCreditor;
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

	public String getNumeroCartaoCreditor() {
		return numeroCartaoCreditor;
	}

	public void setNumeroCartaoCreditor(String numeroCartaoCreditor) {
		this.numeroCartaoCreditor = numeroCartaoCreditor;
	}

}
