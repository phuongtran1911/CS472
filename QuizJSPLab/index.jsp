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
            Your age: <input type="text" name="age" value="<%= request.getAttribute("age") %>"> <br>
            <p>Your current score is <%= session.getAttribute("score") %>.<br>
                    Guess the next number in the sequence.<br>
                    <%= session.getAttribute("question") %><br>
                    <%= session.getAttribute("hint") %>
            </p>
            Your answer: <input type="text" name="answer"> <br><br>
            <input type="submit" name="submit" value="Submit"> 
            <input type="submit" name="hint" value="Hint"> 
        </form>
    </body>
</html>
