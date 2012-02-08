<%-- 
    Document   : asunnot
    Created on : 8.2.2012, 9:07:04
    Author     : tonykova
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Asunnot</title>
    </head>
    <body>
        <h2>Asunnot</h2>
        <c:forEach var="asunto" items="${asunnot}">
            ${asunto.henkilo.nimi}, ${asunto.henkilo.sahkoposti}, ${asunto.henkilo.puhelinnumero}: ${asunto.osoite}, ${asunto.postinumero} ${asunto.kaupunki}, rakennettu ${asunto.vuosi}, ${asunto.koko} neliötä, kunto ${asunto.kunto}
        </c:forEach>
        <h2>Lisää asunto</h2>
        <form:form commandName="lomake" action="${pageContext.request.contextPath}/asunnot" method="POST">
            Myyjän nimi: <form:input path="nimi"/><form:errors path="nimi"/> <br />
            Myyjän puhelinnumero: <form:input path="puhelinnumero"/><form:errors path="puhelinnumero"/> <br />
            Myyjän sähköpostiosoite: <form:input path="sahkopostiosoite"/><form:errors path="sahkopostiosoite"/><br />
            Asunnon koko (kokonaisluku, neliömetreinä): <form:input path="koko"/><form:errors path="koko"/><br />
            Asunnon postinumero: <form:input path="postinumero"/><form:errors path="postinumero"/><br />
            Asunnon kaupunki: <form:input path="kaupunki"/><form:errors path="kaupunki"/><br />
            Asunnon katuosoite: <form:input path="osoite"/><form:errors path="osoite"/><br />
            Asunnon rakennusvuosi: <form:input path="vuosi"/><form:errors path="vuosi"/><br />
            Asunnon kunto <br />
            Hyvä <form:radiobutton path = "kunto" value = "hyvä"></form:radiobutton><br />
            Keskiverto <form:radiobutton path = "kunto" value = "keskiverto"></form:radiobutton><br />
            Huono <form:radiobutton path = "kunto" value = "huono"></form:radiobutton><br />
            Remontoitava <form:radiobutton path = "kunto" value = "remontoitava"></form:radiobutton><br />
            <input type="submit" value="Lähetä" />
        </form:form>
    </body>
</html>
