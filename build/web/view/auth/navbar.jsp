<%-- 
    Document   : navbar
    Created on : Mar 8, 2025, 1:02:37 PM
    Author     : ASUS
--%>

<%@page import="model.SalePerson"%>
<%@page import="model.Customer"%>
<%@page import="model.Mechanic"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <style>
            .bg-olive {
                background-color: #6c757d !important; /* Màu xanh rêu */
                color: white; /* Chữ trắng để dễ đọc */
            }
            nav>button:hover{
                transition: 0.3s;
                transform: scale(1.5)
            }
            .btn-logout {
                padding: 5px 15px;
                font-size: 14px;
            }

            .btn-logout:hover {
                transform: scale(1.1);
                transition: 0.2s ease-in-out;
            }
            .btn-logout:active {
                transform: scale(0.95);
                transition: transform 0.1s ease-out;
            }
            .btn-logout{
                transition: transform 0.3s ease-out, background-color 0.3s ease-out;
            }
            #empty{
                height: 5vh;
            }

        </style>

    </head>
    <body>

        <%
            Mechanic mecha = (Mechanic) session.getAttribute("MECHANIC");
            Customer cus = (Customer) session.getAttribute("CUSTOMER");
            SalePerson sale = (SalePerson) session.getAttribute("SALE");
            String homePage = "";
            homePage = mecha != null ? "MainMechanic?action=view" : cus != null ? "MainCustomer?action=view" : sale != null ? "SaleDashboard.jsp" : "";
        %>

        <nav class="navbar navbar-dark bg-secondary fixed-top px-3">
            <div class="container-fluid d-flex justify-content-between">
                <!-- Logo bên trái -->
                <a class="navbar-brand d-flex align-items-center text-white" href=<%=homePage%>>
                    <i class="fa-solid fa-house text-white me-2"></i>
                    <span class="fw-bold">Home</span>
                </a>

                <!-- Nút Logout bên phải -->
                <button onclick="confirmLogout()" class="btn btn-danger text-white px-3 btn-logout">
                    <i class="fa-solid fa-sign-out-alt me-1"></i> Logout
                </button>
            </div>
        </nav>
        <div id="empty"></div>



        <script>
            function confirmLogout() {
                Swal.fire({
                    title: "Are you sure?",
                    text: "You will be logged out!",
                    icon: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#d33", // Màu đỏ cho nút confirm
                    cancelButtonColor: "#3085d6", // Màu xanh cho nút cancel
                    confirmButtonText: "Yes, Logout!"
                }).then((result) => {
                    if (result.isConfirmed) {
                        window.location.href = "login.jsp?logout=true"; // Chuyển đúng trang logout
                    }
                });
            }
        </script>

    </body>
</html>
