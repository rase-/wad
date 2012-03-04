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
        <h1>Le home de admin.</h1>
        <h2>Add a student</h2>
        <form:form commandName="studentform" action="${pageContext.request.contextPath}/admin/home" method="POST">
            Student name: <form:input path="name" /><form:errors path="name" /> <br />
            Student username <form:input path="username" /><form:errors path="username" /> <br />
            Student password <form:input path="password" /><form:errors path="password" /><br />
            <input type="submit"/>
        </form:form>
        <a href="${pageContext.request.contextPath}/admin/course">Add a course</a>
        <p><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></p>
    </body>
</html>
