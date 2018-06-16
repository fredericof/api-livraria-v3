package com.frederico.api.model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	
	private Long carrinho_id;
	private Float valorTotal = new Float(321.67);
	private List<Item> itens = new ArrayList<Item>();
	private Long offset = new Long(1);
	private Long limit = new Long(5);
	private Long total = new Long(15);
	private Long count = new Long(5);
	
	public Carrinho() {}
	
	public Carrinho(Long carrinho_id) {
		this.carrinho_id = carrinho_id;
	}

	public Float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
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

	public Long getCarrinho_id() {
		return carrinho_id;
	}

	public void setCarrinho_id(Long carrinho_id) {
		this.carrinho_id = carrinho_id;
	}
	
}
