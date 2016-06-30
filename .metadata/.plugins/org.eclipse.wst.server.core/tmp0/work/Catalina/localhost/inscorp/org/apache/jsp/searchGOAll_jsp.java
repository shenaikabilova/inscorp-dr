/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
 * Generated at: 2016-06-30 17:47:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.GrajdanskaOtgovornost;
import dao_jdbc.GrajdanskaOtgovornostDAOImpl;
import dao_api.GrajdanskaOtgovornostDAO;

public final class searchGOAll_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("model.GrajdanskaOtgovornost");
    _jspx_imports_classes.add("dao_api.GrajdanskaOtgovornostDAO");
    _jspx_imports_classes.add("dao_jdbc.GrajdanskaOtgovornostDAOImpl");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    }
	 catch (Exception e) {
	    throw new UnavailableException(e.getMessage());
	 }

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t");

			String userName = null;
			Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				for(Cookie cookie: cookies) {
					if(cookie.getName().equals("user")) {
						userName = cookie.getValue();
					}
				}
			}
			if(userName == null) {
				response.sendRedirect("login.jsp");
			}
		
      out.write("\r\n");
      out.write("\t\t<title>");
      out.print(userName );
      out.write("</title>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<link href = \"style.css\" type=\"text/css\" rel = \"stylesheet\"/>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div class=\"menu\">\r\n");
      out.write("\t\t\t<div class=\"menu-nav\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Нова застраховка</a>\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"insurerAddNewGO.jsp\">Гражданска отговорност</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"insurerAddNewKasko.jsp\">Каско</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Търсене</a>\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">Гражданска отговорност</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"searchGO.jsp\">Търсене по №</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"seachGOByInsurer.jsp\">Търсене по текущ застраховател</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"searchGOAll.jsp\">Изведи всички</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">Каско</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"searchInsKaskoByID.jsp\">Търсене по №</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"searchKaskoByInsurer.jsp\">Търсене по текущ застраховател</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"searchAllKasko.jsp\">Изведи всички</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Редакция</a>\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"insurerGoUpdateSearch.jsp\">Гражданска отговорност</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"insurerKaskoUpdateSearch.jsp\">Каско</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"insurerSettings.jsp\">Настройки</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"logout\">Изход</a>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"searchInsurers viewInsurers shell\">\r\n");
      out.write("\t\t\t<table border=\"1\">\r\n");
      out.write("\t\t\t\t<th>Застраховател</th> \r\n");
      out.write("\t\t\t\t<th>Полица №</th>\r\n");
      out.write("\t\t\t\t<th>Тип</th>  \r\n");
      out.write("\t\t\t\t<th>Име</th>  \r\n");
      out.write("\t\t\t\t<th>Презиме</th>  \r\n");
      out.write("\t\t\t\t<th>Фамилия</th>  \r\n");
      out.write("\t\t\t\t<th>ЕГН</th>  \r\n");
      out.write("\t\t\t\t<th>Държава</th>  \r\n");
      out.write("\t\t\t\t<th>Адрес</th>  \r\n");
      out.write("\t\t\t\t<th>Пощенски код</th>  \r\n");
      out.write("\t\t\t\t<th>Мобилен телефон</th>\r\n");
      out.write("\t\t\t\t<th>Регистрационен №</th> \r\n");
      out.write("\t\t\t\t<th>Зона</th> \r\n");
      out.write("\t\t\t\t<th>Тип</th>  \r\n");
      out.write("\t\t\t\t<th>Рама</th> \r\n");
      out.write("\t\t\t\t<th>Марка</th>  \r\n");
      out.write("\t\t\t\t<th>Модел</th>  \r\n");
      out.write("\t\t\t\t<th>Дата от:</th>\r\n");
      out.write("\t\t\t\t<th>Дата до:</th>\r\n");
      out.write("\t\t\t\t<th>Брой месеци</th>\r\n");
      out.write("\t\t\t\t<th>Застрахователна стойност</th>  \r\n");
      out.write("\t\t\t\t<th>Застрахователна премия</th>  \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t");

					GrajdanskaOtgovornostDAO searchAll = new GrajdanskaOtgovornostDAOImpl();
					for(GrajdanskaOtgovornost all : searchAll.listGO()) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(all.getInsurerID());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(all.getInsurenceGrajdanskaOtgovornostID());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(all.getInsurenceType());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(all.getInsurenceFirstName());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(all.getInsurenceSecondName());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(all.getInsurenceLastName());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(all.getInsurenceEGN());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(all.getInsurenceCountry());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(all.getInsurenceAddress());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(all.getInsurencePK());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(all.getInsurenceMobilePhone());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(all.getVehicleRegNumber());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(all.getZone());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(all.getVehicleType());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(all.getVehicleRama());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(all.getVehicleBrand());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(all.getVehicleModel());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(all.getInsurenceDateFrom());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(all.getInsurenceDateTo());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(all.getInsurenceMonths());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(all.getInsurenceValue());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(all.getInsurencePremiq());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
