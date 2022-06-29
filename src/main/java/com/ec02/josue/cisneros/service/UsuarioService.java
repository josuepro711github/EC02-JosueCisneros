package com.ec02.josue.cisneros.service;

import java.util.List;

import com.ec02.josue.cisneros.entity.Usuario;

public interface UsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario findById(Long id);
	
	public Usuario save(Usuario usuario);
	
	public void deleteById(Long id);
	
}
