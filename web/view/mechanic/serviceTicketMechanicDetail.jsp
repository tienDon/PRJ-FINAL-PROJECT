<%-- 
    Document   : serviceTicketDetail
    Created on : Mar 1, 2025, 2:47:37 PM
    Author     : ASUS
--%>
<%@page import="model.ServiceMechanic"%>
<%@page import="dao.ServiceMechanicDAO"%>
<%@page import="constance.SearchTicketMechanicType"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.MECHANIC == null }">
    <jsp:forward page="MainController">
        <jsp:param name="action" value="home"/>
    </jsp:forward>
</c:if>
<c:if test="${sessionScope.MECHANIC != null }">



    <%@page import="java.util.ArrayList"%>
    <%@page import="model.ServiceTicket"%>
    <%@page import="dao.ServiceTicketDAO"%>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

        </head>
        <body>
            <%--<jsp:include page="navbar.jsp"/>--%>
            <%----%>
            <c:set var="status" value="${requestScope.status}" />
            <!-- Hiển thị thông báo sau khi cập nhật -->
            <c:if test="${status == 'true'}">
                <div class="alert alert-success">Update successful!</div>
            </c:if>
            <c:if test="${status == 'false'}">
                <div class="alert alert-danger">Update failed. Please try again.</div>
            </c:if>
            <div class="container mt-4">
                <h2 class="text-center">Service Ticket Detail</h2>

                <%--
                <%
                    String ticketID = request.getParameter("ticketID");
                    ServiceTicketDAO dao = new ServiceTicketDAO();
                    ArrayList<ServiceTicket> list = dao.getServiceTicketByID(ticketID, SearchTicketMechanicType.serviceTicketID.toString());
                    ServiceMechanicDAO d = new ServiceMechanicDAO();
                    ArrayList<ServiceMechanic> listMecha = new ArrayList<>();
                %>  --%>

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
                        <c:forEach items="${requestScope.detail}" var="t">
                            <tr>
                                <td>${t.serviceTicketID}</td>
                                <td>${t.serviceID}</td>
                                <td>${t.mechanicID}</td>
                                <td>${t.hours}</td>
                                <td>${t.comment}</td>
                                <td>${t.rate}</td>
                                <td>
                                    <form action="MainMechanic" method="post">
                                        <input type="hidden" name="serviceTicketID" value="${t.serviceTicketID}">
                                        <input type="hidden" name="serviceID" value="${t.serviceID}">
                                        <input type="submit" name="action" value="Update Ticket" class="btn btn-sm btn-primary">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="text-center mt-3">
                    <button class="btn btn-secondary" onclick="history.back()">Back</button>
                </div>
            </div>


        </body>
    </html>
</c:if>