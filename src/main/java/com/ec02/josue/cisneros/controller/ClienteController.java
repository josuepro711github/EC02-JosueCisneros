package com.ec02.josue.cisneros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec02.josue.cisneros.entity.Cliente;
import com.ec02.josue.cisneros.service.ClienteService;

@RestController
@RequestMapping("/ec02josuecisneros/v1")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente> getAllClientes(){
		return clienteService.findAll();
	}
	
	@PostMapping("/clientes")
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}
	
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable(value = "id") Long id){
		Cliente cliente = clienteService.findById(id);
		return ResponseEntity.ok().body(cliente);
	}
	
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable(value = "id") Long id
			,@RequestBody Cliente clienteUpdate) {
		Cliente cliente = clienteService.findById(id);
		cliente.setNombre(clienteUpdate.getNombre());
		cliente.setDireccion(clienteUpdate.getDireccion());
		cliente.setDni(clienteUpdate.getDni());
		clienteService.save(cliente);
		return ResponseEntity.ok().body(cliente);
	}
	
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> deleteCliente(@PathVariable(value = "id") Long id) {
		clienteService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}









