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
import tratador.TratadorUsuario;

/**
 *
 * @author Pedro
 */
@WebServlet(name = "ComentarioServlet", urlPatterns = {"/exibeTopico"})
public class ComentarioServlet extends HttpServlet {
    
    private final TratadorUsuario userManager = new TratadorUsuario();
    private final TratadorComentario comentarioManager = new TratadorComentario();
    private final TratadorTopico topicoManager = new TratadorTopico();

    /*ESTA NA TELA LISTA DE TOPICOS E AO SELECIONAR UM TOPICO, O MOSTRA COM SEUS DEVIDOS COMENTARIOS*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        request.getSession().setAttribute("topicoAtual", topicoManager.recuperar(id));
        request.getSession().setAttribute("comentariosAtuais", comentarioManager.comentarios(id));
        request.getRequestDispatcher("exibeTopico.jsp").forward(request, response);
     
    }

    /*CADASTRA UM COMENTARIO E VOLTA PARA O EXIBIR TOPICO (COM LISTA DE COMENTARIOS ATUALIZADA)*/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String comentario = request.getParameter("textoComentado");
        Topico t = (Topico) request.getSession().getAttribute("topicoAtual");
        Usuario u = (Usuario)request.getSession().getAttribute("dadosUsuario");
        
        comentarioManager.inserir(u.getLogin(), comentario, t.getId());
        userManager.addPonto(u.getLogin(), 3);
        
        request.getSession().setAttribute("comentariosAtuais", comentarioManager.comentarios(t.getId()));
        request.getRequestDispatcher("exibeTopico.jsp").forward(request, response);
    }

}
