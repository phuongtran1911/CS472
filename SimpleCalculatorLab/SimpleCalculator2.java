/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs472;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 987132
 */
@WebServlet(name = "SimpleCalculator2", urlPatterns = {"/SimpleCalculator2"})
public class SimpleCalculator2 extends HttpServlet {
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
        String f21 = request.getParameter("field21");
        String f22 = request.getParameter("field22");
        String f23 = request.getParameter("field23");
        String f24 = request.getParameter("field24");
        if (f21 != "null" && f22 != "null" && !f21.equals("") && !f22.equals("")) {
            int n21 = Integer.parseInt(f21);
            int n22 = Integer.parseInt(f22);
            int s = n21 + n22;
            request.setAttribute("sum", s);
        }
        if (f23 != "null" && f24 != "null" && !f23.equals("") && !f24.equals("")) {
            int n23 = Integer.parseInt(f23);
            int n24 = Integer.parseInt(f24);
            int m = n23 * n24;
            request.setAttribute("multiplication", m);
        }
        view.forward(request, response);
    }
    
}
