package tratador;

import dao.TopicoDAOImpl;
import java.util.List;
import model.Topico;

/**
 *
 *CLASSE INTERMEDIARIA ENTRA BD E CONTROLE
 */
public class TratadorTopico {
    
    public void cadastraTopico(Topico t){
        TopicoDAOImpl topicoManager = new TopicoDAOImpl();
        topicoManager.inserir(t);
    }
    
    public Topico recuperar(int id){
        TopicoDAOImpl topicoManager = new TopicoDAOImpl();
        return topicoManager.recuperar(id);
    }
    
    public List<Topico> topicos(){
        TopicoDAOImpl topicoManager = new TopicoDAOImpl();
        List<Topico> topicos = topicoManager.topicos();
        return topicos;
    }
    
}
