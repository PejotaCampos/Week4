/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tratador;

import dao.TopicoDAOImpl;
import java.util.List;
import model.Topico;

/**
 *
 * @author Pedro
 */
public class TratadorTopico {
    
    public void cadastraTopico(Topico t){
        
        TopicoDAOImpl topicoManager = new TopicoDAOImpl();
        topicoManager.inserir(t);
    }
    
    public List<Topico> topicos(){
     
        TopicoDAOImpl topicoManager = new TopicoDAOImpl();
        List<Topico> topicos = topicoManager.topicos();
        return topicos;
    }
    
}
