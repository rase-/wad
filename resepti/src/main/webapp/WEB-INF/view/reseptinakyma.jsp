<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resepti</title>
    </head>
    <body>
        <a href="${pageContext.request.contextPath}/poista/${resepti.id}">poista</a> <br/>
        <h2>${resepti.nimi}</h2>
        <c:forEach var="aines" items="${resepti.ainekset}">
            ${aines.nimi} <br />
        </c:forEach>
        <h2>Lisää aines reseptiin</h2>
        <form:form commandName="resepti" action="${pageContext.request.contextPath}/resepti/${resepti.id}" method="POST">
            <select name="ainesId">
                <c:forEach var="aines" items="${ainekset}">
                    <option value="${aines.id}">${aines.nimi}</option>
                </c:forEach>
            </select>
            <input type="submit">
        </form:form>
    </body>
</html>
