/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.tpi2020.practica3.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ues.occ.edu.sv.tpi2020.practica3.facades.UsuariosFacade;

/**
 *
 * @author cristian
 */
@WebServlet(name = "usuarios", urlPatterns = {"/usuarios"})
public class usuarios extends HttpServlet {

    @Inject
    public UsuariosFacade userFacade;

    public enum estadoUser {
        SUCCESS,
        FAIL
    }
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
//            request.setAttribute("estado", estadoUser.SUCCESS);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet usuarios</title>");
            out.println("</head>");
            out.println("<body>");
            if (!"".equals(request.getParameter("txtUsuario")) && !"".equals(request.getParameter("txtContrasenia"))) {
                if (userFacade.verificar(request.getParameter("txtUsuario"), org.apache.commons.codec.digest.DigestUtils.sha256Hex(request.getParameter("txtContrasenia")))) {
                    request.setAttribute("usuario", request.getParameter("txtUsuario"));
                    request.setAttribute("estado", "SUCCESS");
                    RequestDispatcher rd = request.getRequestDispatcher("/empleados.jsp");
                    rd.forward(request, response);
                } else {
                    request.setAttribute("estado", "J");
                    RequestDispatcher rd = request.getRequestDispatcher("/ingreso.jsp");
                    rd.forward(request, response);
                }
            }

            out.println("<h1>Servlet usuarios at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
