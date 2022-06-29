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

import com.ec02.josue.cisneros.entity.Bodega;
import com.ec02.josue.cisneros.service.BodegaService;

@RestController
@RequestMapping("/ec02josuecisneros/v1")
public class BodegaController {
	
	@Autowired
	BodegaService bodegaService;
	
	@GetMapping("/bodegas")
	public List<Bodega> getAllBodegas(){
		return bodegaService.findAll();
	}
	
	@PostMapping("/bodegas")
	public Bodega crearBodega(@RequestBody Bodega bodega) {
		return bodegaService.save(bodega);
	}
	
	@GetMapping("/bodegas/{id}")
	public ResponseEntity<Bodega> getBodegaById(@PathVariable(value = "id") Long id) {
		Bodega bodega = bodegaService.findById(id);
		return ResponseEntity.ok().body(bodega);
	}
	
	@PutMapping("/bodegas/{id}")
	public ResponseEntity<Bodega> updateBodega(@PathVariable(value = "id") Long id
			,@RequestBody Bodega bodegaUpdate) {
		Bodega bodega = bodegaService.findById(id);
		bodega.setNombre(bodegaUpdate.getNombre());
		bodegaService.save(bodega);
		return ResponseEntity.ok().body(bodega);
	}
	
	@DeleteMapping("/bodegas/{id}")
	public ResponseEntity<?> deleteBodega(@PathVariable(value = "id") Long id) {
		bodegaService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}









