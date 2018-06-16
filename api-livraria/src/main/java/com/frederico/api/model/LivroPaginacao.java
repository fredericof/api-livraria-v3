package com.frederico.api.model;

import java.util.ArrayList;
import java.util.List;

public class LivroPaginacao {
	
	private Long offset = new Long(1);
	private Long limit = new Long(6);
	private Long total = new Long(123);
	private Long count = new Long(6);
	private List<Livro> livros = new ArrayList<Livro>();
	
	public LivroPaginacao(){}
	
	
	public LivroPaginacao(List<Livro> livros) {
		this.livros = livros;
	}

	public Long getOffset() {
		return offset;
	}

	public void setOffset(Long offset) {
		this.offset = offset;
	}

	public Long getLimit() {
		return limit;
	}

	public void setLimit(Long limit) {
		this.limit = limit;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
}
