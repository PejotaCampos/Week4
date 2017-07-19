<%-- 
    Document   : topicos
    Created on : 18/07/2017, 12:38:55
    Author     : Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Topicos</title>
    </head>
    <body>
        <h1>Bem vindo ${dadosUsuario.nome}</h1>
        <table border="1" width="500">
            <tr>
                <td width="238"><b>TÍTULO</b></td>
                <td width="262"><b>LOGIN</b></td>
            </tr>
        </table>
        <table border="1" width="500">
            <c:forEach var="topico" items= "${topicos}" >
                <tr width="250">
                    <td><a href="CadastroTopicoServlet?id=${topico.id}" >${topico.titulo} </a> </td>
                    <td>${topico.login}</td>
                </tr>
            </c:forEach>
        </table>
        
        <form action="CadastroServlet" method="GET">
            <input type="submit" name="addTopico" value="Adicionar">
        </form>
    </body>
</html>
