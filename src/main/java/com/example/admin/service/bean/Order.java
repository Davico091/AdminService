package com.example.admin.service.bean;

import java.util.List;

public class Order {

	private int codigo_pedido;
	private int codigo_cliente;
	private String fecha_pedido;
	private List<OrderDetail> details;
	public int getCodigo_pedido() {
		return codigo_pedido;
	}
	public void setCodigo_pedido(int codigo_pedido) {
		this.codigo_pedido = codigo_pedido;
	}
	public int getCodigo_cliente() {
		return codigo_cliente;
	}
	public void setCodigo_cliente(int codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}
	public String getFecha_pedido() {
		return fecha_pedido;
	}
	public void setFecha_pedido(String fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}
	public List<OrderDetail> getDetails() {
		return details;
	}
	public void setDetails(List<OrderDetail> details) {
		this.details = details;
	}
	
}
