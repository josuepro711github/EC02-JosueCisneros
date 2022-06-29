package com.ec02.josue.cisneros.service;

import java.util.List;

import com.ec02.josue.cisneros.dto.ProductoDTORequest;
import com.ec02.josue.cisneros.dto.ProductoDTOResponse;

public interface ProductoService {

	public List<ProductoDTOResponse> findAll();
	
	public ProductoDTOResponse findById(Long id);
	
	public void save(ProductoDTORequest producto);
	
	public void deleteById(Long id);
	
	public void edit(ProductoDTORequest producto);
}
