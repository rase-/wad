<%-- 
    Document   : elokuvanakyma
    Created on : Feb 5, 2012, 5:02:33 PM
    Author     : tonykovanen
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Elokuva</title>
    </head>
    <body>
        <h1>${elokuva.nimi}</h1>
        <h2>Kesto: ${elokuva.pituus}</h2>
        <h2>Julkaisuvuosi: ${elokuva.vuosi}</h2>
        <h2>Genret: </h2>
        <c:forEach var="genre" items="${genret}">${genre.nimi} </c:forEach>
    </body>
</html>
