/*
 * NÃO FORAM FEITOS TESTES NA CLASSE USUARIO, 
 * POIS ELA FOI TESTADA NA WEEK 3
 */

import org.dbunit.JdbcDatabaseTester;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import dao.ComentarioDAOImpl;
import dao.TopicoDAOImpl;
import dao.UsuarioDAOImpl;
import java.sql.SQLException;
import java.util.List;
import model.BancoDeDados;
import model.Comentario;
import model.Topico;
import model.Usuario;
import org.dbunit.Assertion;
import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.junit.After;

/**
 *
 * @author Pedro
 */
public class TesteUnidadeBanco {
    
    public TesteUnidadeBanco() {
    }
    JdbcDatabaseTester jdt;
	private UsuarioDAOImpl userManager; 
        private TopicoDAOImpl topicoManager;
        private ComentarioDAOImpl comentarioManager;
	
	@Before
	public void setUp() throws Exception {
            BancoDeDados.initialize();
            
		jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/coursera",
				"postgres","postgres");
               		
		userManager = new UsuarioDAOImpl();
                topicoManager = new TopicoDAOImpl();
                comentarioManager = new ComentarioDAOImpl();                        
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jdt.setDataSet(loader.load("/inicio.xml"));
                
		jdt.onSetup();
	}
        
        //TESTE DE INSERÇÃO EM TODAS AS TABELAS
	@Test
	public void insercaoComentarioBanco() throws Exception {
            
            //CRIA INSTANCIAS
            Comentario comentario = new Comentario("maria", "insere comentario");
            comentario.setId_topico(1);
                            
            //INSERE NO BANCO
            comentarioManager.inserir(comentario);
                         
            /*PEGA ITABLES, NO TOPICO E COMENTARIO DESCONSIDERA OS IDS*/
            IDataSet currentDataSet = jdt.getConnection().createDataSet();            
            ITable currentTable = currentDataSet.getTable("COMENTARIO");            
            //ITable filteredCurrentTableC = DefaultColumnFilter.excludedColumnsTable(currentTableC, new String[]{"id_comentario"});
            //ITable filteredCurrentTableT = DefaultColumnFilter.excludedColumnsTable(currentTableT, new String[]{"id_topico"});
                
            FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
                
            IDataSet expectedDataSet = loader.load("/insercaoComentario.xml");         
                
            ITable expectedTable = expectedDataSet.getTable("COMENTARIO");
                
            Assertion.assertEquals(expectedTable, currentTable);
//            Assertion.assertEquals(filteredExpectedTableT, filteredCurrentTableT);
//            Assertion.assertEquals(filteredExpectedTableC, filteredCurrentTableC);
	}
        
        @Test
	public void buscaComentarios() throws Exception {
            
            FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
            jdt.setDataSet(loader.load("/inicioComentarios.xml"));
            jdt.onSetup();                   
             
            
            List<Comentario> comentarios = comentarioManager.recuperar(2);
            
            assertEquals(comentarios.size(), 3);
            assertEquals("comentarios.get(0).ID = "+comentarios.get(0).getId_comentario(),comentarios.get(0).getId_comentario(), 2);
            assertEquals("comentarios.get(1).ID = "+comentarios.get(1).getId_comentario(),comentarios.get(1).getId_comentario(), 3);
            assertEquals("comentarios.get(2).ID = "+comentarios.get(2).getId_comentario(),comentarios.get(2).getId_comentario(), 4);           
	}
        
        @Test
	public void insercaoTopicoBanco() throws Exception {
            
            //CRIA INSTANCIAS
            Topico topico = new Topico("Novo topico", "teste inserir topico", "maria");
                            
            //INSERE NO BANCO
            topicoManager.inserir(topico);
                         
            /*PEGA ITABLES, NO TOPICO E COMENTARIO DESCONSIDERA OS IDS*/
            IDataSet currentDataSet = jdt.getConnection().createDataSet();            
            ITable currentTable = currentDataSet.getTable("TOPICO");            
            //ITable filteredCurrentTableC = DefaultColumnFilter.excludedColumnsTable(currentTableC, new String[]{"id_comentario"});
            //ITable filteredCurrentTableT = DefaultColumnFilter.excludedColumnsTable(currentTableT, new String[]{"id_topico"});
                
            FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
                
            IDataSet expectedDataSet = loader.load("/insercaoTopico.xml");         
                
            ITable expectedTable = expectedDataSet.getTable("TOPICO");
                
            Assertion.assertEquals(expectedTable, currentTable);
//            Assertion.assertEquals(filteredExpectedTableT, filteredCurrentTableT);
//            Assertion.assertEquals(filteredExpectedTableC, filteredCurrentTableC);
	}
        
        @Test
	public void buscaTopico() throws Exception {

            Topico t = new Topico("teste insercao", "Inserido", "maria");
            topicoManager.inserir(t);
            Topico tRecuperado = topicoManager.recuperar(2);
            
            assertEquals(tRecuperado.getConteudo(), "Inserido");
            assertEquals(tRecuperado.getTitulo(), "teste insercao");
            assertEquals(tRecuperado.getLogin(), "maria");            
	}
        
        @Test
	public void buscaTopicos() throws Exception {
            
            FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
            jdt.setDataSet(loader.load("/inicioTopicos.xml"));
            jdt.onSetup();                                
            
            List<Topico> topicos = topicoManager.topicos();
            
            assertEquals(topicos.size(), 4);
            
            assertEquals(topicos.get(0).getId(), 1);
            assertEquals(topicos.get(1).getId(), 2);
            assertEquals(topicos.get(2).getId(), 3);
            assertEquals(topicos.get(3).getId(), 4);
            
            assertEquals(topicos.get(0).getLogin(), "maria");
            assertEquals(topicos.get(1).getLogin(), "pjcampos");
            assertEquals(topicos.get(2).getLogin(), "pjcampos");
            assertEquals(topicos.get(3).getLogin(), "maria");
	}
    
    @After
    public void delete() throws SQLException, DatabaseUnitException{
            BancoDeDados.delete();             
    }
}
