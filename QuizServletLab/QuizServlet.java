/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

public class QuizServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession s = request.getSession();
        
        Quiz q;
        if(s.getAttribute("quiz") != null)            
            q = (Quiz) s.getAttribute("quiz");
        else {
            q = new Quiz();
            s.setAttribute("quiz", q);  
        }
        int answer = Integer.parseInt(request.getParameter("answer"));
        q.calculateScore(answer);
        s.setAttribute("quiz", q);
        if (q.quizOver()) {
            out.write("<!DOCTYPE html>\n");
            out.write("<html>\n");
            out.write("    <head>\n");
            out.write("        <title>The Number Quiz</title>\n");
            out.write("    </head>\n");
            out.write("    <body> \n");
            out.write("        <h1>The Number Quiz</h1> \n");
            out.write("        <form method=\"POST\" action=\"QuizServlet\">\n");
            out.write("            <p>Your current score is " + q.getScore() + ".<br>");
            out.write("                You have completed the Number Quiz, with a score of " + q.getScore() + " out of 5.");
            out.write("            </p>\n");
            out.write("        </form>\n");
            out.write("    </body>\n");
            out.write("</html>");
        } else {
            out.write("<!DOCTYPE html>\n");
            out.write("<html>\n");
            out.write("    <head>\n");
            out.write("        <title>The Number Quiz</title>\n");
            out.write("    </head>\n");
            out.write("    <body> \n");
            out.write("        <h1>The Number Quiz</h1> \n");
            out.write("        <form method=\"POST\" action=\"QuizServlet\">\n");
            out.write("            <p>Your current score is " + q.getScore() + ".<br>");
            out.write("                    Guess the next number in the sequence.<br>\n");
            out.write(q.getQuestion() + "<br></p>");
            out.write("            Your answer: <input type=\"text\" name=\"answer\"> <br><br>\n");
            out.write("            <input type=\"submit\" value=\"Submit\"> \n");
            out.write("        </form>\n");
            out.write("    </body>\n");
            out.write("</html>");
        }
    }

}

