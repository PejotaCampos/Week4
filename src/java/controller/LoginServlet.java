/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("cadastro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        TratadorUsuario userManager = new TratadorUsuario();
        TratadorTopico topicoManager = new TratadorTopico();
        Usuario u = userManager.autenticar(request.getParameter("login"), request.getParameter("senha"));
        
        if(u != null){
            request.getSession().setAttribute("dadosUsuario", u);
            List<Topico> topicos = topicoManager.topicos();
            request.getServletContext().setAttribute("topicos", topicos );
            request.getRequestDispatcher("topicos.jsp").forward(request, response);
        }else{
            request.setAttribute("erro", "Erro na autenticação.");
            request.getRequestDispatcher("authError.jsp").forward(request, response);
        }
    }

}
