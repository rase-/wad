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
        <title>Henkilonakyma</title>
    </head>
    <body>
        <h1>Henkilö</h1>
        ${henkilo.nimi}: osoite: ${henkilo.osoite}, puhelinnumero: ${henkilo.puhelinnumero} <br />
        huone: ${huone.id}, ${huone.kerros} kerros, kapasiteetti: ${huone.kapasiteetti}
    </body>
</html>
