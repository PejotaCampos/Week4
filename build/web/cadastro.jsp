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
        <style>
            .btStyle {background: lightblue ; border-color: black}
        </style>
    </head>
    <body style="background: grey">
        <h1>Insira os dados abaixo: </h1>
        <form method="POST" action="cadastro">
            Login: <input type="text" name="login" />
            Senha: <input type="password" name="senha" />
            Nome: <input type="text" name="nome" />
            Email: <input type="email" name="email" />
            <input type="submit" name="cadastrar" value="Ok" class="btStyle"/>
        </form>
    </body>
</html>
