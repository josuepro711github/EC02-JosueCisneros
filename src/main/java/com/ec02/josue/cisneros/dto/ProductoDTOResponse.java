package com.ec02.josue.cisneros.dto;

public class ProductoDTOResponse {

	private Long id_prod;
	private String descripcion_prod;
	private Double precio_prod;
	private String producto_prod;
	private Integer stock_prod;

	public Long getId_prod() {
		return id_prod;
	}

	public void setId_prod(Long id_prod) {
		this.id_prod = id_prod;
	}

	public String getDescripcion_prod() {
		return descripcion_prod;
	}

	public void setDescripcion_prod(String descripcion_prod) {
		this.descripcion_prod = descripcion_prod;
	}

	public Double getPrecio_prod() {
		return precio_prod;
	}

	public void setPrecio_prod(Double precio_prod) {
		this.precio_prod = precio_prod;
	}

	public String getProducto_prod() {
		return producto_prod;
	}

	public void setProducto_prod(String producto_prod) {
		this.producto_prod = producto_prod;
	}

	public Integer getStock_prod() {
		return stock_prod;
	}

	public void setStock_prod(Integer stock_prod) {
		this.stock_prod = stock_prod;
	}
	
}
