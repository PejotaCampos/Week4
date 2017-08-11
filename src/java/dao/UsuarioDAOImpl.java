package dao;

/**
 *
 * @author Pedro
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;


/*
 * Classe que implementa a interface UsuarioDAO
 * */
public class UsuarioDAOImpl implements UsuarioDAO{

	@Override
	public void inserir(Usuario u) {

		try( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera",
				"postgres", "postgres")){
			
			String sql = "INSERT INTO public.usuario (login, email, nome, senha, pontos) "+
			"VALUES(?, ?, ?, ?, ?)";
								
			PreparedStatement stm = connection.prepareStatement(sql);
			
                        stm.setString(1, u.getLogin());
			stm.setString(2, u.getEmail());
			stm.setString(3, u.getNome());
			stm.setString(4, u.getSenha());
			stm.setInt(5, u.getPontos());
			stm.executeUpdate();						
		}catch(SQLException e){
			throw new RuntimeException("Erro: " + e.getMessage());
		}
		
	}

	@Override
	public Usuario recuperar(String login) {

		String sql = "SELECT * FROM usuario WHERE login = ?";
		try( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera",
				"postgres", "postgres")){
			
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, login);
			ResultSet rs = stm.executeQuery();
			Usuario u = new Usuario();
			
			while(rs.next())
			{
				u.setLogin(rs.getString("login"));
				u.setEmail(rs.getString("email"));
				u.setNome(rs.getString("nome"));
				u.setSenha(rs.getString("senha"));
				u.setPontos(rs.getInt("pontos"));
			}
			
			return u;
			
		}catch(SQLException e){
			throw new RuntimeException("Erro: " + e.getMessage());
		}
		
	}

	@Override
	public void adicionarPontos(String login, int pontos) {

		String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?";
		try( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera",
				"postgres", "postgres")){
			
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(2, login);
			stm.setInt(1, pontos);
			stm.executeUpdate();
			System.out.println("Pontos adicionados.");
			
		}catch(SQLException e){
			throw new RuntimeException("Erro: " + e.getMessage());
		}
		
	}

	@Override
	public List<Usuario> ranking() {

		List<Usuario> listaOrdenada = new ArrayList<>();
		String sql = "SELECT * FROM usuario ORDER BY pontos DESC;";
		try( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera",
				"postgres", "postgres")){
			
			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next())
			{
				listaOrdenada.add(new Usuario(rs.getString("nome"), rs.getString("email"), rs.getString("login"),
						rs.getString("senha"), rs.getInt("pontos")));
			}
			
		}catch(SQLException e){
			throw new RuntimeException("Erro: " + e.getMessage());
		}
		return listaOrdenada;
	}

}
