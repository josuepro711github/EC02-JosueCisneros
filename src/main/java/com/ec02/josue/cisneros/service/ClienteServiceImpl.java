package com.ec02.josue.cisneros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec02.josue.cisneros.entity.Cliente;
import com.ec02.josue.cisneros.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public void deleteById(Long id) {
		clienteRepository.deleteById(id);
	}

	@Override
	public Cliente findById(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

		
	
}
