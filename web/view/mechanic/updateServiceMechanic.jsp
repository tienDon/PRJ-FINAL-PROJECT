<%-- 
    Document   : updateServiceMechanic
    Created on : Mar 15, 2025, 4:20:41 PM
    Author     : ASUS
--%>

<%@page import="model.Service"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ServiceDAO"%>
<%@page import="constance.ServiceSearchType"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

        <title>JSP Page</title>
    </head>
    <body>

        <div class="container">
            <h2 class="mt-3">Update Service Ticket</h2>

            <%
                // Lấy ticketID và status từ URL
                String serviceID = request.getParameter("txtserviceid");
                String status = request.getParameter("status");
            %>
            <!-- Hiển thị thông báo sau khi cập nhật -->
            <%
                if ("true".equals(status)) {
            %>
            <div class="alert alert-success">Update successful!</div>
            <%
            } else if ("false".equals(status)) {
            %>
            <div class="alert alert-danger">Update failed. Please try again.</div>
            <%
                }
            %>

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
                            <%
                                // Lấy dữ liệu từ database theo ticketID
                                Service service = new Service();
                                ServiceDAO d = new ServiceDAO();
                                ArrayList<Service> serviceList = d.getServiceByType(serviceID, ServiceSearchType.serviceID.toString());
                                if (serviceList != null) {
                                    for (Service item : serviceList) {
                                        service = item;

                            %>
                            <tr><td>Service Name</td><td><%= item.getServiceName()%></td></tr>
                            <tr><td>Hourly Rate</td><td><%= item.getHourlyRate()%></td></tr>
                            <%
                                    }
                                }%>
                        </tbody>
                    </table>
                </div>

                <!-- Cột 2: Form cập nhật -->
                <div class="col-md-6">
                    <h4>Update Ticket</h4>
                    <form action="MainMechanic" accept-charset="utf-8">
                        <input type="hidden" name="serviceID" value="<%= service.getServiceID() %>">

                        <label class="form-label">Service Name: </label>
                        <input  name="serviceName" class="form-control"  required >

                        <label class="form-label">Hourly Rate</label>
                        <input type="number" name="hourlyRate" class="form-control"min="0" step="0.5" required placeholder="input number">

                        <div class="d-flex gap-2 mt-3">
                            <input type="submit" name="action" value="update">
                            <button type="button" class="btn btn-secondary" onclick="history.back()">Back</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
