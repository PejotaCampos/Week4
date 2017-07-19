/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class Topico {

    private String titulo, conteudo, login;
    private int id;
    //private List<Comentario> comentarios;

    public Topico(String titulo, String conteudo, String login) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.login = login;
      //  this.comentarios = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
//    public void addComent(Comentario c){
//        this.comentarios.add(c);
//    }
//
//    public List<Comentario> getComentarios() {
//        return comentarios;
//    }
        
    @Override
    public String toString() {
        return "Topico{" + "titulo=" + titulo + ", conteudo=" + conteudo + ", login=" + login + ", id=" + id + '}';
    }
    
}
