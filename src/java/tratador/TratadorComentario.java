/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tratador;

import dao.ComentarioDAOImpl;
import model.BancoDeDados;
import model.Comentario;

/**
 *
 * @author Pedro
 */
public class TratadorComentario {
    
    public void inserir(String login, String comentario, int idTopico){
        BancoDeDados.criarComentarios();
        Comentario c = new Comentario(login,comentario);
        c.setId_topico(idTopico);
        ComentarioDAOImpl comentarioDAO = new ComentarioDAOImpl();
        comentarioDAO.inserir(c);
    }
    
}
