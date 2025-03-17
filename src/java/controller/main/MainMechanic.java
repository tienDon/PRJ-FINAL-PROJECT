/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.main;

import constance.SearchTicketMechanicType;
import dao.ServiceDAO;
import dao.ServiceTicketDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ServiceTicket;

/**
 *
 * @author ASUS
 */
public class MainMechanic extends HttpServlet {

    private static final String LOGIN = "MainController?action = login";
    private static final String WELCOME = "MechanicDashboard.jsp";
    private static final String SEARCHTICKETMECHANIC = "searchTicketMechanicServlet";
    private static final String DETAILTICKETMECHANICSERVLET = "serviceTicketMechanicDetailServlet";
    private static final String DETAILTICKETMECHANIC = "serviceTicketMechanicDetail.jsp";
    private static final String UPDATETICKETMECHANIC = "updateServiceTicketMechanic.jsp";
    private static final String UPDATETICKETMECHANICSERVLET = "updateServiceTicketMechanicServlet";
    private static final String SEARCHSERVICEMECHANIC = "searchServiceMechanicServlet";
    private static final String CREATESERVICEMECHANICSERVLET = "createServiceMechanicServlet";
    private static final String CREATESERVICEMECHANIC = "createServiceMechanic.jsp";

    private static final String UPDATESERVICEMECHANIC = "updateServiceMechanic.jsp";
    private static final String UPDATESERVICEMECHANICSERVLET = "updateServiceMechanicServlet";
    private static final String DELETESERVICEMECHANICSERVLET = "deleteServiceMechanicServlet";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            request.setCharacterEncoding("utf-8");
            String url = "WELCOME";
            try {
                String action = request.getParameter("action").trim();
                HttpSession session = request.getSession(false);
                if (session == null || session.getAttribute("MECHANIC") == null) {
                    // Không có session hợp lệ => Chuyển hướng về trang đăng nhập
                    url = LOGIN;
                } else {
                    switch (action) {
                        case "view":
                            url = WELCOME;
                            break;
                        case "Search Ticket":
                            url = SEARCHTICKETMECHANIC;
                            break;
                        case "Details":
                            url = DETAILTICKETMECHANICSERVLET;
                            break;
                        case "viewDetail":
                            url = DETAILTICKETMECHANIC;
                            break;
                        case "Update Ticket":
                            url = UPDATETICKETMECHANIC;
                            break;
                        case "Update":
                            url = UPDATETICKETMECHANICSERVLET;
                            break;
                        case "Search Service":
                            url = SEARCHSERVICEMECHANIC;
                            break;
                        case "Create Service":
                            url = CREATESERVICEMECHANIC;
                            break;
                        case "Create":
                            url = CREATESERVICEMECHANICSERVLET;
                            break;
                        case "Update Service":
                            url = UPDATESERVICEMECHANIC;
                            break;
                        case "Delete Service":
                            url = DELETESERVICEMECHANICSERVLET;
                            break;
                        case "update":
                            url = UPDATESERVICEMECHANICSERVLET;
                            break;
                    }
                }
            } catch (Exception e) {
                log(e + e.getMessage());
            } finally {
                request.getRequestDispatcher(url).forward(request, response);
            }

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
