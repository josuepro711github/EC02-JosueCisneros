package com.ec02.josue.cisneros.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bodega")
public class Bodega{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBodega;
	
	private String nombre;
	
	@ManyToOne
	@JoinColumn(
			name = "id_producto", 
			nullable = false, 
			unique = true, 
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_producto) references Productos(id_producto)")
		)
	private Producto producto;

	public Bodega() {
	}

	public Long getIdBodega() {
		return idBodega;
	}

	public void setIdBodega(Long idBodega) {
		this.idBodega = idBodega;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	
	
}
