package com.ec02.josue.cisneros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec02.josue.cisneros.entity.Bodega;
import com.ec02.josue.cisneros.repository.BodegaRepository;

@Service
public class BodegaServiceImpl implements BodegaService {

	@Autowired
	BodegaRepository bodegaRepository;
	
	@Override
	public List<Bodega> findAll() {
		return bodegaRepository.findAll();
	}

	@Override
	public Bodega findById(Long id) {
		return bodegaRepository.findById(id).orElse(null);
	}

	@Override
	public Bodega save(Bodega bodega) {
		return bodegaRepository.save(bodega);
	}

	@Override
	public void deleteById(Long id) {
		bodegaRepository.deleteById(id);
	}

}
