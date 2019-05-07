package edu.mum.cs545;
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ChooseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        RequestDispatcher dispatch = request.getRequestDispatcher("Choose.jsp");
        dispatch.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        RadioState s;
        if (session.getAttribute("state") != null) {
            s = (RadioState) session.getAttribute("state");
        } else {
            s = new RadioState();
        }
        if (request.getParameter("btnSubmit1") != null) {
            String choice1 = request.getParameter("radioJSPCool");
            s.answer(choice1, "radioJSPCool");
        } 
        if (request.getParameter("btnSubmit2") != null) {
            String choice2 = request.getParameter("JSFwayCool");
            s.answer(choice2, "JSFwayCool");
        }
        if (request.getParameter("btnSubmit3") != null) {
            String choice3 = request.getParameter("moonCheese");
            s.answer(choice3, "moonCheese");
        }
        session.setAttribute("state", s);
        RequestDispatcher dispatch = request.getRequestDispatcher("Choose.jsp");
        dispatch.forward(request, response);
    }
}