package com.ec02.josue.cisneros.service;

import java.util.List;

import com.ec02.josue.cisneros.entity.Bodega;

public interface BodegaService {
	
	public List<Bodega> findAll();
	
	public Bodega findById(Long id);
	
	public Bodega save(Bodega bodega);
	
	public void deleteById(Long id);
	
}
