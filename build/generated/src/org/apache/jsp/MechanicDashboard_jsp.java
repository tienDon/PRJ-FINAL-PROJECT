package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class MechanicDashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_if_test.release();
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
      out.write("\n");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write('\n');
      out.write('\n');
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write('\n');
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletRequest request = (HttpServletRequest)_jspx_page_context.getRequest();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.MECHANIC == null }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("    ");
        if (true) {
          _jspx_page_context.forward("MainController" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("action", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("home", request.getCharacterEncoding()));
          return true;
        }
        out.write('\n');
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.MECHANIC !=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\n");
        out.write("    <!DOCTYPE html>\n");
        out.write("    <html>\n");
        out.write("        <head>\n");
        out.write("            <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
        out.write("            <title>JSP Page</title>\n");
        out.write("            <!-- Bootstrap CSS -->\n");
        out.write("            <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
        out.write("\n");
        out.write("            <!-- FontAwesome Icons -->\n");
        out.write("            <script src=\"https://kit.fontawesome.com/a076d05399.js\" crossorigin=\"anonymous\"></script>\n");
        out.write("            <style>\n");
        out.write("                .component {\n");
        out.write("                    display: none; /* Mặc định ẩn */\n");
        out.write("                }\n");
        out.write("                .component.active {\n");
        out.write("                    display: block; /* Hiện khi active */\n");
        out.write("                }\n");
        out.write("                .menu button.active {\n");
        out.write("                    background-color: #007bff;\n");
        out.write("                    color: white;\n");
        out.write("                }\n");
        out.write("                .menu button {\n");
        out.write("                    transition: transform 0.3s ease-out, background-color 0.3s ease-out;\n");
        out.write("                }\n");
        out.write("\n");
        out.write("                .menu button:hover {\n");
        out.write("                    transform: scale(1.1);\n");
        out.write("                }\n");
        out.write("\n");
        out.write("                .menu button:active {\n");
        out.write("                    transform: scale(0.95);\n");
        out.write("                    transition: transform 0.1s ease-out;\n");
        out.write("                }\n");
        out.write("            </style>\n");
        out.write("\n");
        out.write("        </head>\n");
        out.write("        <body>\n");
        out.write("\n");
        out.write("            <div class=\"container mt-5\">\n");
        out.write("\n");
        out.write("\n");
        out.write("                <h1 class=\"text-center\">Hello, ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.MECHANIC.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("!</h1>\n");
        out.write("\n");
        out.write("                <div class=\"text-center mb-3 menu gap-5\">\n");
        out.write("                    <button class=\"btn btn-primary\" id=\"ticket-btn\" data-target=\"section1\"> Tickets</button>\n");
        out.write("                    <button class=\"btn btn-primary\" id=\"services-btn\" data-target=\"section2\"> Services</button>\n");
        out.write("                </div>\n");
        out.write("\n");
        out.write("                <!--TICKETS-->\n");
        out.write("                <div id=\"container-tickets\" class=\"component\">\n");
        out.write("                    <div class=\"card p-4 mb-4\">\n");
        out.write("                        <h4>Search Ticket</h4>\n");
        out.write("                        <form action=\"MainMechanic\" accept-charset=\"utf-8\" method=\"post\">\n");
        out.write("                            <input type=\"hidden\" name=\"searchType\" value=\"ticketMechanic\">\n");
        out.write("                            <div class=\"mb-3\">\n");
        out.write("                                <label for=\"searchid\" class=\"form-label\">Search Ticket</label>\n");
        out.write("                                <input type=\"text\" name=\"txtsearch\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.findname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" id=\"searchid\" class=\"form-control\"/>\n");
        out.write("                            </div>\n");
        out.write("                            <div class=\"mb-3\">\n");
        out.write("                                <label class=\"form-check-label\">Search By:</label>\n");
        out.write("                                <div class=\"form-check\">\n");
        out.write("                                    <input type=\"radio\" name=\"typeSearchTicketMechanic\" value=\"custID\" id=\"custID\" class=\"form-check-input\"/>\n");
        out.write("                                    <label for=\"custID\" class=\"form-check-label\">Customer ID</label>\n");
        out.write("                                </div>\n");
        out.write("                                <div class=\"form-check\">\n");
        out.write("                                    <input type=\"radio\" name=\"typeSearchTicketMechanic\" value=\"carID\" id=\"carID\" class=\"form-check-input\"/>\n");
        out.write("                                    <label for=\"carID\" class=\"form-check-label\">Car ID</label>\n");
        out.write("                                </div>\n");
        out.write("                                <div class=\"form-check\">\n");
        out.write("                                    <input type=\"radio\" name=\"typeSearchTicketMechanic\" value=\"dateReceived\" id=\"dateReceived\" class=\"form-check-input\"/>\n");
        out.write("                                    <label for=\"dateReceived\" class=\"form-check-label\">Date Received</label>\n");
        out.write("                                </div>\n");
        out.write("                            </div>\n");
        out.write("                            <input type=\"submit\" class=\"btn btn-success\" id=\"submitSearchTicket\" name=\"action\" value=\"search\" >\n");
        out.write("                        </form>\n");
        out.write("                    </div>\n");
        out.write("\n");
        out.write("\n");
        out.write("                    <div class=\"table-responsive\">\n");
        out.write("                        <h2 class=\"text-center mb-3\">Service Tickets</h2>\n");
        out.write("                        <table class=\"table table-striped table-bordered\">\n");
        out.write("                            <thead class=\"table-primary\">\n");
        out.write("                                <tr>\n");
        out.write("                                    <th>Service Ticket ID</th>\n");
        out.write("                                    <th>Date Received</th>\n");
        out.write("                                    <th>Date Returned</th>\n");
        out.write("                                    <th>Customer ID</th>\n");
        out.write("                                    <th>Car ID</th>\n");
        out.write("                                    <th>Action</th>\n");
        out.write("                                </tr>\n");
        out.write("                            </thead>\n");
        out.write("                            <tbody>\n");
        out.write("\n");
        out.write("                                ");
        if (_jspx_meth_c_if_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_1, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                                ");
        if (_jspx_meth_c_if_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_1, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                            </tbody>\n");
        out.write("                        </table>\n");
        out.write("\n");
        out.write("                    </div>\n");
        out.write("\n");
        out.write("                </div>\n");
        out.write("\n");
        out.write("                <!--SERVICES-->\n");
        out.write("                <div id=\"container-services\" class=\"component\" >\n");
        out.write("                    service\n");
        out.write("                </div>\n");
        out.write("\n");
        out.write("            </div>\n");
        out.write("\n");
        out.write("            <script>\n");
        out.write("                document.addEventListener(\"DOMContentLoaded\", function () {\n");
        out.write("                    let ticketContainer = document.getElementById(\"container-tickets\");\n");
        out.write("                    let serviceContainer = document.getElementById(\"container-services\");\n");
        out.write("\n");
        out.write("                    // Ẩn tất cả container ban đầu\n");
        out.write("                    ticketContainer.style.display = \"none\";\n");
        out.write("                    serviceContainer.style.display = \"none\";\n");
        out.write("\n");
        out.write("                    // Kiểm tra trạng thái đã lưu trong localStorage\n");
        out.write("                    let activeSection = localStorage.getItem(\"activeSection\");\n");
        out.write("                    if (activeSection === \"tickets\") {\n");
        out.write("                        ticketContainer.style.display = \"block\";\n");
        out.write("                        serviceContainer.style.display = \"none\";\n");
        out.write("                    } else if (activeSection === \"services\") {\n");
        out.write("                        serviceContainer.style.display = \"block\";\n");
        out.write("                        ticketContainer.style.display = \"none\";\n");
        out.write("                    }\n");
        out.write("\n");
        out.write("                    // Xử lý khi nhấn nút Ticket\n");
        out.write("                    document.getElementById(\"ticket-btn\").addEventListener(\"click\", function (event) {\n");
        out.write("                        event.preventDefault();\n");
        out.write("                        if (ticketContainer.style.display == \"block\") {\n");
        out.write("                            ticketContainer.style.display = \"none\";\n");
        out.write("                        } else {\n");
        out.write("                            ticketContainer.style.display = \"block\";\n");
        out.write("                            serviceContainer.style.display = \"none\";\n");
        out.write("                        }\n");
        out.write("                        localStorage.setItem(\"activeSection\", \"tickets\"); // Lưu trạng thái\n");
        out.write("                    });\n");
        out.write("\n");
        out.write("                    // Xử lý khi nhấn nút Services\n");
        out.write("                    document.getElementById(\"services-btn\").addEventListener(\"click\", function (event) {\n");
        out.write("                        event.preventDefault();\n");
        out.write("                        if (serviceContainer.style.display == \"block\") {\n");
        out.write("                            serviceContainer.style.display = \"none\";\n");
        out.write("                        } else {\n");
        out.write("                            ticketContainer.style.display = \"none\";\n");
        out.write("                            serviceContainer.style.display = \"block\";\n");
        out.write("                        }\n");
        out.write("                        localStorage.setItem(\"activeSection\", \"services\"); // Lưu trạng thái\n");
        out.write("                    });\n");
        out.write("                });\n");
        out.write("\n");
        out.write("            </script>\n");
        out.write("        </body>\n");
        out.write("    </html>\n");
        out.write("\n");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.serviceList!=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    ");
        if (_jspx_meth_c_forEach_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_2, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_2);
    _jspx_th_c_forEach_0.setItems(new String("requestScope.serviceList"));
    _jspx_th_c_forEach_0.setVar("t");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                        <tr>\n");
          out.write("                                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${t.serviceTicketID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ t.dateReceived()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${t.dateReturned()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${t.custID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                            <td><");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${t.carID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        </tr>\n");
          out.write("                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.serviceList==null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.ERROR}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
    return false;
  }
}
