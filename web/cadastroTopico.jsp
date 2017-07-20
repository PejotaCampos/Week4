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
            <table border="3" id="topico">
                <tr>
                    <td width="890" height="20"><input type="text" name="titulo" title="Título" size="123" placeholder="Título"/></td>                    
                </tr>
                <tr>
                    <td width="890" height="350"><textarea name="conteudo" rows="25" cols="124" placeholder="Digite aqui..."></textarea></td>
                </tr>                
            </table>
            
            <input type="submit" name="cadastrarTopico" value="Ok" />
        </form>
    </body>
</html>
