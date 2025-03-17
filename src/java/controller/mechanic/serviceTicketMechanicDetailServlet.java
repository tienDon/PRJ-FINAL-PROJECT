/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.mechanic;

import constance.SearchTicketMechanicType;
import dao.ServiceMechanicDAO;
import dao.ServiceTicketDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ServiceMechanic;
import model.ServiceTicket;

/**
 *
 * @author ASUS
 */
public class serviceTicketMechanicDetailServlet extends HttpServlet {

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
            ServiceTicketDAO dao = new ServiceTicketDAO();
            String ticketID = request.getParameter("ticketID");
            
            ArrayList<ServiceMechanic> listMecha = new ArrayList<>();
            ServiceMechanicDAO d = new ServiceMechanicDAO();
            
            ArrayList<ServiceTicket> listServiceTicket = dao.getServiceTicketByID(ticketID, SearchTicketMechanicType.serviceTicketID.toString());
            for (ServiceTicket serviceTicket : listServiceTicket) {
                listMecha = d.getServiceMechanicByServiceTicketId(serviceTicket.getServiceTicketID());
            }
            request.setAttribute("detail", listMecha);
            request.getRequestDispatcher("MainMechanic?action=viewDetail").forward(request, response);
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
