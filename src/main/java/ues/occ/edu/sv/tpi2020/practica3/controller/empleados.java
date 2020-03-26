package ues.occ.edu.sv.tpi2020.practica3.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ues.occ.edu.sv.tpi2020.practica3.entities.Empleados;
import ues.occ.edu.sv.tpi2020.practica3.facades.EmpleadosFacade;

/**
 *
 * @author cristian
 */
@WebServlet(name = "empleados", urlPatterns = {"/empleados"})
public class empleados extends HttpServlet {

    @Inject
    EmpleadosFacade empleadosFacade;
    Empleados empleado = new Empleados();

    public static boolean isNullOrEmpty(String str) {
        return ((str != null) ? (!str.trim().isEmpty()) : (false));
    }
//<%= request.getSession().getAttribute("usuario")%>

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
            out.println("<title>Empleados</title>");
            out.println("</head>");
            out.println("<body>");
            try {

                //Evalua si quiere crear empleado
                if (isNullOrEmpty(request.getParameter("name")) && isNullOrEmpty(request.getParameter("email")) && isNullOrEmpty(request.getParameter("phone"))) {
                    empleado = new Empleados(null, request.getParameter("name"), request.getParameter("email"), request.getParameter("phone"));
                    if (empleadosFacade.noCreated(empleado)) {
                        empleadosFacade.create(empleado);
                        System.out.println("se creo con exito");
                        request.setAttribute("correcto", "true");
                    } else {
                        System.out.println("no se creo con exito :/");
                        request.setAttribute("correcto", "false");
                    }

                    //Evalua si quiere editar al empleado
                } else if (isNullOrEmpty(request.getParameter("editId")) && isNullOrEmpty(request.getParameter("editNombre")) && isNullOrEmpty(request.getParameter("editApellido")) && isNullOrEmpty(request.getParameter("editTel"))) {
                    empleado = new Empleados(Integer.parseInt(request.getParameter("editId")), request.getParameter("editNombre"), request.getParameter("editApellido"), request.getParameter("editTel"));
                    empleadosFacade.edit(empleado);

                    //Evalua si lo quiere eliminar
                } else if (isNullOrEmpty(request.getParameter("empleadixID"))) {
                    empleadosFacade.eliminarById(Integer.parseInt(request.getParameter("empleadixID")));
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
            request.setAttribute("listaEmpleados", empleadosFacade.findAll());
            RequestDispatcher rd = request.getRequestDispatcher("/CRUD.jsp");
            rd.forward(request, response);
            out.println("<h1>Servlet empleados at " + request.getContextPath() + "</h1>");
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

//        catch (Exception ex) {
//            Logger.getLogger(empleados.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
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
