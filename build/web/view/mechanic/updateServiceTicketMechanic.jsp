<%-- 
    Document   : updateServiceTicketMechanic
    Created on : Mar 15, 2025, 1:58:30 PM
    Author     : ASUS
--%>

<%@page import="dao.ServiceMechanicDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h2 class="mt-3">Update Service Ticket</h2>

            <!-- Lấy thông tin từ request -->
            <c:set var="serviceTicketID" value="${param.serviceTicketID}" />
            <c:set var="serviceID" value="${param.serviceID}" />
            
            

            <div class="row">
                <!-- Cột 1: Hiển thị thông tin hiện tại -->
                <div class="col-md-6">
                    <h4>Current Service Ticket Info</h4>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Field</th>
                                <th>Value</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="dao" value="<%= new ServiceMechanicDAO()%>" />
                            <c:set var="serviceMecha" value="${dao.getServiceMechanicByServiceTicketId(serviceTicketID, serviceID)}" />

                            <c:choose>
                                <c:when test="${serviceMecha!=null}">
                                        <tr><td>Ticket ID</td><td>${serviceMecha.serviceTicketID}</td></tr>
                                        <tr><td>Service ID</td><td>${serviceMecha.serviceID}</td></tr>
                                        <tr><td>Mechanic ID</td><td>${serviceMecha.mechanicID}</td></tr>
                                        <tr><td>Hours</td><td>${serviceMecha.hours}</td></tr>
                                        <tr><td>Comment</td><td>${serviceMecha.comment}</td></tr>
                                        <tr><td>Rate</td><td>${serviceMecha.rate}</td></tr>
                                </c:when>
                                <c:otherwise>
                                    <tr><td colspan="2">Ticket not found.</td></tr>
                                </c:otherwise>
                            </c:choose>
                        </tbody>
                    </table>
                </div>

                <!-- Cột 2: Form cập nhật -->
                <div class="col-md-6">
                    <h4>Update Ticket</h4>
                    <form action="MainMechanic" method="post" accept-charset="utf-8">
                        <input type="hidden" name="serviceTicketID" value="${serviceTicketID}">
                        <input type="hidden" name="serviceID" value="${serviceID}">

                        <label class="form-label">Work Hours: </label>
                        <input type="number" name="hours" class="form-control" min="0" step="0.5" required placeholder="Input number">

                        <label class="form-label">Comment:</label>
                        <input name="comment" class="form-control" rows="3">

                        <label class="form-label">Rate:</label>
                        <input name="rate" class="form-control" rows="3" required>

                        <input type="submit" class="btn btn-success mt-3" name="action" value="Update"/>
                    </form>
                </div>
            </div>
        </div>
        <div class="text-center mt-3">
            <button class="btn btn-secondary" onclick="history.back()">Back</button>
        </div>
    </body>
</html>
