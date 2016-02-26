package com.example.admin.service.bean;

public class OrderDetail {
	private int codigo_pedido;
	private int codigo_producto;
	private int cantidad;
	public int getCodigo_pedido() {
		return codigo_pedido;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public void setCodigo_pedido(int codigo_pedido) {
		this.codigo_pedido = codigo_pedido;
	}
	public int getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	
	
}
