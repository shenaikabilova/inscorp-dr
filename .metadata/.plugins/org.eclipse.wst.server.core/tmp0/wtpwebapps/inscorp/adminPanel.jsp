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
				<li><a href="login.jsp">Изход</a></li>
			</ul>
		</div>
		<h3></h3>
	</body>
</html>