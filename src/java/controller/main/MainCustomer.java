/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.main;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
public class MainCustomer extends HttpServlet {

    private static final String LOGIN = "MainController?action = login";
    private static final String WELCOME = "CusDashboard.jsp";
    private static final String INVOICEDETAIL = "invoiceDetailCus.jsp";
    private static final String TICKETCUSDETAIL = "serviceTicketDetailCus.jsp";
    private static final String UPDATEPROFILE = "updateProfileSerlvet";
    
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
                if (session == null || session.getAttribute("CUSTOMER") == null) {
                    // Không có session hợp lệ => Chuyển hướng về trang đăng nhập
                    url = LOGIN;
                } else {
                    switch (action) {
                        case "view":
                            url = WELCOME;
                            break;
                        case "Details Invoice":
                            url = INVOICEDETAIL;
                            break;
                        case "Details Ticket":
                            url = TICKETCUSDETAIL;
                            break;
                        case "update profile":
                            url = UPDATEPROFILE;
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
