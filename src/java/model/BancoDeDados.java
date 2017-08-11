package model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Pedro
 */
/*
 * Classe responsável por carregar o driver do postgres e criar as tabelas do banco.
 * Considerando que já existe um database local chamado coursera.*/

public class BancoDeDados {
	
	static{
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Carregado!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
        public static void initialize(){
            criarTabela();
            criarTopicos();
            criarComentarios();
        }
        
	//Se a tabela 'usuario' não existe, então esse método a cria.
	private static void criarTabela(){
		try( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera",
				"postgres", "postgres")){
			
			String script = "CREATE TABLE public.usuario"+
					"("+
					  "login text NOT NULL,"+
					  "email text,"+
					  "nome text,"+
					  "senha text,"+
					  "pontos integer,"+
					  "CONSTRAINT usuario_pkey PRIMARY KEY (login)"+
					")";
					
			System.out.println(script);
			boolean criada = existeTabela();
			
			Statement stm = connection.createStatement();
			if(!criada){
				stm.execute(script);
				System.out.println("Tabela Usuarios criada.");
			}else{
				System.out.println("Tabela Usuarios já existe.");
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
        
        private static void criarTopicos(){
            try( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera",
				"postgres", "postgres")){
			
            String script = "CREATE SEQUENCE topico_id_topico_seq" +
                            "  INCREMENT 1" +
                            "  MINVALUE 1" +
                            "  MAXVALUE 9223372036854775807" +
                            "  START 1" +
                            "  CACHE 1;" +
                            "\n" +
                            "CREATE TABLE public.topico" +
                            "(" +
                            "  id_topico integer NOT NULL DEFAULT nextval('topico_id_topico_seq'::regclass)," +
                            "  titulo text," +
                            "  conteudo text," +
                            "  login text," +
                            "  CONSTRAINT topico_pkey PRIMARY KEY (id_topico)," +
                            "  CONSTRAINT topico_login_fkey FOREIGN KEY (login)" +
                            "      REFERENCES usuario (login) MATCH SIMPLE" +
                            "      ON UPDATE NO ACTION ON DELETE NO ACTION" +
                            ");";
					
            System.out.println(script);
            boolean criada = existeTabelaT();
		
            Statement stm = connection.createStatement();
            
            if(!criada){
		stm.execute(script);
		System.out.println("Tabela Topico criada.");
            }else{
		System.out.println("Tabela Topico já existe.");
            }
			
			
            }catch(SQLException e){
		throw new RuntimeException("Erro: " + e.getMessage());
            }
	}
        
        private static void criarComentarios(){
            
		try( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera",
				"postgres", "postgres")){
			
		String script = "CREATE SEQUENCE comentario_id_comentario_seq" +
                                "  INCREMENT 1" +
                                "  MINVALUE 1" +
                                "  MAXVALUE 9223372036854775807" +
                                "  START 1" +
                                "  CACHE 1;" +
                                "CREATE TABLE public.comentario" +
                                "(" +
                                "  id_comentario integer NOT NULL DEFAULT nextval('comentario_id_comentario_seq'::regclass)," +
                                "  comentario text," +
                                "  login text," +
                                "  id_topico integer," +
                                "  CONSTRAINT comentario_pkey PRIMARY KEY (id_comentario)," +
                                "  CONSTRAINT comentario_id_topico_fkey FOREIGN KEY (id_topico)" +
                                "      REFERENCES topico (id_topico) MATCH SIMPLE" +
                                "      ON UPDATE NO ACTION ON DELETE NO ACTION," +
                                "  CONSTRAINT comentario_login_fkey FOREIGN KEY (login)" +
                                "      REFERENCES usuario (login) MATCH SIMPLE" +
                                "      ON UPDATE NO ACTION ON DELETE NO ACTION" +
                                ")";
					
			System.out.println(script);
			boolean criada = existeTabelaC();
			
			Statement stm = connection.createStatement();
			if(!criada){
				stm.execute(script);
				System.out.println("Tabela Comentarios criada.");
			}else{
				System.out.println("Tabela Comentarios já existe.");
			}
			
			
		}catch(SQLException e){
                    throw new RuntimeException("Erro: " + e.getMessage());
		}
	}
	
	//Método que verifica se a tabela usuário já existe.
	private static boolean existeTabela(){
		
		try( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera",
				"postgres", "postgres")){
			
			DatabaseMetaData dbm = connection.getMetaData();
			ResultSet table = dbm.getTables(null, null, "usuario", null);
			if (table.next()) {
				return true;
			}else {
				return false;
			}
						
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
		
	}
        
        private static boolean existeTabelaT(){
		
		try( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera",
				"postgres", "postgres")){
			
			DatabaseMetaData dbm = connection.getMetaData();
			ResultSet table = dbm.getTables(null, null, "topico", null);
			if (table.next()) {
				return true;
			}else {
				return false;
			}
						
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
		
	}
        
        private static boolean existeTabelaC(){
		
		try( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera",
				"postgres", "postgres")){
			
			DatabaseMetaData dbm = connection.getMetaData();
			ResultSet table = dbm.getTables(null, null, "comentario", null);
			if (table.next()) {
				return true;
			}else {
				return false;
			}
						
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
		
	}
        
    public static void delete(){
        String deleteComents = "DROP TABLE public.comentario";
        String deleteTopico = "DROP TABLE public.topico";
        String deleteUsuario = "DROP TABLE public.usuario";
        String deleteSeqComents = "DROP SEQUENCE public.comentario_id_comentario_seq";
        String deleteSeqTopicos = "DROP SEQUENCE public.topico_id_topico_seq";
        
	try( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera",
				"postgres", "postgres")){	
            PreparedStatement stm = connection.prepareStatement(deleteComents);
            stm.executeUpdate();
            stm = connection.prepareStatement(deleteTopico);
            stm.executeUpdate();
            stm = connection.prepareStatement(deleteUsuario);
            stm.executeUpdate();
            
            stm = connection.prepareStatement(deleteSeqComents);
            stm.executeUpdate();
            
            stm = connection.prepareStatement(deleteSeqTopicos);
            stm.executeUpdate();
	}catch(SQLException e){
            throw new RuntimeException("Erro: " + e.getMessage());
	}
    }

}

