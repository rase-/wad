<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Olut</title>
    </head>
    <body>
        <h1>Lisää olut</h1>

        <form action="olut" method="POST">
            Oluen nimi: <input type="text" name="name"><br/>
            <input type="submit" value="Lisää">            
        </form>

        <h2>Oluet</h2>
        <ul>
            <c:forEach var="olut" items="${oluet}">
                <li>${olut.name}</li>
            </c:forEach>
        </ul>
    </body>
</html>