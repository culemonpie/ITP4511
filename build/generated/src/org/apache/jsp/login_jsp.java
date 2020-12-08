package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String message = (String) request.getAttribute("message");
    String title = "Login";

      out.write("\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/header.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("title", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(title), request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("<div class=\"py-3\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("\t<div class=\"row\">\r\n");
      out.write("\t    <div class=\"col-12 col-md-6 mx-auto\">\r\n");
      out.write("\r\n");
      out.write("\t\t");
      //  ivpet:Alert
      ivpet.tag.Alert _jspx_th_ivpet_Alert_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(ivpet.tag.Alert.class) : new ivpet.tag.Alert();
      _jspx_th_ivpet_Alert_0.setJspContext(_jspx_page_context);
      _jspx_th_ivpet_Alert_0.setMessage(message);
      _jspx_th_ivpet_Alert_0.setContext("danger");
      _jspx_th_ivpet_Alert_0.doTag();
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<h5>");
      out.print(title);
      out.write("</h5>\r\n");
      out.write("\t\t<form class=\"form-signin\" action=\"loginServlet\" method=\"post\">\r\n");
      out.write("\t\t    <div class=\"form-label-group\">\r\n");
      out.write("\t\t\t<label for=\"inputEmail\">Username</label>\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"username\" id=\"username\" class=\"form-control\" placeholder=\"Username\" required autofocus>\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\r\n");
      out.write("\t\t    <div class=\"form-label-group\">\r\n");
      out.write("\t\t\t<label for=\"inputPassword\">Password</label>\r\n");
      out.write("\t\t\t<input type=\"password\" name=\"password\" id=\"password\" class=\"form-control\" placeholder=\"Password\" required>\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\r\n");
      out.write("\t\t    <button class=\"btn btn-lg btn-primary btn-block mt-1\" type=\"submit\">Log in</button>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t</div>\r\n");
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
