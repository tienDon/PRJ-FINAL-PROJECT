package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"MainController\" accept-charset=\"utf-8\" method=\"post\" id=\"myForm\">\n");
      out.write("            <input type=\"checkbox\" id=\"checkrole\" value=\"customer\" name=\"role\">\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"name\">Name:</label>\n");
      out.write("                <input type=\"text\" id=\"name\" name=\"txtname\" required />\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group\" id=\"phoneField\">\n");
      out.write("                <label for=\"phone\">Phone:</label>\n");
      out.write("                <input type=\"text\" id=\"phone\" name=\"txtphone\"  />\n");
      out.write("            </div>\n");
      out.write("            <input type=\"submit\" name=\"action\" value=\"login\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            const role = document.getElementById(\"checkrole\");\n");
      out.write("            const phone = document.getElementById(\"phone\");\n");
      out.write("            const form = document.getElementById(\"myForm\");\n");
      out.write("            const phoneField = document.getElementById(\"phoneField\");\n");
      out.write("            // Xử lý khi click vào checkbox\n");
      out.write("            role.addEventListener(\"click\", () => {\n");
      out.write("                if (role.checked) {\n");
      out.write("                    role.value = \"staff\";\n");
      out.write("                    phoneField.style.display = \"none\";\n");
      out.write("                    phone.value = \"\"; // Xóa giá trị nhập vào\n");
      out.write("                } else {\n");
      out.write("                    role.value = \"customer\";\n");
      out.write("                    phoneField.style.display = \"block\";\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            // Xóa giá trị phone khi submit form\n");
      out.write("            form.addEventListener(\"submit\", () => {\n");
      out.write("                if (role.checked) {\n");
      out.write("                    phone.removeAttribute(\"name\"); // Đảm bảo không có name khi submit\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
