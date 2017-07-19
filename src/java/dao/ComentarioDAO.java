/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Comentario;

/**
 *
 * @author Pedro
 */
public interface ComentarioDAO {
    
    //insere um novo comentario no banco de dados
    public void inserir(Comentario c);
	   
    //recupera a lista de comentarios pelo id do topico
    public List<Comentario> recuperar(int id_topico);
    
}
