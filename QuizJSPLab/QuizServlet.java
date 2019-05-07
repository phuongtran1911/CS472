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

public class QuizServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession();
        s.setAttribute("quiz", new Quiz());
        request.setAttribute("age", "");
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }

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
            request.setAttribute("age", "");
            s.setAttribute("quiz", q);  
        }
        String age = request.getParameter("age");
        if (!age.equals("") && age.length() < 4) {
            int a = Integer.parseInt(age);
            if (a < 4 || a > 100) {
                throw new NumberFormatException("You must enter your age with an integer between 4 and 100");
            }
            request.setAttribute("age", a);
        } else {
            throw new NumberFormatException("You must enter your age with an integer between 4 and 100");
        }
               
        if (request.getParameter("submit") != null) {
            int answer = Integer.parseInt(request.getParameter("answer"));
            q.calculateScore(answer);
            if (q.quizOver()) {
                q = null;
                RequestDispatcher view = request.getRequestDispatcher("quizOver.jsp");
                view.forward(request, response);
            }

            s.setAttribute("hint", "");
            s.setAttribute("quiz", q);

            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        } else if (request.getParameter("hint") != null) {
            s.setAttribute("hint", q.getHint());
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }    
    }

}
