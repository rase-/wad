<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Le home de casual person.</h1>
        <p><a href="student/home">Le home de student!</a></p>
        <p><a href="admin/home">Le home de admin!</a></p>
        <h2>Students</h2>
        <c:forEach var="student" items="${students}">
            ${student.name} <sec:authorize access="hasRole('lecturer')">, username: ${student.username}</sec:authorize><br />
        </c:forEach>
        <h2>Kurssit</h2>
        <c:forEach var="course" items="${courses}">
            ${course.name}, attending: ${course.attending}, lectured by: ${course.lecturer.name} <sec:authorize access="hasRole('student')"><a href="student/course/${course.id}">Sign up</a></sec:authorize> <br />
        </c:forEach>
    </body>
</html>
