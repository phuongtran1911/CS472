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
            <p>Your current score is ${sessionScope.score}.<br>
                    Guess the next number in the sequence.<br>
                    ${sessionScope.question}
            </p>
            Your answer: <br>
            <input type="text" name="answer"> <br>
            <input type="submit" value="Submit"> 
        </form>
    </body>
</html>
