<%-- 
    Document   : index
    Created on : Jan 14, 2012, 12:56:32 PM
    Author     : tonykovanen
--%>

<%@page contentType="text/html" pageEncoding="x-MacIceland"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=x-MacIceland">
        <meta http-equiv="refresh" content="0;url=${pageContext.request.requestURI}AwesomeServlet">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p><a href="http://localhost:8080/eka-servlet/AwesomeServlet">Awesome servlet</a></p>
        <form method="POST" action="http://localhost:8080/eka-servlet/AwesomeServlet">
            <label> Käyttäjätunnus: <input type="text" name="käyttäjätunnus"></label>
            <label> Salsana: <input type="password" name="salanana"></label>
            <input type="submit">
        </form>
    </body>
</html>
