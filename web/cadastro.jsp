<%-- 
    Document   : cadastro
    Created on : 18/07/2017, 11:13:32
    Author     : Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
    </head>
    <body>
        <h1>Insira os dados abaixo: </h1>
        <form method="POST" action="CadastroServlet">
            Login: <input type="text" name="login" />
            Senha: <input type="password" name="senha" />
            Nome: <input type="text" name="nome" />
            Email: <input type="email" name="email" />
            <input type="submit" name="cadastrar" value="Ok" />
        </form>
    </body>
</html>
