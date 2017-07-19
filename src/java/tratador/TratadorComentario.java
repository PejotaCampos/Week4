/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tratador;

import dao.ComentarioDAOImpl;
import java.util.List;
import model.BancoDeDados;
import model.Comentario;

/**
 *
 * @author Pedro
 */
public class TratadorComentario {
    
    private final ComentarioDAOImpl comentarioDAO = new ComentarioDAOImpl();
    
    public void inserir(String login, String comentario, int idTopico){
        BancoDeDados.criarComentarios();
        Comentario c = new Comentario(login,comentario);
        c.setId_topico(idTopico);
        
        comentarioDAO.inserir(c);
    }
    
    public List<Comentario> comentarios(int idTopico){
        BancoDeDados.criarComentarios();
        return comentarioDAO.recuperar(idTopico);
    }
}
