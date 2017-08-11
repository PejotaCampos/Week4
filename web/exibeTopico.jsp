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
        <style>
            table, td, th {border: 2px solid black ; padding: 10px; background: seagreen}
            td {background: lightskyblue}
            .btStyle {background: lightblue ; border-color: black}
        </style>
    </head>
    <body style="background: grey">
        <form action="exibeTopico" method="POST">
            
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
           
           <div style="position: relative; top: 20px">
            <table border="3" id="tbComents">
                <thead><th>Comentários</th></thead>
                <c:forEach var="comentario" items= "${comentariosAtuais}" >
                <tr>
                    <td><b>${comentario.login} escreveu:</b> ${comentario.comentario}</td>
                </tr>
                </c:forEach>
            </table>
           </div>
             
            <div style="position: relative; top: 15px">
                <h4> Inserir Comentário </h4>
            </div>
            <textarea rows="4" cols="120" title="Comentário..." name="textoComentado"></textarea>
            <input type="submit" name="comentar" value="Enviar" class="btStyle" />
        </form>
                
                <a href="topicos">Voltar aos topicos</a>
        
    </body>
</html>
