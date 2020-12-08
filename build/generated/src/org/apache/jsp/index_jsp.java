package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ivpet.db.AssignmentDB;
import ivpet.bean.EquipmentBean;
import java.util.ArrayList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/tlds/ivpet_tags.tld");
  }

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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    String message = (String) request.getAttribute("message");
    
    AssignmentDB db = new AssignmentDB();
    ArrayList<EquipmentBean> equipments = db.listAllEquipment();
    

      out.write("\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/header.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("title", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("Home", request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("<div class=\"py-3\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-12\">\r\n");
      out.write("                ");
      //  ivpet:Alert
      ivpet.tag.Alert _jspx_th_ivpet_Alert_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(ivpet.tag.Alert.class) : new ivpet.tag.Alert();
      _jspx_th_ivpet_Alert_0.setJspContext(_jspx_page_context);
      _jspx_th_ivpet_Alert_0.setMessage(message);
      _jspx_th_ivpet_Alert_0.setContext("success");
      _jspx_th_ivpet_Alert_0.doTag();
      out.write("\r\n");
      out.write("                <h2 class=\"\">IVPET <small class=\"text-muted\">Equipment Borrowing System</small></h2>\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" placeholder='Enter search keyword...'>\r\n");
      out.write("                <hr>\r\n");
      out.write("                <table class=\"table table-extra-condensed\">\r\n");
      out.write("\r\n");
      out.write("                    ");
 for (EquipmentBean equipment : equipments) {
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/inventory/view.jsp?id=");
      out.print(equipment.getid());
      out.write('"');
      out.write('>');
      out.print(equipment.getid());
      out.write("</a></td>\r\n");
      out.write("                        <td>");
      out.print(equipment.getname());
      out.write("</td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/addToCart?id=");
      out.print(equipment.getid());
      out.write("\" class=\"btn btn-primary btn-sm\">Add</a>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    ");
 }
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </table>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/footer.jsp", out, false);
      out.write("          \r\n");
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
