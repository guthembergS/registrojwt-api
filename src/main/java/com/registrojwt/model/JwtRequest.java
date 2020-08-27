package com.registrojwt.model;

import java.io.Serializable;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String nome;
	private String senha;
	
	//need default constructor for JSON Parsing
	public JwtRequest()
	{
		
	}

	public JwtRequest(String nome, String senha) {
		this.setUsername(nome);
		this.setPassword(senha);
	}

	public String getUsername() {
		return this.nome;
	}

	public void setUsername(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return this.senha;
	}

	public void setPassword(String password) {
		this.senha = password;
	}
}