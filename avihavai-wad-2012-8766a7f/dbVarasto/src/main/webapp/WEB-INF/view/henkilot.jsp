<%-- 
    Document   : henkilot
    Created on : Feb 3, 2012, 9:21:03 PM
    Author     : tonykovanen
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Henkilot</title>
    </head>
    <body>
        <h2>Lisää henkilo</h2>
        <form action="lisaaHenkilo" method="POST">
            Henkilon nimi: <input type="text" name="nimi"><br/>
            Henkilon osoite: <input type="text" name="osoite"><br/>
            Henkilon puhelinnumero: <input type="text" name="puhelinnumero"><br/>
            <input type="submit" value="Lisää">            
        </form>
        <h2>Henkilot</h2>
        <ul>
            <c:forEach var="henkilo" items="${henkilot}">
                
                <li>${henkilo.nimi}, osoite: ${henkilo.osoite}, puhelinnumero: ${henkilo.puhelinnumero} <a href="poistaHenkilo/${henkilo.nimi}">poista</a></li>
            </c:forEach>
        </ul>
    </body>
</html>
