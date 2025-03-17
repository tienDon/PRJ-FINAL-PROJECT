<%-- 
    Document   : MechanicDashboard
    Created on : Mar 15, 2025, 2:39:11 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.MECHANIC == null }">
    <jsp:forward page="MainController">
        <jsp:param name="action" value="home"/>
    </jsp:forward>
</c:if>

<c:if test="${sessionScope.MECHANIC !=null}">

    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
            <!-- Bootstrap CSS -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

            <!-- FontAwesome Icons -->
            <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>


            <style>
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
            <jsp:include page="../auth/navbar.jsp"/>
            
            <div class="container mt-5">


                <h1 class="text-center">Hello, ${sessionScope.MECHANIC.name}!</h1>

                <div class="text-center mb-3 menu gap-5">
                    <button class="btn btn-primary" id="ticket-btn" data-target="section1"> Tickets</button>
                    <button class="btn btn-primary" id="services-btn" data-target="section2"> Services</button>
                </div>

                <!--TICKETS-->
                <div id="container-tickets" class="component">
                    <div class="card p-4 mb-4">
                        <h4>Search Ticket</h4>
                        <form action="MainMechanic" accept-charset="utf-8" method="post">
                            <input type="hidden" name="searchType" value="ticketMechanic">
                            <div class="mb-3">
                                <label for="searchid" class="form-label">Search Ticket</label>
                                <input type="text" name="txtsearch" value="${param.findname}" id="searchid" class="form-control"/>
                            </div>
                            <div class="mb-3">
                                <label class="form-check-label">Search By:</label>
                                <div class="form-check">
                                    <input type="radio" name="typeSearchTicketMechanic" value="custID" id="custID" class="form-check-input"/>
                                    <label for="custID" class="form-check-label">Customer ID</label>
                                </div>
                                <div class="form-check">
                                    <input type="radio" name="typeSearchTicketMechanic" value="carID" id="carID" class="form-check-input"/>
                                    <label for="carID" class="form-check-label">Car ID</label>
                                </div>
                                <div class="form-check">
                                    <input type="radio" name="typeSearchTicketMechanic" value="dateReceived" id="dateReceived" class="form-check-input"/>
                                    <label for="dateReceived" class="form-check-label">Date Received</label>
                                </div>
                            </div>
                            <input type="submit" class="btn btn-success" id="submitSearchTicket" name="action" value="Search Ticket" >
                        </form>
                    </div>


                    <div class="table-responsive">
                        <h2 class="text-center mb-3">Service Tickets</h2>
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
                                <c:if test="${requestScope.ticketList!=null}">
                                    <c:forEach items="${requestScope.ticketList}" var="t">
                                        <tr>
                                            <td>${t.serviceTicketID}</td>
                                            <td>${ t.dateReceived}</td>
                                            <td>${t.dateReturned}</td>
                                            <td>${t.custID}</td>
                                            <td>${t.carID}</td>
                                            <td>
                                                <div class="d-flex justify-content-center gap-2">
                                                    <!-- Form với nút Bootstrap -->
                                                    <form action="MainMechanic" method="post">
                                                        <input type="hidden" name="ticketID" value="${t.serviceTicketID}">
                                                        <input type="submit" name="action" value="Details" class="btn btn-sm btn-primary">
                                                    </form>
                                                </div>

                                            </td>
                                        </tr>
                                    </c:forEach>

                                </c:if>
                                <c:if test="${requestScope.ticketList==null}">
                                    ${requestScope.ERROR}
                                </c:if>
                            </tbody>
                        </table>

                    </div>

                </div>

                <!--SERVICES-->
                <div id="container-services" class="component" >
                    <div class="card p-4 mb-4">
                        <h4>Search Service</h4>
                        <form action="MainMechanic" method="post">
                            <div class="mb-3">
                                <label for="searchService" class="form-label">Search Service</label>
                                <input type="text" name="txtsearch" value="${param.findname}" id="searchService" class="form-control"/>
                            </div>
                            <div class="mb-3">
                                <label class="form-check-label">Search By:</label>
                                <div class="form-check">
                                    <input type="radio" name="searchType" value="serviceID" id="serviceID" class="form-check-input"/>
                                    <label for="serviceID" class="form-check-label">Service ID</label>
                                </div>
                                <div class="form-check">
                                    <input type="radio" name="searchType" value="serviceName" id="serviceName" class="form-check-input"/>
                                    <label for="serviceName" class="form-check-label">Service Name</label>
                                </div>
                                <div class="form-check">
                                    <input type="radio" name="searchType" value="hourlyRate" id="hourlyRate" class="form-check-input"/>
                                    <label for="hourlyRate" class="form-check-label">Hourly Rate</label>
                                </div>
                            </div>
                            <input type="submit" class="btn btn-success" name="action" value="Search Service"/>
                        </form>
                    </div>
                    <c:if test="${param.status == 'false'}">
                        <div class="alert alert-danger">${requestScope.statusMessage}</div>
                    </c:if>
                    <c:if test="${param.status == 'true'}">
                        <div class="alert alert-success">${requestScope.statusMessage}</div>
                    </c:if>

                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h2 class="mb-0">Service List</h2>
                        <form action="MainMechanic" method="post" class="d-inline">
                            <button type="submit" name="action" value="Create Service" class="btn btn-success d-flex align-items-center gap-1 px-3">
                                <i class="fas fa-plus"></i> Create Service
                            </button>
                        </form>

                    </div>

                    <!-- Service Table -->
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered">
                            <thead class="table-primary">
                                <tr>
                                    <th>Service ID</th>
                                    <th>Service Name</th>
                                    <th>Hourly Rate</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${requestScope.serviceList}" var="service">
                                    <tr>
                                        <td>${service.serviceID}</td>
                                        <td>${service.serviceName}</td>
                                        <td>${service.hourlyRate}</td>
                                        <td class="d-flex justify-content-center gap-2">

                                            <form action="MainMechanic" accept-charset="utf-8" method="post">
                                                <input type="hidden" name="txtserviceid" value="${service.serviceID}">
                                                <input type="hidden" name="serviceName" value="${service.serviceName}">
                                                <input type="hidden" name="hourlyRate" value="${service.hourlyRate}">

                                                <button type="submit" name="action" value="Update Service" 
                                                        class="btn btn-sm btn-primary d-flex align-items-center gap-1 px-3">
                                                    <i class="fas fa-edit"></i> Update Service
                                                </button>
                                            </form>
                                            <form id="deleteForm" action="MainMechanic" method="post">
                                                <input type="hidden" name="txtserviceid" value="${service.serviceID}">
                                                <input type="hidden" name="action" value="Delete Service">
                                                <button type="button" class="btn btn-sm btn-danger d-flex align-items-center gap-1 px-3" 
                                                        onclick="confirmDelete()">
                                                    <i class="fas fa-trash-alt"></i> Delete Service
                                                </button>
                                            </form>

                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
            <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

            <script>
                function confirmDelete() {
                    Swal.fire({
                        title: "Are you sure?",
                        text: "You won't be able to revert this action!",
                        icon: "warning",
                        showCancelButton: true,
                        confirmButtonColor: "#d33",
                        cancelButtonColor: "#3085d6",
                        confirmButtonText: "Yes, delete it!"
                    }).then((result) => {
                        if (result.isConfirmed) {
                            document.getElementById("deleteForm").submit(); // Gửi form đến MainMechanic
                        }
                    });
                }

                document.addEventListener("DOMContentLoaded", function () {
                    let ticketContainer = document.getElementById("container-tickets");
                    let serviceContainer = document.getElementById("container-services");

                    // Ẩn tất cả container ban đầu
                    ticketContainer.style.display = "none";
                    serviceContainer.style.display = "none";

                    // Kiểm tra trạng thái đã lưu trong localStorage
                    let activeSection = localStorage.getItem("activeSection");
                    if (activeSection === "tickets") {
                        ticketContainer.style.display = "block";
                        serviceContainer.style.display = "none";
                    } else if (activeSection === "services") {
                        serviceContainer.style.display = "block";
                        ticketContainer.style.display = "none";
                    }

                    // Xử lý khi nhấn nút Ticket
                    document.getElementById("ticket-btn").addEventListener("click", function (event) {
                        event.preventDefault();
                        if (ticketContainer.style.display == "block") {
                            ticketContainer.style.display = "none";
                        } else {
                            ticketContainer.style.display = "block";
                            serviceContainer.style.display = "none";
                        }
                        localStorage.setItem("activeSection", "tickets"); // Lưu trạng thái
                    });

                    // Xử lý khi nhấn nút Services
                    document.getElementById("services-btn").addEventListener("click", function (event) {
                        event.preventDefault();
                        if (serviceContainer.style.display == "block") {
                            serviceContainer.style.display = "none";
                        } else {
                            ticketContainer.style.display = "none";
                            serviceContainer.style.display = "block";
                        }
                        localStorage.setItem("activeSection", "services"); // Lưu trạng thái
                    });
                });

            </script>
        </body>
    </html>

</c:if>
