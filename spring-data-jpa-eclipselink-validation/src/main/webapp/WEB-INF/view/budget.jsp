<%-- 
    Document   : budget
    Created on : Feb 12, 2012, 10:48:55 AM
    Author     : tonykovanen
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Budgets</title>
    </head>
    <body>
        <h2>Budgets</h2>
        <c:forEach var="budget" items="${budgets}">
            ${budget.team.name}: ${budget.vuosi} ${budget.summa}
        </c:forEach>
        <h2>Add a budget</h2>
        <form:form commandName="budget" action="${pageContext.request.contextPath}/budget" method="POST">
            Vuosi: <form:input path="vuosi" /><form:errors path="vuosi" />
            Summa: <form:input path="summa" /><form:errors path="summa" />
            <select name="teamId">
                <c:forEach var="team" items="${teams}">
                    <option value="${team.id}">${team.name}</option>
                </c:forEach>
            </select>
            <input type="submit">
        </form:form>
    </body>
</html>
