<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Varasto</title>
    </head>
    <body>
        <h1>Huoneet</h1>

        <h2>Lisää huone</h2>
        <form action="lisaa" method="POST">
            Huoneen kerrokset: <input type="text" name="kerros"><br/>
            Huoneen kapasiteetti (kokonaislukuna): <input type="text" name="kapasiteetti"><br/>
            <input type="submit" value="Lisää">            
        </form>

        <h2>Huoneet</h2>
        <ul>
            <c:forEach var="huone" items="${huoneet}">
                <li>${huone.id}, kerros ${huone.kerros}, kapasiteetti ${huone.kapasiteetti}<a href="poista/${huone.id}">poista</a></li>
            </c:forEach>
        </ul>
        
    </body>
</html>
