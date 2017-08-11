package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tratador.TratadorUsuario;

/**
 *
 * @author Pedro
 */
@WebServlet(name = "CadastroServlet", urlPatterns = {"/cadastro"})
public class CadastroServlet extends HttpServlet {

    //ESTA NA TELA DE LISTA TOPICOS E VAI PARA TELA DE ADD TOPICO
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("cadastroTopico.jsp").forward(request, response);
    }

    //TELA DE CADASTRO DE USUARIO, VAI PARA A TELA INICIAL (LOGIN)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        TratadorUsuario userManager = new TratadorUsuario();
        userManager.cadastra(request.getParameter("login"), request.getParameter("senha"),
                             request.getParameter("nome"), request.getParameter("email"));
        
        request.getRequestDispatcher("index.html").forward(request, response);
    }

}
