<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Le home de student.</h1>
        <h2>Your information</h2>
        <form:form commandName="studentform" action="${pageContext.request.contextPath}/student/home" method="POST">
            ${student.username} <br />
            ${student.name}, muuta: <form:input path="name" /><form:errors path="name" /><br />
            ${student.password}, muuta: <form:input path="password" /><form:errors path="password" /><br />
            <input type="submit" />
        </form:form>
        <p><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></p>
    </body>
</html>
