<%-- 
    Document   : index
    Created on : May 6, 2019, 2:08:51 AM
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
        <h1>The Number Quiz</h1>
        
        <form method="POST" action="QuizServlet">
            <p>Your current score is <%= session.getAttribute("score") %>.<br>
                You have completed the Number Quiz, with a score of <%= session.getAttribute("score") %> out of 5.
            </p>
            <p style="color: red">Your final grade is <%= session.getAttribute("grade") %></p>
        </form>
    </body>
</html>