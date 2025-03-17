<%-- 
    Document   : login
    Created on : Mar 15, 2025, 2:13:29 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>

        <%
            if ("true".equals(request.getParameter("logout"))) {
                session.invalidate(); // Xóa session
        %>
        <div class="alert alert-success">
            You have been logged out successfully.
        </div>
        <%
            }
        %>

        <div class="container">
            <h2>Login</h2>

            <div class="toggle-container">
                <label class="toggle-label">Customer</label>
                <label class="toggle-switch">
                    <input type="checkbox" id="roleSwitch" onchange="updateForm()" />
                    <span class="slider"></span>
                </label>
                <label class="toggle-label">Staff</label>
            </div>

            <form id="loginForm" action="MainController" accept-charset="utf-8">
                <input type="hidden" name="role" value="customer" id="role">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" id="name" name="txtname" required />
                </div>

                <div class="form-group" id="phoneField">
                    <label for="phone">Phone:</label>
                    <input type="text" id="phone" name="txtphone" required />
                </div>

                <button type="submit" name="action" value="login">Login</button>
            </form>
            
            ${requestScope.ERROR}
        </div>

        <script>
            function updateForm() {
                var roleSwitch = document.getElementById("roleSwitch");
                var role = document.getElementById("role");
                var phoneField = document.getElementById("phoneField");
                var loginForm = document.getElementById("loginForm");

                if (roleSwitch.checked) {
                    // Nếu chọn Admin, ẩn phone và gửi form đến AdminServlet
                    phoneField.classList.add("hidden");
                    document.getElementById("phone").removeAttribute("required");
                    role.value = "mechanic"
                } else {
                    // Nếu chọn Customer, hiển thị phone và gửi form đến CusServlet
                    phoneField.classList.remove("hidden");
                    document.getElementById("phone").setAttribute("required", "true");
                    role.value = "customer";
                }
            }

        // Xóa tham số "logout=true" khỏi URL sau khi hiển thị alert
        if (window.history.replaceState) {
            let newUrl = window.location.origin + window.location.pathname;
            window.history.replaceState(null, null, newUrl);
        }

        </script>

    </body>
</html>
