package com.example.academia.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.academia.exceptions.CriptoExistException;
import com.example.academia.exceptions.EmailExistsException;
import com.example.academia.model.Usuario;
import com.example.academia.repositories.UsuarioRepository;
import com.example.academia.util.Util;

@Service
public class ServiceUsuario {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void salvarUsuario(Usuario user) throws Exception{
		try {
			
			if(usuarioRepository.findByEmail(user.getEmail()) != null) {
				throw new EmailExistsException("Já existe um email cadastrado para: " + user.getEmail());
			}
			
			user.setSenha(Util.md5(user.getSenha()));
			
		}
		catch(NoSuchAlgorithmException e) {
			throw new CriptoExistException("Erro na criptografia da senha");
		}
		
		usuarioRepository.save(user);
	}
}
