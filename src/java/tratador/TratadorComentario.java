package tratador;

import dao.ComentarioDAOImpl;
import java.util.List;
import model.Comentario;

/**
 *
 *CLASSE INTERMEDIARIA ENTRA BD E CONTROLE
 */
public class TratadorComentario {
    
    private final ComentarioDAOImpl comentarioDAO = new ComentarioDAOImpl();
    
    public void inserir(String login, String comentario, int idTopico){
        Comentario c = new Comentario(login,comentario);
        c.setId_topico(idTopico);
        
        comentarioDAO.inserir(c);
    }
    
    public List<Comentario> comentarios(int idTopico){
        return comentarioDAO.recuperar(idTopico);
    }
}
