<%-- 
    Document   : exibeTopico
    Created on : 18/07/2017, 22:57:38
    Author     : Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Topico</title>
    </head>
    <body>
        <form action="ComentarioServlet" method="POST">
            
            <table border="3" id="topico">
                <tr>
                    <td width="890" height="20"><h1><b>${topicoAtual.titulo}</b></h1></td>                    
                </tr>
                <tr>
                    <td width="890" height="20"><h5>Autor: ${topicoAtual.login}</h5></td>                    
                </tr>                
                <tr>
                    <td width="890" height="350">Conteudo do topico: ${topicoAtual.conteudo}</td>
                </tr>                
            </table>
                        
                <h6>Comments</h6>
            <table border="3" id="tbComents">
                <c:forEach var="comentario" items= "${comentariosAtuais}" >
                <tr>
                    <td><textarea rows="4" cols="60">${comentario.login} escreveu: </textarea></td>
                    <td><textarea rows="4" cols="60">${comentario.comentario}</textarea></td>
                </tr>
                </c:forEach>
            </table>
             
                <h6> Inserir Comentário </h6>
            <textarea rows="4" cols="120" title="Comentário..." name="textoComentado"></textarea>
            <input type="submit" name="comentar" value="Enviar" />
        </form>
        
    </body>
</html>
