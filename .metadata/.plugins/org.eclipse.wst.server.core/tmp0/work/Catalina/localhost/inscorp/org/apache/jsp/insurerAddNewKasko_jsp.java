/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
 * Generated at: 2016-03-22 21:23:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.VehicleColor;
import dao_jdbc.VehicleColorDAOImpl;
import dao_api.VehicleColorDAO;
import dao_jdbc.VehicleTypeDAOImpl;
import dao_api.VehicleTypeDAO;
import model.VehicleType;

public final class insurerAddNewKasko_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/D:/TU/DiplomnaRabota/inscorp-dr/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/inscorp/WEB-INF/lib/jstl-1.2.jar!/META-INF/c-1_0.tld", Long.valueOf(1153374282000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1458163699867L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("model.VehicleColor");
    _jspx_imports_classes.add("dao_jdbc.VehicleTypeDAOImpl");
    _jspx_imports_classes.add("dao_api.VehicleColorDAO");
    _jspx_imports_classes.add("dao_api.VehicleTypeDAO");
    _jspx_imports_classes.add("model.VehicleType");
    _jspx_imports_classes.add("dao_jdbc.VehicleColorDAOImpl");
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
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>InsuranceCorporation</title>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<link href = \"style.css\" type=\"text/css\" rel = \"stylesheet\"/>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css\">\r\n");
      out.write("\t\t<script src=\"//code.jquery.com/jquery-1.10.2.js\"></script>\r\n");
      out.write("\t\t<script src=\"//code.jquery.com/ui/1.11.4/jquery-ui.js\"></script>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/resources/demos/style.css\">\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\t$(function() {\r\n");
      out.write("\t\t\t\t$( \"#datepicker\" ).datepicker({\r\n");
      out.write("\t\t\t\t\tdateFormat: \"yy-mm-dd\",\r\n");
      out.write("\t\t\t\t\tonSelect: function(datetext){\r\n");
      out.write("\t\t\t\t\t\t$(this).val(datetext); }\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\tfunction addList(){\r\n");
      out.write("\t\t\t\tvar date = new Date();\r\n");
      out.write("\t\t\t    var selectVehicleYear = document.getElementById(\"year\");\r\n");
      out.write("\t\t\t    for(var i = date.getFullYear(); i >= date.getFullYear()-20; --i) {\r\n");
      out.write("\t\t\t\t    var option = document.createElement('option');\r\n");
      out.write("\t\t\t\t    option.text = option.value = i;\r\n");
      out.write("\t\t\t\t    selectVehicleYear.add(option, 0);\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t    \r\n");
      out.write("\t\t\t    var vehicleType = ['Автомобил', 'Камион', 'Мотоциклет', 'Автобус'];\r\n");
      out.write("\t\t\t    var selectVehicleType = document.getElementById('vehicleType');\r\n");
      out.write("\t\t\t    for(var i=0; i<vehicleType.length; i++) {\r\n");
      out.write("\t\t\t    \tvar option = document.createElement('option');\r\n");
      out.write("\t\t\t    \toption.text = option.value = vehicleType[i];\r\n");
      out.write("\t\t\t    \tselectVehicleType.add(option, 0);\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t    \r\n");
      out.write("\t\t\t    var vehicleEngine = [1.4, 1.6, 1.8, 2.0];\r\n");
      out.write("\t\t\t    var selectVehicleEngine = document.getElementById(\"vehicleEngine\");\r\n");
      out.write("\t\t\t    for(var i=0; i<vehicleEngine.length; i++) {\r\n");
      out.write("\t\t\t    \tvar option = document.createElement('option');\r\n");
      out.write("\t\t\t    \toption.text = option.value = vehicleEngine[i];\r\n");
      out.write("\t\t\t    \tselectVehicleEngine.add(option, 0);\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t\r\n");
      out.write("\t<body onload=\"addList()\">\r\n");
      out.write("\t\t<div class=\"menu\">\r\n");
      out.write("\t\t\t<div class=\"menu-nav\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"insurer.jsp\">Нова застраховка</a>\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">Гражданска отговорност</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"insurerAddNewKasko.jsp\">Каско</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Търсене</a>\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">Гражданска отговорност</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">Каско</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"insurerSettings.jsp\">Настройки</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Изход</a>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"newKasko\">\r\n");
      out.write("\t\t\t<div class=\"shell\">\r\n");
      out.write("\t\t\t\t<h3>Сключване на застраховка \"Каско\"</h3>\r\n");
      out.write("\t\t\t\t<form method=\"post\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form-section\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t<label>№ на застраховка</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"field\" name=\"insurenceID\" placeholder=\"№ на застраховка\" size=\"30\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-section\">\r\n");
      out.write("\t\t\t\t\t\t<h4>Застрахован</h4>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t<label>Собственик</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"field\" name=\"insuredFirstName\" placeholder=\"Име\" size=\"30\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"field\" name=\"insuredSecondName\" placeholder=\"Презиме\" size=\"30\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"field\" name=\"insuredLastName\" placeholder=\"Фамилия\" size=\"30\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"EGN\">ЕГН</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"field\" name=\"EGN\" placeholder=\"ЕГН\" size=\"30\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"mobilePhone\">Мобилен телефон</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"field\" name=\"mobilePhone\" placeholder=\"Мобилен телефон\" size=\"30\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-row-inner form-row-inner-long\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label for=\"address\">Адрес на собственика</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"field\" name=\"address\" placeholder=\"гр. ж.к. ул. бл. вх. ет. ап.\" size=\"50\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-row-inner\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label for=\"pKod\">Пощенски код</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"field\" name=\"pKod\" placeholder=\"Пощенски код\" size=\"20\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-section\">\r\n");
      out.write("\t\t\t\t\t\t<h4>Данни за МПС</h4>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"registrationNumber\">Регистрационен №</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"field\" name=\"registrationNumber\" placeholder=\"Регистрационен №\" size=\"20\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-row-inner\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label for=\"vehicleType\">Вид МПС</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"vehicleType\" name=\"vehicleType\"></select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-row-inner\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label for=\"ramaN\">Рама №</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"field\" name=\"ramaN\" placeholder=\"Рама №\" size=\"30\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-row-inner\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label for=\"vehicleBrand\">Марка</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<select>\r\n");
      out.write("\t\t\t\t\t\t\t\t");

							   		VehicleTypeDAO types = new VehicleTypeDAOImpl();
									for(VehicleType type : types.listAllVehicleTypes()) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option>");
      out.print(type.getVehicleType() );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-row-inner\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>Модел</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"field\" name=\"vehicleModel\" placeholder=\"Модел\" size=\"30\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-row-inner\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>Цвят</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<select>\r\n");
      out.write("\t\t\t\t\t\t\t\t");

									VehicleColorDAO colors = new VehicleColorDAOImpl();
									for(VehicleColor color : colors.listAllVehicleColors()) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option>");
      out.print(color.getVehicleColor() );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-row-inner\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>Година на производство</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"year\" name=\"year\"></select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-row-inner\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>Дата на първа регистрация</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"field\" name=\"vehicleFirstReg\" placeholder=\"Дата на първа регистрация\" id=\"datepicker\" size=\"30\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-row-inner\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>Обем на двигателя</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"vehicleEngine\" name=\"vehicleEngine\"></select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-row-inner\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>Брой места</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"vehiclePlaces\" name=\"vehiclePlaces\"></select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t<label>Застрахоателна сума</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"field\" name=\"vehicleInsValue\" placeholder=\"Застрахователна сума\" size=\"30\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t<label>Застрахователна премия</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"field\" name=\"vehicleInsPremiq\" placeholder=\"Застрахователна премия\" size=\"30\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"Сключи застраховка\">\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
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