<%-- 
    Document   : serviceTicketDetailCus
    Created on : Mar 15, 2025, 8:24:51 PM
    Author     : ASUS
--%>

<%@page import="constance.SearchTicketMechanicType"%>
<%@page import="model.ServiceMechanic"%>
<%@page import="dao.ServiceMechanicDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ServiceTicket"%>
<%@page import="dao.ServiceTicketDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <%----%>
        <div class="container mt-4">
            <h2 class="text-center">Service Ticket Detail</h2>

            <%
                String ticketID = request.getParameter("ticketID");
                ServiceTicketDAO dao = new ServiceTicketDAO();
                ArrayList<ServiceTicket> list = dao.getServiceTicketByID(ticketID, SearchTicketMechanicType.serviceTicketID.toString());
                ServiceMechanicDAO d = new ServiceMechanicDAO();
                ArrayList<ServiceMechanic> listMecha = new ArrayList<>();
            %>

            <table class="table table-bordered mt-4">
                <thead class="table-dark">
                    <tr>
                        <th>Ticket ID</th>
                        <th>Service ID</th>
                        <th>Mechanic ID</th>
                        <th>Hours</th>
                        <th>Comment</th>
                        <th>Rate</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (ServiceTicket ticket : list) {
                            listMecha = d.getServiceMechanicByServiceTicketId(ticket.getServiceTicketID());
                            for (ServiceMechanic mecha : listMecha) {
                    %>
                    <tr>
                        <td><%= mecha.getServiceTicketID()%></td>
                        <td><%= mecha.getServiceID()%></td>
                        <td><%= mecha.getMechanicID()%></td>
                        <td><%= mecha.getHours()%></td>
                        <td><%= mecha.getComment()%></td>
                        <td><%= mecha.getRate()%></td>
                        <td>
                            <a href="updateServiceTicket.jsp?serviceTicketID=<%= mecha.getServiceTicketID()%>
                               &serviceID=<%= mecha.getServiceID()%> " class="btn btn-primary btn-sm">Update</a>
                        </td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
            <div class="text-center mt-3">
                <button class="btn btn-secondary" onclick="history.back()">Back</button>
            </div>
        </div>
    </body>
</html>
