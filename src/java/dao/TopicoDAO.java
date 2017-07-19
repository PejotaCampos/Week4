/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Topico;

/**
 *
 * @author Pedro
 */
public interface TopicoDAO {
    
    //insere um novo usuário no banco de dados
    public void inserir(Topico t);
	   
    //recupera o usuário pelo seu login
    public Topico recuperar(int id);
    
    //recupera todos os topicos do banco
    public List<Topico> topicos();
    
}
