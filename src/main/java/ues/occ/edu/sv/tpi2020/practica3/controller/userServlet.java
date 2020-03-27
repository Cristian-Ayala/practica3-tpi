/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.tpi2020.practica3.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ues.occ.edu.sv.tpi2020.practica3.entities.Usuarios;
import ues.occ.edu.sv.tpi2020.practica3.facades.TipoUsuariosFacade;
import ues.occ.edu.sv.tpi2020.practica3.facades.UsuariosFacade;

/**
 *
 * @author cristian
 */
public class userServlet extends HttpServlet {

    @Inject
    UsuariosFacade usuarioFacade;
    Usuarios user;
    @Inject
    TipoUsuariosFacade typeFacade;

    public static boolean isNullOrEmpty(String str) {
        return ((str != null) ? (!str.trim().isEmpty()) : (false));
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet userServlet</title>");
            out.println("</head>");
            out.println("<body>");
            try {

                //Evalua si quiere crear empleado
                if (isNullOrEmpty(request.getParameter("nombre")) && isNullOrEmpty(request.getParameter("apellido")) && isNullOrEmpty(request.getParameter("edad")) && isNullOrEmpty(request.getParameter("usuario")) && isNullOrEmpty(request.getParameter("contrasenia"))) {
                    user = new Usuarios();
                    user.setIdUsuario(null);
                    user.setNombres(request.getParameter("nombre"));
                    user.setApellidos(request.getParameter("apellido"));
                    user.setEdad(Integer.parseInt(request.getParameter("edad")));
                    user.setUsuario(request.getParameter("usuario"));
                    user.setPassword(org.apache.commons.codec.digest.DigestUtils.sha256Hex(request.getParameter("contrasenia")));
                    user.setIdTipoUsuario(typeFacade.find(2));
                    if (usuarioFacade.noCreated(user)) {
                        usuarioFacade.create(user);
                        System.out.println("se creo con exito");
                        request.setAttribute("correcto", "true");
                    } else {
                        System.out.println("no se creo con exito :/");
                        request.setAttribute("correcto", "false");
                    }

                    //Evalua si quiere editar al empleado
                } else if (isNullOrEmpty(request.getParameter("editId")) && isNullOrEmpty(request.getParameter("txtNombre")) && isNullOrEmpty(request.getParameter("txtApellido")) && isNullOrEmpty(request.getParameter("txtEdad")) && isNullOrEmpty(request.getParameter("txtUsuario")) && isNullOrEmpty(request.getParameter("txtContrasenia"))) {
                    user = new Usuarios();
                    user.setIdUsuario(Integer.parseInt(request.getParameter("editId")));
                    user.setNombres(request.getParameter("txtNombre"));
                    user.setApellidos(request.getParameter("txtApellido"));
                    user.setEdad(Integer.parseInt(request.getParameter("txtEdad")));
                    user.setUsuario(request.getParameter("txtUsuario"));
                    user.setPassword(org.apache.commons.codec.digest.DigestUtils.sha256Hex(request.getParameter("txtContrasenia")));
                    user.setIdTipoUsuario(typeFacade.find(2));
                    usuarioFacade.edit(user);
                    //Evalua si lo quiere eliminar
                } else if (isNullOrEmpty(request.getParameter("elimEmpleadoID"))) {
                    usuarioFacade.remove(usuarioFacade.find(Integer.parseInt(request.getParameter("elimEmpleadoID"))));
//                    empleadosFacade.eliminarById(Integer.parseInt(request.getParameter("empleadixID")));
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
            request.setAttribute("listaUsuarios", usuarioFacade.findAll());
            request.getRequestDispatcher("/user.jsp").forward(request, response);
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
