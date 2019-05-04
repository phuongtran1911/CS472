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
@WebServlet(name = "SimpleCalculator", urlPatterns = {"/SimpleCalculator"})
public class SimpleCalculator1 extends HttpServlet {

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
        String f11 = request.getParameter("field11");
        String f12 = request.getParameter("field12");
        String f13 = request.getParameter("field13");
        String f14 = request.getParameter("field14");
        if (f11 != null && f12 != null && !f11.equals("") && !f12.equals("")) {
            int n11 = Integer.parseInt(f11);
            int n12 = Integer.parseInt(f12);
            int s = n11 + n12;
            out.println(n11 + " + " + n12 + " = " + s + "<br>");
        }
        if (f13 != null && f14 != null && !f13.equals("") && !f14.equals("")) {
            int n13 = Integer.parseInt(f13);
            int n14 = Integer.parseInt(f14);
            int m = n13 * n14;
            out.println(n13 + " * " + n14 + " = " + m + "<br>");
        }
    }

}
