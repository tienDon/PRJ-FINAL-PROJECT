<%-- 
    Document   : invoiceDetailCus
    Created on : Mar 15, 2025, 8:16:51 PM
    Author     : ASUS
--%>

<%@page import="DTO.InvoiceDTO"%>
<%@page import="dao.InvoiceDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        
    </head>
    <body style="margin-top: 30px">
        <jsp:include page="navbar.jsp"/>


        <%
            String invoiceID = request.getParameter("invoiceID");
            InvoiceDAO dao = new InvoiceDAO();
            InvoiceDTO invoice = dao.getInvoiceDetail(invoiceID);
        %>

        <div class="container mt-4">
            <div class="card">
                <div class="card-header bg-dark text-white">
                    <h4 class="text-center">Invoice Details</h4>
                </div>
                <div class="card-body">
                    <p><strong>Invoice ID:</strong> <%= invoiceID%></p>
                    <p><strong>Invoice Date:</strong> <%= invoice.getInvoice().getInvoiceDate()%></p>
                    <p><strong>Car ID:</strong> <%= invoice.getInvoice().getCarID()%></p>
                    <p><strong>Sales Name:</strong> <%= invoice.getSalesName()%></p>
                    <p><strong>Customer Name:</strong> <%= invoice.getCustName()%></p>
                </div>
                <div class="card-footer text-center">
                    <button class="btn btn-secondary" onclick="history.back()">Back</button>
                </div>
            </div>
        </div>
    </body>
</html>
