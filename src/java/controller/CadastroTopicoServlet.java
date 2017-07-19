/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Topico;
import model.Usuario;
import tratador.TratadorComentario;
import tratador.TratadorTopico;

/**
 *
 * @author Pedro
 */
@WebServlet(name = "CadastroTopicoServlet", urlPatterns = {"/CadastroTopicoServlet"})
public class CadastroTopicoServlet extends HttpServlet {

    private final TratadorTopico topicoManager = new TratadorTopico();
    private final TratadorComentario comentarioManager = new TratadorComentario();
  
    /*NAVEGA ATÉ A PAGINA EXIBIR TOPICOS*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        request.getSession().setAttribute("topicoAtual", topicoManager.recuperar(id));
        request.getSession().setAttribute("comentariosAtuais", comentarioManager.comentarios(id));
        request.getRequestDispatcher("exibeTopico.jsp").forward(request, response);
  
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
        request.getServletContext().setAttribute("topicos", topicoManager.topicos());
        request.getRequestDispatcher("topicos.jsp").forward(request, response);
    }

}
