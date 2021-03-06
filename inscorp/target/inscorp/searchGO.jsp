<!DOCTYPE html>
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
			<div class="menu-nav">
				<ul>
					<li><a href="#">Нова застраховка</a>
						<ul>
							<li><a href="insurerAddNewGO.jsp">Гражданска отговорност</a></li>
							<li><a href="insurerAddNewKasko.jsp">Каско</a></li>
						</ul>
					</li>
					<li><a href="#">Търсене</a>
						<ul>
							<li><a href="#">Гражданска отговорност</a>
								<ul>
									<li><a href="searchGO.jsp">Търсене по №</a></li>
									<li><a href="seachGOByInsurer.jsp">Търсене по текущ застраховател</a></li>
									<li><a href="searchGOAll.jsp">Изведи всички</a></li>
								</ul>
							</li>
							<li><a href="#">Каско</a>
								<ul>
									<li><a href="searchInsKaskoByID.jsp">Търсене по №</a></li>
									<li><a href="searchKaskoByInsurer.jsp">Търсене по текущ застраховател</a></li>
									<li><a href="searchAllKasko.jsp">Изведи всички</a></li>
								</ul>
							</li>
						</ul>
					</li>
					<li><a href="#">Редакция</a>
						<ul>
							<li><a href="insurerGoUpdateSearch.jsp">Гражданска отговорност</a></li>
							<li><a href="insurerKaskoUpdateSearch.jsp">Каско</a></li>
						</ul>
					</li>
					<li><a href="insurerSettings.jsp">Настройки</a></li>
					<li><a href="logout">Изход</a>
				</ul>
			</div>
		</div>
		
		<div class="searchByID">
			<div class="shell">
				<form action="searchByID" method="get">
					<div class="form-section">
						<div class="form-row">
							<h3>Търсене на застраховка "Гражданска отговорност" по № на полица</h3>
							<label>№ на полица</label>
							<input class="field" type="text" name="searchByID" placeholder="Въведете № на полица" >
							<input type="submit" value="Намери" name="searchByID">
						</div>
					</div>				
				</form>	
			</div>
		</div>
	</body>
</html>