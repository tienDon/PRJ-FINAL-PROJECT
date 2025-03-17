<%-- 
    Document   : CusDashboard
    Created on : Mar 15, 2025, 7:06:27 PM
    Author     : ASUS
--%>

<%@page import="dao.InvoiceDAO"%>
<%@page import="model.Invoice"%>
<%@page import="dao.ServiceTicketDAO"%>
<%@page import="model.ServiceTicket"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty sessionScope.CUSTOMER}">
    <c:if test="${empty sessionScope.CUSTOMER}">
        <% response.sendRedirect("MainController?action=home"); %>
    </c:if>

</c:if>
<c:if test="${sessionScope.CUSTOMER != null}">
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Customer Dashboard</title>

            <!-- Bootstrap CSS -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

            <!-- FontAwesome Icons -->
            <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>

            <style>
                body{
                    padding-top: 60px;
                    background-color: #f8f9fa;
                }

                .component {
                    display: none; /* Mặc định ẩn */
                }
                .component.active {
                    display: block; /* Hiện khi active */
                }
                .menu button.active {
                    background-color: #007bff;
                    color: white;
                }
                .profile-container {
                    max-width: 600px;
                    margin: auto;
                    background: white;
                    padding: 20px;
                    border-radius: 10px;
                    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                }
                .profile-item {
                    display: flex;
                    justify-content: space-between;
                    padding: 15px 0;
                    border-bottom: 1px solid #ddd;
                }
                .edit-icon {
                    color: #007bff;
                    cursor: pointer;
                }
                .menu button {
                    transition: transform 0.3s ease-out, background-color 0.3s ease-out;
                }

                .menu button:hover {
                    transform: scale(1.1);
                }

                .menu button:active {
                    transform: scale(0.95);
                    transition: transform 0.1s ease-out;
                }

            </style>
        </head>
        <body>
            <jsp:include page="navbar.jsp"/>

            <div class="container">
                <h1 class="text-center">Hello, ${sessionScope.CUSTOMER.custName}</h1>

                <div class="text-center mb-3 menu">
                    <button class="btn btn-primary" id="tickets-btn" data-target="section1"> Tickets</button>
                    <button class="btn btn-primary" id="invoices-btn" data-target="section2"> Invoices</button>
                    <button class="btn btn-primary" id="change-profile-btn" data-target="section3"> Change profile</button>
                </div>

                <!--Tickets-->
                <div id="section1" class="component">
                    <table class="table table-striped table-bordered">
                        <thead class="table-primary">
                            <tr>
                                <th>Service Ticket ID</th>
                                <th>Date Received</th>
                                <th>Date Returned</th>
                                <th>Customer ID</th>
                                <th>Car ID</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<ServiceTicket> ticketList = (ArrayList<ServiceTicket>) request.getAttribute("tickets");
                                if (ticketList == null) {
                                    ServiceTicketDAO d = new ServiceTicketDAO();
                                    ticketList = d.getALLServiceTicket();
                                }
                                for (ServiceTicket ticket : ticketList) {
                            %>
                            <tr>
                                <td><%= ticket.getServiceTicketID()%></td>
                                <td><%= ticket.getDateReceived()%></td>
                                <td><%= ticket.getDateReturned()%></td>
                                <td><%= ticket.getCustID()%></td>
                                <td><%= ticket.getCarID()%></td>
                                <td>

                                    <div class="d-flex justify-content-center gap-2">
                                        <form action="MainCustomer" method="post">
                                            <input type="hidden" name="ticketID" value="<%= ticket.getServiceTicketID()%>">
                                            <input class="btn btn-sm btn-info w-100" type="submit" name="action" value="Details Ticket">
                                        </form>

                                    </div>

                                </td>
                            </tr>
                            <%
                                }

                            %>
                        </tbody>
                    </table>
                </div>

                <!--Invoices-->
                <div id="section2" class="component">
                    <table class="table table-striped table-bordered">
                        <thead class="table-primary">
                            <tr>
                                <th>Invoice ID</th>
                                <th>Invoice Date</th>
                                <th>Sales ID</th>
                                <th>Car ID</th>
                                <th>Cust ID</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%  ArrayList<Invoice> invoiceList = (ArrayList<Invoice>) request.getAttribute("invoices");
                                if (invoiceList == null) {
                                    InvoiceDAO d = new InvoiceDAO();
                                    invoiceList = d.getAllInvoices();
                                }
                                for (Invoice invoice : invoiceList) {
                            %>
                            <tr>
                                <td><%= invoice.getInvoiceID()%></td>
                                <td><%= invoice.getInvoiceDate()%></td>
                                <td><%= invoice.getSalesID()%></td>
                                <td><%= invoice.getCarID()%></td>
                                <td><%= invoice.getCustID()%></td>
                                <td>
                                    <div class="d-flex justify-content-center gap-2">
                                        <form action="MainCustomer" method="post">
                                            <input type="hidden" name="invoiceID" value="<%= invoice.getInvoiceID()%>">
                                            <input class="btn btn-sm btn-info w-100" type="submit" name="action" value="Details Invoice">
                                        </form>

                                    </div>

                                </td>
                            </tr>
                            <%
                                }

                            %>
                        </tbody>
                    </table>
                </div>

                <!--Change profile-->
                <div id="section3" class="component">
                    <form action="MainCustomer" accept-charset="utf-8" method="post" class="p-4 border rounded shadow bg-white">
                        <h2 class="text-center mb-4">Cập nhật thông tin</h2>

                        <!-- ID Ẩn -->
                        <input type="hidden" name="custID" value="${sessionScope.CUSTOMER.custID}"/>

                        <!-- Họ tên -->
                        <div class="mb-3">
                            <label class="form-label">Name:</label>
                            <input type="text" name="custName" value="${sessionScope.CUSTOMER.custName}" class="form-control" required />
                        </div>

                        <!-- Số điện thoại -->
                        <div class="mb-3">
                            <label class="form-label">Phone:</label>
                            <input type="text" name="phone" value="${sessionScope.CUSTOMER.phone}" class="form-control" required />
                        </div>

                        <!-- Giới tính -->
                        <div class="mb-3">
                            <label class="form-label">Gender:</label>
                            <select name="sex" class="form-select" required>
                                <option value="${sessionScope.CUSTOMER.sex}" selected>${sessionScope.CUSTOMER.sex}</option>
                                <c:if test="${sessionScope.CUSTOMER.sex != 'M'}">
                                    <option value="M">M</option>
                                </c:if>
                                <c:if test="${sessionScope.CUSTOMER.sex != 'F'}">
                                    <option value="F">F</option>
                                </c:if>
                            </select>

                        </div>

                        <!-- Địa chỉ -->
                        <div class="mb-3">
                            <label class="form-label">Address:</label>
                            <input type="text" name="custAddress" value="${sessionScope.CUSTOMER.custAddress}" class="form-control" required />
                        </div>

                        <!-- Nút cập nhật -->
                        <div class="text-center">
                            <input type="submit" name="action" value="update profile" class="btn btn-primary w-100" />
                        </div>
                    </form>
                    <div style="height: 20vh;"></div>
                </div>
            </div>



            <!-- Bootstrap JS -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

            <script>
                document.addEventListener("DOMContentLoaded", function () {
                    const buttons = document.querySelectorAll(".menu button");
                    const containers = document.querySelectorAll(".component");

                    document.querySelector(".menu").addEventListener("click", function (event) {
                        if (event.target.tagName === "BUTTON") {
                            let targetId = event.target.dataset.target;
                            let targetContainer = document.getElementById(targetId);

                            // Kiểm tra xem phần đang hiển thị có phải là phần vừa nhấn không
                            let isActive = targetContainer.classList.contains("active");

                            // Ẩn tất cả containers và xóa class active ở các nút
                            containers.forEach((container) => container.classList.remove("active"));
                            buttons.forEach((btn) => btn.classList.remove("active"));

                            if (!isActive) {
                                // Nếu chưa active, hiển thị phần mới và lưu vào localStorage
                                targetContainer.classList.add("active");
                                event.target.classList.add("active");
                                localStorage.setItem("activeSection", targetId);
                            } else {
                                // Nếu đã active, xóa khỏi localStorage để không lưu trạng thái hiển thị
                                localStorage.removeItem("activeSection");
                            }
                            
                            
                        }
                    });

                    
                });

            </script>
        </body>
    </html>
</c:if>