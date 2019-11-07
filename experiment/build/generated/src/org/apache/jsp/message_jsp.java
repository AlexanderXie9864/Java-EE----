package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.javabean.Message;
import com.dao.*;

public final class message_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=gb2312");
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
      out.write("\n");
      out.write(" \n");
      out.write("<html>\n");
      out.write("  <head>  \n");
      out.write("    <title>留言板界面</title>\n");
      out.write("  </head>\n");
      out.write(" \n");
      out.write("  <body>\n");
      out.write("        ");

        if((String)session.getAttribute("username")==null)
            response.sendRedirect("login.jsp");
     
      out.write("\n");
      out.write("     <div>\n");
      out.write("         <a href=\"LogoutServlet\">退出登录</a>\n");
      out.write("     </div>\n");
      out.write("  <div style=\"margin-left:30%;margin-top:100px;\">       \n");
      out.write("  \t\t<table border=\"0.5\">\n");
      out.write("                    \n");
      out.write("                    <tr><th>留言人</th>                     \n");
      out.write("                        <th>留言标题</th>\n");
      out.write("                        <th>留言时间</th>\n");
      out.write("                        <th>留言内容</th>\n");
      out.write("                        <th>操作</th></tr>\n");
      out.write("  \t\t");

  			List<Message> msgs=(List)session.getAttribute("msgs");
  			if(msgs!=null){
  				Iterator iter=msgs.iterator();
  				while(iter.hasNext()){
  				Message msg=(Message)iter.next();
  		
      out.write("\n");
      out.write("                        <tr><td>");
      out.print( msg.getUsername() );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( msg.getDatetimestamp());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( msg.getTitle() );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( msg.getMessage() );
      out.write("</td>\n");
      out.write("                            <td><a href=\"DeleteMessageServlet?datetimestamp=");
      out.print( msg.getDatetimestamp() );
      out.write("\">删除</a></td>\n");
      out.write("                        </tr>\n");
      out.write("  \t\t");
 
  			}
  			}
  		 
      out.write("\n");
      out.write("  \t\t</table>\n");
      out.write("  </div>\n");
      out.write("                \n");
      out.write("   <div style=\"margin-left:30%;margin-top:50px;\">    \n");
      out.write("   <form action=\"MessageServlet\" method=\"post\">\n");
      out.write("            <table border=\"1\">\n");
      out.write("            <caption>填写留言信息</caption>\n");
      out.write("            <tr><td>留言标题</td>\n");
      out.write("                    <td><input type=\"text\" name=\"title\"/></td></tr>\n");
      out.write("            <tr><td>留言内容</td>\n");
      out.write("                    <td><textarea name=\"message\" rows=\"5\" cols=\"35\"></textarea></td>\n");
      out.write("            </tr>\n");
      out.write("            </table>\n");
      out.write("  \t\t<input type=\"submit\" value=\"提 交\"/>\n");
      out.write("  \t\t<input type=\"reset\" value=\"清 空\"/>\n");
      out.write("  \t</form>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("  </body>\n");
      out.write("  \n");
      out.write("   \n");
      out.write("\n");
      out.write("          \n");
      out.write("      \n");
      out.write("\n");
      out.write("  \n");
      out.write("</html>\n");
      out.write("\n");
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
