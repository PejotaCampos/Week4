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
						
		}catch(SQLException e){
			throw new RuntimeException("Erro: " + e.getMessage());
		}
    }

    @Override
    public Topico recuperar(int id) {
        
        String sql = "SELECT * FROM topico WHERE id_topico = ?";
        Topico t = null;
        
        try( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera",
				"postgres", "postgres")){
			
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
       
            while(rs.next())
            {
                t = new Topico(rs.getString("titulo"), rs.getString("conteudo"), rs.getString("login"));
                t.setId(rs.getInt("id_topico"));
            }
			
            }catch(SQLException e){
		throw new RuntimeException("Erro: " + e.getMessage());
            }
        return t;
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
                Topico t = new Topico(rs.getString("titulo"), rs.getString("conteudo"), rs.getString("login"));
                t.setId(rs.getInt("id_topico"));
		listaOrdenada.add(t);
            }
			
            }catch(SQLException e){
		throw new RuntimeException("Erro: " + e.getMessage());
            }
        
	return listaOrdenada;
    }
    
}
