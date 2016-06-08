<!DOCTYPE html>
<%@page import="model.Insurer"%>
<%@page import="dao_jdbc.InsurerDAOImpl"%>
<%@page import="dao_api.InsurerDAO"%>

<%
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    }
	 catch (Exception e) {
	    throw new UnavailableException(e.getMessage());
	 }
%>

<html>
	<head>
		<%
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
		%>
		<title><%=userName %></title>
		<%@ page contentType="text/html; charset=UTF-8" %>
		<link href = "style.css" type="text/css" rel = "stylesheet"/>
		<script src="//code.jquery.com/jquery-1.10.2.js"></script>
		
		<script type="text/javascript">
			$(document).ready(function(){
				$('.viewInsurers ');
				$.post("foo",JSON.stringify({id:5,name:"Nikos",address:{city:"Athens"}}));
			});
		</script>
	</head>
	
	<body>
		<div class="menu">
			<ul class="menu-nav">
				<li><a href="adminPanel.jsp">Добави</a>
					<ul>
						<li><a href="adminPanelAddInsurer.jsp">Застрахователен агент</a></li>
					</ul>
				</li>
				<li><a href="adminPanelSettings.jsp">Настройки</a></li>
				<li><a href="adminPanelInsurers.jsp">Застрахователни агенти</a></li>
				<li><a href="/logout">Изход</a></li>
			</ul>
		</div>
		
		<div class="viewInsurers shell">
		<form action = "updateInsurer" method="get">
			<table border="1">
				<th>ID</th>
				<th>Име</th>
				<th>Фамилия</th>
				<th>Е-майл</th>
				<th>Парола</th>
				
				<%
					InsurerDAO insurers = new InsurerDAOImpl();
					for(Insurer insurer : insurers.listInsurers()) { %>
					<tr>
						<td><%=insurer.getInsurerId()%></td>
						<td><%=insurer.getInsurerName()%></td>
						<td><%=insurer.getInsurerFamily()%></td>
						<td><%=insurer.getInsurerEmail()%></td>
						<td><%=insurer.getInsurerPassword()%></td>
						<td><input type="submit" value="Промени" name="update"></td>
						<td><input type="submit" value="Изтрий" name="delete"></td>
					</tr>
			</form>
				<% } %>
			</table>
		</div>
	</body>
</html>