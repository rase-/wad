<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reseptit</title>
    </head>
    <body>
        <h2>Reseptit</h2>
        <c:forEach var="resepti" items="${reseptit}">
            <a href="${pageContext.request.contextPath}/resepti/${resepti.id}">${resepti.nimi}</a> <br />
        </c:forEach>
        <h2>Lisää resepti</h2>
        <form:form commandName="resepti" action="${pageContext.request.contextPath}/resepti" method="POST">
            <form:input path="nimi" /><form:errors path="nimi" />
            <input type="submit" />
        </form:form>
    </body>
</html>
