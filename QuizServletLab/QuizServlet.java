/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

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
        RequestDispatcher view = request.getRequestDispatcher("index.jsp"); 
        HttpSession pres = request.getSession(false);
        HttpSession s = request.getSession();
        Quiz q = (Quiz) s.getAttribute("quiz");
        if (q == null) {
            s.setAttribute("quiz", new Quiz());
        }
        if (pres == null) {
            s.setAttribute("score", 0);    
        }
        s.setAttribute("question", Quiz.getQuestion(pres));
        String a = request.getParameter("answer");
        if (!a.equals("")) {
            int answer = Integer.parseInt(a);
            request.setAttribute("score", Quiz.calculateScore(pres, answer));
        }
        view.forward(request, response);
    }

}
