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
        <title>Elokuvat</title>
    </head>
    <body>
        <h2>Lisää elokuva</h2>
        <form action="lisaa" method="POST">
            Elokuvan nimi: <input type="text" name="nimi"><br/>
            Elokuvan kesto (likulukuna): <input type="text" name="pituus"><br/>
            Elokuvan valmistumisvuosi: <input type= "text" name ="vuosi"><br />
            <input type="submit" value="Lisää">            
        </form>
        <h2>Elokuvat</h2>
        <ul>
            <c:forEach var = "elokuva" items="${elokuvat}">
                ${elokuva.id}: ${elokuva.nimi}, kesto ${elokuva.pituus}, ${elokuva.vuosi}
                Genret: <c:forEach var="genre" items="${elokuva.genret}">${genre.nimi} </c:forEach>
                <br />
            </c:forEach>
        </ul>
    </body>
</html>
