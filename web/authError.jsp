<%-- 
    Document   : authError
    Created on : 18/07/2017, 12:39:18
    Author     : Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <form method="POST" action="LoginServlet">
            <h1>Entre com as informações abaixo.</h1>
            Login: <input type="text" name="login" />
            Senha: <input type="password" name="senha" />
            <input type="submit" name="logar" value="Ok" />
        </form>
        <h3 style="color: red">${erro}</h3>
        <form method="GET" action="LoginServlet">
            <input type="submit" name="cadastro" value="Cadastrar" />
        </form>
    </body>
</html>
