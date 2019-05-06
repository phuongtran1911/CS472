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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //HttpSession pres = request.getSession(false);
        HttpSession s = req.getSession();
        
        // get quiz from session or create new
        Quiz q = null;
        if(s.getAttribute("quiz") != null)            
            q = (Quiz) s.getAttribute("quiz");
        else
            q = new Quiz();
        
        // save
        s.setAttribute("age", "");
        s.setAttribute("question", q.getCurrentQuestion());
        s.setAttribute("score", q.getScore());
        s.setAttribute("hint", "");
        s.setAttribute("quiz", q);
        
        req.getRequestDispatcher("index.jsp").forward(req, resp);
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
        
        //HttpSession pres = request.getSession(false);
        HttpSession s = request.getSession();
        
        // get quiz from session or create new
        Quiz q;
        if(request.getSession().getAttribute("quiz") != null)            
            q = (Quiz) request.getSession().getAttribute("quiz");
        else
            q = new Quiz();
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
        // check and save the answer.  
        int answer = Integer.parseInt(request.getParameter("answer"));
        q.answer(answer);
        
        if (q.isFinish()) {
            s.setAttribute("grade", q.finalResult());
            q = null;
            RequestDispatcher view = request.getRequestDispatcher("index_1.jsp");
            view.forward(request, response);
        }
        
        // get next question.        
        request.getSession().setAttribute("question", q.getCurrentQuestion());
        request.getSession().setAttribute("score", q.getScore());
        s.setAttribute("hint", "");
        request.getSession().setAttribute("quiz", q);

        // forward all result (request, response) to new destination
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
        } else if (request.getParameter("hint") != null) {
            s.setAttribute("hint", q.getHint());
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }
        
    }

}