<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course addition</title>
    </head>
    <body>
        <h1>Le home de admin.</h1>
        <h2>Add a course</h2>
        <form:form commandName="course" action="${pageContext.request.contextPath}/admin/course" method="POST">
            Course name: <form:input path="name" /><form:errors path="name" /> <br />
            <input type="submit"/>
        </form:form>
        <p><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></p>
    </body>
</html>
