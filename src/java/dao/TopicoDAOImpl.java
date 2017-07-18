/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Topico;

/**
 *
 * @author Pedro
 */
public class TopicoDAOImpl implements TopicoDAO{

    @Override
    public void inserir(Topico t) {
        try( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera",
				"postgres", "postgres")){
			
			String sql = "INSERT INTO public.topico (titulo, conteudo, login) "+
			"VALUES(?, ?, ?)";
								
			PreparedStatement stm = connection.prepareStatement(sql);
			
                        stm.setString(1, t.getTitulo());
			stm.setString(2, t.getConteudo());
			stm.setString(3, t.getLogin());
			stm.executeUpdate();
			System.out.println("Topico inserido.");
						
		}catch(SQLException e){
			throw new RuntimeException("Erro: " + e.getMessage());
		}
    }

    @Override
    public Topico recuperar(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Topico> topicos() {
        List<Topico> listaOrdenada = new ArrayList<>();
	String sql = "SELECT * FROM topico;";
	try( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera",
				"postgres", "postgres")){
			
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
			
            while(rs.next())
            {
		listaOrdenada.add(new Topico(rs.getString("titulo"), rs.getString("conteudo"), rs.getString("login"),
                                             rs.getInt("id_topico")));
            }
			
            }catch(SQLException e){
		throw new RuntimeException("Erro: " + e.getMessage());
            }
        System.out.println("LISTA TOPICOS: ");
        listaOrdenada.forEach(System.out::println);
        
	return listaOrdenada;
    }
    
}
