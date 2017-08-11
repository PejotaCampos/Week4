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
        <style>
            .btStyle {background: lightblue ; border-color: black}
        </style>
    </head>
    <body style="background: grey">
        <form method="POST" action="login">
            <h1>Entre com as informações abaixo.</h1>
            Login: <input type="text" name="login" />
            Senha: <input type="password" name="senha" />
            <input type="submit" name="logar" value="Ok" class="btStyle"/>
        </form>
        <h3 style="color: darkred">${erro}</h3>
        <form method="GET" action="login">
            <input type="submit" name="cadastro" value="Cadastrar" class="btStyle"/>
        </form>
    </body>
</html>
