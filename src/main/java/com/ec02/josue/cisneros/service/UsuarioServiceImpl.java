package com.ec02.josue.cisneros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec02.josue.cisneros.entity.Usuario;
import com.ec02.josue.cisneros.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
	}

}
