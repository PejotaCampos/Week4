/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Topico;
import model.Usuario;
import tratador.TratadorTopico;

/**
 *
 * @author Pedro
 */
@WebServlet(name = "CadastroTopicoServlet", urlPatterns = {"/CadastroTopicoServlet"})
public class CadastroTopicoServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String titulo = request.getParameter("titulo");
        String conteudo = request.getParameter("conteudo");
        //Class user = request.getServletContext().getAttribute("dadosUsuario");
        Usuario u = (Usuario) request.getSession().getAttribute("dadosUsuario");
        String login = u.getLogin();
        TratadorTopico topicoManager = new TratadorTopico();
        
        Topico t = new Topico(titulo, conteudo, login);
        topicoManager.cadastraTopico(t);
        request.getServletContext().setAttribute("topicos", topicoManager.topicos());
        request.getRequestDispatcher("topicos.jsp").forward(request, response);
    }

}