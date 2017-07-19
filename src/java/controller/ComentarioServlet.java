/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ComentarioDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Comentario;
import model.Topico;
import tratador.TratadorComentario;

/**
 *
 * @author Pedro
 */
@WebServlet(name = "ComentarioServlet", urlPatterns = {"/ComentarioServlet"})
public class ComentarioServlet extends HttpServlet {

    /*CADASTRA UM COMENTARIO*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String comentario = request.getParameter("textoComentado");
        Topico t = (Topico) request.getSession().getAttribute("topicoAtual");
        System.out.println("Login: "+t.getLogin()+"\ncomentario: "+comentario);
        TratadorComentario comentarioManager = new TratadorComentario();
        comentarioManager.inserir(t.getLogin(), comentario, t.getId());
    }

}
