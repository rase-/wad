<%-- 
    Document   : leffat
    Created on : Feb 5, 2012, 1:48:21 PM
    Author     : tonykovanen
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Genret</title>
    </head>
    <body>
        <h2>Lisää genre</h2>
        <form action="lisaaGenre" method="POST">
            Genren nimi: <input type="text" name="nimi"><br/>
            <input type="submit" value="Lisää">            
        </form>
        <h2>Genret</h2>
        <ul>
            <c:forEach var = "genre" items="${genret}">
                ${genre.nimi}
                <br />
            </c:forEach>
        </ul>
    </body>
</html>
