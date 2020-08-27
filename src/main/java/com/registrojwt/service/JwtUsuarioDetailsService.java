package com.registrojwt.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.registrojwt.dao.UsuarioDao;
import com.registrojwt.model.Usuario;
import com.registrojwt.model.UsuarioDTO;

@Service
public class JwtUsuarioDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioDao usuDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {

		Usuario usu = (Usuario) usuDao.findByUsername(nome);
		if (usu == null) {
			throw new UsernameNotFoundException("User not found with username: " + nome);
		}
		return new org.springframework.security.core.userdetails.User(usu.getNome(), usu.getSenha(),
				new ArrayList<>());
	}

	public Usuario save(UsuarioDTO usu) {
		Usuario novoUsu = new Usuario();
		novoUsu.setNome(usu.getNome());
		novoUsu.setSenha(bcryptEncoder.encode(usu.getSenha()));
		return usuDao.save(novoUsu);
	}
}
