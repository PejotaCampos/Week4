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
        
        <style>
            table, td, th {border: 2px solid black ; padding: 10px; background: seagreen}
            td {background: lightskyblue ; text-align: center}
            .center {text-align: center }
            .btStyle {background: lightblue ; border-color: black}
        </style>
        
    </head>
    
    <body style="background: grey">
        
    <c:set var="pos" value="1" />
    <table title="RAKING" border="1" >
        
        <thead>
            <th>POSICAO</th> <th>LOGIN</th>   <th>PONTUACAO</th>   
        </thead>
        
        <tbody>
        <c:forEach var="user" items= "${ranking}" >
            <tr>
                 <td>${pos}</td> <td>${user.login}</td>   <td>${user.pontos} Pts</td>  
            </tr>
            <c:set var="pos" value="${pos+1}"/>
        </c:forEach>
        </tbody>
    </table>
    
    <a href="topicos">Voltar aos topicos</a>
    
    </body>    
</html>
