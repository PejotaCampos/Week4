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
@WebServlet(name = "RankingServlet", urlPatterns = {"/ranking"})
public class RankingServlet extends HttpServlet {
    
    private final TratadorUsuario userManager = new TratadorUsuario();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /*PEGA A LISTA DE RANKING E ENVIA PRA VIEW*/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("ranking", userManager.ranking());
        request.getRequestDispatcher("ranking.jsp").forward(request, response);

    }

}
