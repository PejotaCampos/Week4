/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Pedro
 */
public class Usuario {
	
	private String nome, email, login, senha;
	private int pontos;
	
	public Usuario(){this.login = "";}
	
	public Usuario(String nome, String email, String login, String senha, int pontos) {
		super();
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.pontos = pontos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", email=" + email + ", login=" + login + ", senha=" + senha + ", pontos="
				+ pontos + "]";
	}

}
