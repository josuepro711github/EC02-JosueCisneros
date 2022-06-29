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

import com.ec02.josue.cisneros.entity.Usuario;
import com.ec02.josue.cisneros.service.UsuarioService;

@RestController
@RequestMapping("/ec02josuecisneros/v1")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public List<Usuario> getAllUsuarios(){
		return usuarioService.findAll();
	}
	
	@PostMapping("/usuarios")
	public Usuario crearUsuario(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable(value = "id") Long id){
		Usuario usuario = usuarioService.findById(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable(value = "id") Long id
			,@RequestBody Usuario usuarioUpdate){
		Usuario usuario = usuarioService.findById(id);
		usuario.setPassword(usuarioUpdate.getPassword());
		usuario.setRol(usuarioUpdate.getRol());
		usuario.setUsuario(usuarioUpdate.getUsuario());
		usuarioService.save(usuario);
		return ResponseEntity.ok().body(usuario);
	}
	
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable(value = "id") Long id){
		usuarioService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}






