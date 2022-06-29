package com.ec02.josue.cisneros.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec02.josue.cisneros.dto.ProductoDTORequest;
import com.ec02.josue.cisneros.dto.ProductoDTOResponse;
import com.ec02.josue.cisneros.entity.Producto;
import com.ec02.josue.cisneros.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoRepository productoRepository;

	@Override
	public List<ProductoDTOResponse> findAll() {
		List<Producto> productos= productoRepository.findAll();
		List<ProductoDTOResponse> productosResponse = new ArrayList<>();
		ProductoDTOResponse prod = null;
		for (Producto producto : productos) {
			prod = new ProductoDTOResponse();
			prod.setId_prod(producto.getIdProducto());
			prod.setDescripcion_prod(producto.getDescripcion());
			prod.setPrecio_prod(producto.getPrecio());
			prod.setProducto_prod(producto.getProducto());
			prod.setStock_prod(producto.getStock());
			productosResponse.add(prod);
		}
		return productosResponse;
	}

	@Override
	public ProductoDTOResponse findById(Long id) {
		Producto producto = productoRepository.findById(id).orElse(null);
		ProductoDTOResponse prod = new ProductoDTOResponse();
		prod.setId_prod(producto.getIdProducto());
		prod.setDescripcion_prod(producto.getDescripcion());
		prod.setPrecio_prod(producto.getPrecio());
		prod.setProducto_prod(producto.getProducto());
		prod.setStock_prod(producto.getStock());
		return prod;
	}

	@Override
	public void save(ProductoDTORequest producto) {
		Producto p = new Producto();
		p.setDescripcion(producto.getDescripcion_prod());
		p.setPrecio(producto.getPrecio_prod());
		p.setProducto(producto.getProducto_prod());
		p.setStock(producto.getStock_prod());	
		productoRepository.save(p);
	}

	@Override
	public void deleteById(Long id) {
		productoRepository.deleteById(id);
	}

	@Override
	public void edit(ProductoDTORequest producto) {
		Producto p = new Producto();
		p.setIdProducto(producto.getId_prod());
		p.setDescripcion(producto.getDescripcion_prod());
		p.setPrecio(producto.getPrecio_prod());
		p.setProducto(producto.getProducto_prod());
		p.setStock(producto.getStock_prod());	
		productoRepository.saveAndFlush(p);
	}
	
	

}
