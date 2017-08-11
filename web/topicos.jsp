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
        
        <style>
            table, td, th {border: 2px solid black ; padding: 10px}
            .center {text-align: center }
        </style>
        
    </head>
    <body>
        <h1>Bem vindo ${dadosUsuario.nome}</h1>
        
        <table border="1" width="500">
            <thead> <th><b>TÍTULO</b></th> <th><b>LOGIN</b></th> </thead>
        
            <tbody>
                <c:forEach var="topico" items= "${topicos}" >
                <tr>
                    <td width="262"><a href="exibeTopico?id=${topico.id}" >${topico.titulo} </a> </td>
                    <td width="248" class="center">${topico.login}</td>
                </tr>
                </c:forEach>
            </tbody>
            
        </table>
        
        <div style="position: relative; top:10px">
        <form action="cadastro" method="GET">
            <input type="submit" name="addTopico" value="Adicionar">
        </form>
        </div>
        
        <div style="position: relative; top: -11px ; left: 150px">
        <form action="ranking" method="POST">
            <input type="submit" name="ranking" value="Ranking">
        </form>
        </div>
    </body>
</html>
