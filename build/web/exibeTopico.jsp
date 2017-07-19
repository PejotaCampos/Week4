<%-- 
    Document   : exibeTopico
    Created on : 18/07/2017, 22:57:38
    Author     : Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Topico</title>
    </head>
    <body>
        <form action="ComentarioServlet" method="POST">
            
            Título: <h1>${topicoAtual.titulo}</h1>
            Conteudo: <h1>${topicoAtual.conteudo}</h1>
            Login: <h1 name="login">${topicoAtual.login}</h1>
        
            <div hidden="true" name="idT">${topicoAtual.id}</div>
            <textarea rows="4" cols="60" title="Comentário..." name="textoComentado"></textarea>
            <input type="submit" name="comentar" value="Enviar" />
        </form>
        
    </body>
</html>
