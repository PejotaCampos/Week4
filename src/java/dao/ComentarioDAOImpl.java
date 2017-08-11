package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Comentario;

/**
 *
 * @author Pedro
 */
public class ComentarioDAOImpl implements ComentarioDAO{

    @Override
    public void inserir(Comentario c) {
        try( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera",
				"postgres", "postgres")){

			String sql = "INSERT INTO public.comentario (comentario, login, id_topico) "+
			"VALUES(?, ?, ?)";
								
			PreparedStatement stm = connection.prepareStatement(sql);
			
                        stm.setString(1, c.getComentario());
			stm.setString(2, c.getLogin());
			stm.setInt(3, c.getId_topico());
			stm.executeUpdate();
						
		}catch(SQLException e){
			throw new RuntimeException("Erro: " + e.getMessage());
		}
    }

    @Override
    public List<Comentario> recuperar(int id_topico) {
        
        List<Comentario> comentarios = new ArrayList<>();
        String sql = "SELECT * FROM public.comentario WHERE id_topico = ?"+
			"ORDER BY id_comentario";
        
        try( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera",
				"postgres", "postgres")){
								
            PreparedStatement stm = connection.prepareStatement(sql);
			
            stm.setInt(1, id_topico);
			
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Comentario c = new Comentario(rs.getString("login"),rs.getString("comentario"));
                c.setId_topico(id_topico);
                c.setId_comentario(rs.getInt("id_comentario"));
                comentarios.add(c);
            }
						
	}catch(SQLException e){
            throw new RuntimeException("Erro: " + e.getMessage());
	}
        
        return comentarios;
    }
    
}
