package com.ec02.josue.cisneros.service;

import java.util.List;

import com.ec02.josue.cisneros.entity.Cliente;

public interface ClienteService {
	
	public List<Cliente> findAll();
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void deleteById(Long id);

}
