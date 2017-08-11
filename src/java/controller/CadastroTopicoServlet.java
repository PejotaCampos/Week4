package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Topico;
import model.Usuario;
import tratador.TratadorTopico;
import tratador.TratadorUsuario;

/**
 *
 * @author Pedro
 */
@WebServlet(name = "CadastroTopicoServlet", urlPatterns = {"/topicos"})
public class CadastroTopicoServlet extends HttpServlet {

    private final TratadorTopico topicoManager = new TratadorTopico();
    private final TratadorUsuario userManager = new TratadorUsuario();
  
    /*NAVEGA ATÉ A PAGINA LISTA DE TOPICOS*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("topicos.jsp").forward(request, response);
  
    }

    /*CADASTRA UM TOPICO E VAI PARA A TELA DA LISTA DE TOPICOS*/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String titulo = request.getParameter("titulo");
        String conteudo = request.getParameter("conteudo");
        Usuario u = (Usuario) request.getSession().getAttribute("dadosUsuario");
        String login = u.getLogin();
        
        Topico t = new Topico(titulo, conteudo, login);
        topicoManager.cadastraTopico(t);
        userManager.addPonto(login, 10);
        
        request.getServletContext().setAttribute("topicos", topicoManager.topicos());
        request.getRequestDispatcher("topicos.jsp").forward(request, response);
    }

}
