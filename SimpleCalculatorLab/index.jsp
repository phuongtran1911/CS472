<%-- 
    Document   : index
    Created on : May 4, 2019, 1:44:56 AM
    Author     : ThinkPad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="SimpleCalculator2">
            <input type="text" name="field21" value="${f21}"> +
            <input type="text" name="field22" value="${f22}"> =
            <input type="text" name="sum" value="${sum}"> <br>
            <br>
            <input type="text" name="field23" value="${f23}"> *
            <input type="text" name="field24" value="${f24}"> =
            <input type="text" name="multiplication" value="${multiplication}"> <br>
            <br>
            <input type="submit" name="submit" value="Submit"> 
        </form>
    </body>
</html>
