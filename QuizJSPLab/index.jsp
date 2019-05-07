<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(session.getAttribute("quiz") == null){
        request.getRequestDispatcher("/QuizServlet").forward(request, response);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The Number Quiz</title>
    </head>
    <body> 
        <h1>The Number Quiz</h1> 
        <form method="POST" action="/QuizServlet">
            Your age: <input type="text" name="age" value="<%= request.getAttribute("age") %>"> <br>
            <p>Your current score is ${quiz.score}.<br>
                    Guess the next number in the sequence.<br>
                    ${quiz.question}<br>
                    ${quiz.hint}
            </p>
            Your answer: <input type="text" name="answer"> <br><br>
            <input type="submit" name="submit" value="Submit"> 
            <input type="submit" name="hint" value="Hint"> 
        </form>
    </body>
</html>
