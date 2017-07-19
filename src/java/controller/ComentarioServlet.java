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
import model.Usuario;
import tratador.TratadorComentario;

/**
 *
 * @author Pedro
 */
@WebServlet(name = "ComentarioServlet", urlPatterns = {"/ComentarioServlet"})
public class ComentarioServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
    }

    /*CADASTRA UM COMENTARIO E VOLTA PARA O EXIBIR TOPICO (COM LISTA DE COMENTARIOS ATUALIZADA)*/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String comentario = request.getParameter("textoComentado");
        Topico t = (Topico) request.getSession().getAttribute("topicoAtual");
        System.out.println("Login: "+t.getLogin()+"\ncomentario: "+comentario);
        TratadorComentario comentarioManager = new TratadorComentario();
        Usuario u = (Usuario)request.getSession().getAttribute("dadosUsuario");
        comentarioManager.inserir(u.getLogin(), comentario, t.getId());
        request.getSession().setAttribute("comentariosAtuais", comentarioManager.comentarios(t.getId()));
        request.getRequestDispatcher("exibeTopico.jsp").forward(request, response);
    }

}
