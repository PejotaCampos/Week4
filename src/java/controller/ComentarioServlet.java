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
import tratador.TratadorUsuario;

/**
 *
 * @author Pedro
 */
@WebServlet(name = "ComentarioServlet", urlPatterns = {"/ComentarioServlet"})
public class ComentarioServlet extends HttpServlet {
    
    private final TratadorUsuario userManager = new TratadorUsuario();

    /*ESTA NA TELA DO TOPICO COM COMENTARIOS E VOLTA PARA A LISTA DE TOPICOS*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("topicos.jsp").forward(request, response);
        
    }

    /*CADASTRA UM COMENTARIO E VOLTA PARA O EXIBIR TOPICO (COM LISTA DE COMENTARIOS ATUALIZADA)*/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String comentario = request.getParameter("textoComentado");
        Topico t = (Topico) request.getSession().getAttribute("topicoAtual");
        TratadorComentario comentarioManager = new TratadorComentario();
        Usuario u = (Usuario)request.getSession().getAttribute("dadosUsuario");
        comentarioManager.inserir(u.getLogin(), comentario, t.getId());
        userManager.addPonto(u.getLogin(), 3);
        request.getSession().setAttribute("comentariosAtuais", comentarioManager.comentarios(t.getId()));
        request.getRequestDispatcher("exibeTopico.jsp").forward(request, response);
    }

}
