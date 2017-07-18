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
        <ul>
            <c:forEach var="topico" items= "${topicos}" >
            <li>${topico.titulo}</li>
            </c:forEach>
        </ul>
        
        <form action="CadastroServlet" method="GET">
            <input type="submit" name="addTopico" value="Adicionar">
        </form>
    </body>
</html>
