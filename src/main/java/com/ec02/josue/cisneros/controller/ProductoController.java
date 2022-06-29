package com.ec02.josue.cisneros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ec02.josue.cisneros.dto.ProductoDTORequest;
import com.ec02.josue.cisneros.dto.ProductoDTOResponse;
import com.ec02.josue.cisneros.service.ProductoService;

@RestController
@RequestMapping("/ec02josuecisneros/v1")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/productos")
	public @ResponseBody ResponseEntity<List<ProductoDTOResponse>> listar(){
		return new ResponseEntity<List<ProductoDTOResponse>>(productoService.findAll(),HttpStatus.OK);
	}
	
	@PostMapping("/productos")
	public ResponseEntity<Void> guardar(@RequestBody ProductoDTORequest productos) {
		productoService.save(productos);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/productos/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable(value = "id") Long id) {
		ProductoDTOResponse p =productoService.findById(id);
		if(p != null) {
			productoService.deleteById(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
	@PutMapping("/productos")
	public ResponseEntity<Void> actualizar(@RequestBody ProductoDTORequest producto) {
		ProductoDTOResponse p =productoService.findById(producto.getId_prod());
		if(p != null) {
			productoService.edit(producto);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<ProductoDTOResponse> obtenerId(@PathVariable(value = "id") Long id) {
		ProductoDTOResponse p =productoService.findById(id);
		if(p != null) {
			return  new ResponseEntity<ProductoDTOResponse>(productoService.findById(id),HttpStatus.OK);
		}
		return  new ResponseEntity<ProductoDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	
}











