<%-- 
    Document   : huonenakyma
    Created on : Feb 3, 2012, 11:07:03 PM
    Author     : tonykovanen
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Huonenakyma</title>
    </head>
    <body>
        <h1>Henkilöt huoneessa</h1>
        <ul>
            <c:forEach var = "henkilo" items="${henkilot}">
                <li>${henkilo.nimi}, osoite: ${henkilo.osoite}, puhelinnumero: ${henkilo.puhelinnumero} <a href="naytaHenkilo/${henkilo.nimi}">henkilön tiedot</a></li>
            </c:forEach>
        </ul>
    </body>
</html>
