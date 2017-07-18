<%-- 
    Document   : cadastroTopico
    Created on : 18/07/2017, 15:19:27
    Author     : Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar tópico</title>
    </head>
    <body>
        <form method="POST" action="CadastroTopicoServlet">
            Titulo: <input type="text" name="titulo" />
            Conteudo: <input type="text" size="600" name="conteudo" />
            <input type="submit" name="cadastrarTopico" value="Ok" />
        </form>
    </body>
</html>
