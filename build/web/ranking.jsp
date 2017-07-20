<%-- 
    Document   : ranking
    Created on : 19/07/2017, 19:22:49
    Author     : Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ranking</title>
    </head>
    <c:set var="pos" value="1" />
    <table title="RAKING" border="1" >
        <tr>
                <td>POSICAO</td> <td>LOGIN</td>   <td>PONTUACAO</td>   
        </tr>
        <c:forEach var="user" items= "${ranking}" >
            <tr>
                 <td>${pos}</td> <td>${user.login}</td>   <td>${user.pontos} Pts</td>  
            </tr>
            <c:set var="pos" value="${pos+1}"/>
        </c:forEach>
    </table>
    
    <a href="ComentarioServlet">Voltar aos topicos</a>
    
</html>
