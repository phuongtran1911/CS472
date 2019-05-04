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
        <form method="POST" action="SimpleCalculator1">
            Simple Calculator 1 <br>
            <input type="text" name="field12"> +
            <input type="text" name="field12"> <br>
            <br>
            <input type="text" name="field13"> *
            <input type="text" name="field14"> <br>
            <br>
            <input type="submit" name="submit1" value="Submit"> 
        </form>
        <br>
        <form method="POST" action="SimpleCalculator2">
            Simple Calculator 2 <br>
            <input type="text" name="field21" value="<%=request.getParameter("field21") %>"> +
            <input type="text" name="field22" value="<%=request.getParameter("field21") %>"> =
            <input type="text" name="sum" value="<%=request.getAttribute("sum") %>"> <br>
            <br>
            <input type="text" name="field23" value="<%=request.getParameter("field23") %>"> *
            <input type="text" name="field24" value="<%=request.getParameter("field24") %>"> =
            <input type="text" name="multiplication" value="<%=request.getAttribute("multiplication") %>"> <br>
            <br>
            <input type="submit" name="submit2" value="Submit"> 
        </form>
    </body>
</html>
