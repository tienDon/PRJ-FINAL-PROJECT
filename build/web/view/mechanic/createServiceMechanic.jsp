<%-- 
    Document   : CreateMechanic
    Created on : Mar 15, 2025, 3:36:08 PM
    Author     : ASUS
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    </head>
    <body>

        <div class="container mt-4">
            <h3>Create New Service</h3>
            <form action="MainMechanic" method="post" accept-charset="utf-8">

                <div class="mb-3">
                    <label for="serviceName" class="form-label">Service Name</label>
                    <input type="text" id="serviceName" name="serviceName" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label for="hourlyRate" class="form-label">Hourly Rate</label>
                    <input type="number" step="0.01" id="hourlyRate" name="hourlyRate" class="form-control" required>
                </div>

                <!--<input type="submit" name="action" value="Create">-->
                
                <input type="submit" name="action" value="Create" class="btn btn-success">
                <button type="button" class="btn btn-secondary" onclick="history.back();">Back</button>
            </form>
        </div>
    </body>
</html>
