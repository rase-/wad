<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="osallistu" method="POST">
        <span>Nimi: <input type="text" name="nimi" ></span><br>
        <span>Email: <input type="text" name="email" ></span><br>
        <span>Saa mainostaa jatkossa: <input type="checkbox" name="osallistuuKilpailuun" ></span><br>
        <input type="submit">
    </form>
    </body>
</html>
