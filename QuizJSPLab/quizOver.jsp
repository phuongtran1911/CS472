<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The Number Quiz</title>
    </head>
    <body> 
        <h1>The Number Quiz</h1> 
        <form method="POST" action="QuizServlet">
            <p>Your current score is ${quiz.score}.<br>
                You have completed the Number Quiz, with a score of ${quiz.score}.
            </p>
            <p>Your final grade is <span style="color: red">${quiz.grade}</span></p>
        </form>
    </body>
</html>