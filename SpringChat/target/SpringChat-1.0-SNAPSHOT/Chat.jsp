<%-- 
    Document   : Chat
    Created on : 17.1.2012, 10:11:27
    Author     : tonykova
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat</title>
    </head>
    <body>
        <strong>Chat</strong><br />
        <form:form commandName="viesti" action = "${pageContext.request.contextPath}/Chat" method = "POST">
            <form:input path = "viesti" /><form:errors path="viesti" /><br />
            <input type="submit">
            
        </form:form>
        
        <strong>Viestit</strong> <br />
        <c:forEach var="var" items="${viestit}">
            ${var.tunnus}: ${var.viesti} <br />
        </c:forEach>
        <a href="${contextPath}/Logout"> kirjaudu ulos </a>
    </body>
</html>
