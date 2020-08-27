package com.registrojwt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.registrojwt.model.Usuario;

@Repository
public interface UsuarioDao extends CrudRepository<Usuario, Integer>{
	UsuarioDao findByUsername(String nome);
}
