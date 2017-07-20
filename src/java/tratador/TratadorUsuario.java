/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tratador;

import model.BancoDeDados;
import model.Usuario;
import dao.UsuarioDAOImpl;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class TratadorUsuario {
    
    public void cadastra(String login, String senha, String nome, String email){
        
        BancoDeDados.criarTabela();
        
        if(! this.userExists(login)){       
            
            UsuarioDAOImpl userDAO = new UsuarioDAOImpl();
            Usuario u = new Usuario(nome, email, login, senha, 0);
            userDAO.inserir(u);
        }

    }
    
    public Usuario autenticar(String login, String senha){
        
        BancoDeDados.criarTabela();
        
        UsuarioDAOImpl userDAO = new UsuarioDAOImpl();
        System.out.println("Autenticando: "+login);
        if(this.userExists(login)){
            System.out.println("IF Autenticando: "+login);
            return userDAO.recuperar(login);
        }else{
            System.out.println("ELSE Autenticando: "+login);
            return null;
        }            
    }
    
    private boolean userExists(String login){
        UsuarioDAOImpl userDAO = new UsuarioDAOImpl();
        System.out.println("USER EXIST: "+login);
        //Usuario recuperado = userDAO.recuperar(login);
        if(userDAO.recuperar(login).getLogin().isEmpty()){
            System.out.println("IF que deve retornar falso (user nao existe): "+login);
            return false; //usuario não existe e deve ser adicionado no banco
        }
        System.out.println("USER existe: "+login);
        return true; //usuario existe e NÃO deve ser adicionado no banco
    }
    
    public List<Usuario> ranking(){
        UsuarioDAOImpl userDAO = new UsuarioDAOImpl();
        return userDAO.ranking();
    }
    
    public void addPonto(String login, int pontos){
        UsuarioDAOImpl userDAO = new UsuarioDAOImpl();
        userDAO.adicionarPontos(login, pontos);
    }
    
}
