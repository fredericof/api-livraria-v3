package com.frederico.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
	
	private Long id_pedido;
	private Date data_pedido = new Date();
	private String status_pedido = "Pedido Efetivado.";
	private Float valorTotal = new Float(123.25);
	private List<Item> itens = new ArrayList<Item>();
	private Long offset = new Long(1);
	private Long limit = new Long(30);
	private Long total = new Long(76);
	private Long count = new Long(30);
	
	public Pedido(){}
	
	public Pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Date getData_pedido() {
		return data_pedido;
	}

	public void setData_pedido(Date data_pedido) {
		this.data_pedido = data_pedido;
	}

	public String getStatus_pedido() {
		return status_pedido;
	}

	public void setStatus_pedido(String status_pedido) {
		this.status_pedido = status_pedido;
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
	
}
