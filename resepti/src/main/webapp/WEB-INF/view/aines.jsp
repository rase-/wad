<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ainekset</title>
    </head>
    <body>
        <h2>Ainekset</h2>
        <c:forEach var="aines" items="${ainekset}">
            <a href="${pageContext.request.contextPath}/aines/${aines.id}">${aines.nimi}</a> <br />
        </c:forEach>
        <h2>Lisää aines</h2>
        <form:form commandName="aines" action="${pageContext.request.contextPath}/aines" method="POST">
            <form:input path="nimi" /><form:errors path="nimi" />
            <input type="submit" />
        </form:form>
    </body>
</html>
