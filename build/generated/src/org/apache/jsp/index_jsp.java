package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("java;charset=UTF-8");
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
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<title>Online Compiler</title>\n");
      out.write("\t\t<link rel=stylesheet href=\"MyStyle.css\">\n");
      out.write("\t</head>\n");
      out.write(" \n");
      out.write("<body>\n");
      out.write("<form method=\"POST\" action=\"NewServlet\"> \n");
      out.write("\t<main>\n");
      out.write("\t\n");
      out.write("\t<div id=\"code\">\n");
      out.write("\t\n");
      out.write("\t\t<div>\n");
      out.write("\t\t<textarea id=\"codeArea\" name=\"codeArea\" placeholder=\"Enter Your Code\">");
 String an=(String)request.getAttribute("code"); if(an!=null)out.print(an);
      out.write("</textarea>\n");
      out.write("\t\t<input type=\"submit\" id=\"runButton\" value=\"Run\"> \n");
      out.write("\t\t\n");
      out.write("\t\t<select style=\"min-height: 40px; min-width: 100px;font-size: 25px;\">\n");
      out.write("                <option value=\"c/cpp\">C/C++</option>\n");
      out.write("                <option value=\"java\">Java</option>\n");
      out.write("                <option value=\"python\">Python</option>\n");
      out.write("        </select>\n");
      out.write("\t\t\n");
      out.write("\t\t<input type=\"checkbox\" id=\"custom\" name=\"custom\" value=\"yes\">\n");
      out.write("\t\t<label for=\"custom\" style=\"font-size:25px;\">Custom Input</label><br>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div id=\"result\">\n");
      out.write("\t\t<div>\n");
      out.write("\t\t<textarea id=\"inputArea\" name=\"inputArea\" placeholder=\"Custom Input\">");
 String a=(String)request.getAttribute("input"); if(a!=null)out.print(a);
      out.write("</textarea>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div>\n");
      out.write("\t\t<textarea disabled class=\"textarea\" id=\"resultArea\" placeholder=\"See Result\">");
 String ans=(String)request.getAttribute("res"); if(ans!=null)out.print(ans);
      out.write("</textarea>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t</main>\n");
      out.write("\t</form>\n");
      out.write("        <script>\n");
      out.write("            if(document.getElementById(\"language\").value==\"java\"){\n");
      out.write("                document.getElementById(\"resultArea\").innerHTML=\"class Main{\\npublic static void main(String[]args){\\n//your code here\\n}\\n}\";\n");
      out.write("            }\n");
      out.write("                    \n");
      out.write("        </script>\n");
      out.write("</body>");
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
