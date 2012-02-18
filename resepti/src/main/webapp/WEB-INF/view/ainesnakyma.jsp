<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aines</title>
    </head>
    <body>
        <h2>${aines.nimi} kuuluu resepteihin</h2>
        <c:forEach var="resepti" items="${aines.reseptit}">
            ${resepti.nimi} <br />
        </c:forEach>
        
    </body>
</html>
