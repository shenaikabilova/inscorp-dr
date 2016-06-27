<!DOCTYPE html>
<%@page import="dao_jdbc.VehicleTypeDAOImpl"%>
<%@page import="model.VehicleType"%>
<%@page import="dao_api.VehicleTypeDAO"%>
<%@page import="dao_jdbc.InsurerTypeDAOImpl"%>
<%@page import="dao_api.InsurerTypeDAO"%>
<%@page import="model.InsurerType"%>
<%@page import="dao_jdbc.CountryDAOImpl"%>
<%@page import="dao_api.CountryDAO"%>
<%@page import="model.Country"%>
<%@page import="model.VehicleBrand"%>
<%@page import="dao_jdbc.VehicleBrandDAOImpl"%>
<%@page import="dao_api.VehicleBrandDAO"%>
<%@page import="model.VehicleColor"%>
<%@page import="dao_jdbc.VehicleColorDAOImpl"%>
<%@page import="dao_api.VehicleColorDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

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
		
		<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
		<script src="//code.jquery.com/jquery-1.10.2.js"></script>
		<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
		<link rel="stylesheet" href="/resources/demos/style.css">
		<script src="js/Kasko/calendarKasko.js"></script>
		<script type="text/javascript" src="js/Kasko/setKaskoSettings.js"></script>
		<script src="js/Kasko/setKaskoValue.js"></script>
		<script src="js/validate.js"></script>
	</head>
	
	<body onload="addList()">
		<div class="menu">
			<div class="menu-nav">
				<ul>
					<li><a href="insurer.jsp">Нова застраховка</a>
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
		
		<div class="newKasko">
			<div class="shell">
				<h3>Сключване на застраховка "Каско"</h3>
				<form action="addNewKasko" method="post">
					<div class="form-section">
						<div class="form-row">
							<label>Застраховател №</label>
							<input class="field" type="text" value=<%=userName%> name="userName" readonly="readonly" maxlength="6">
						</div>
						<div class="form-row">
							<label>№ на полица</label>
							<input type="text" id="insurenceID" class="field" name="insurenceID" size="30" maxlength="6" readonly="readonly">
						</div>
					</div>
					<div class="form-section">
						<h4>Застрахован</h4>
						<div class="form-row">
							<label>Тип на клиента</label>
							<select id="insType" class="field" name="insType">
								<%
								InsurerTypeDAO insTypes = new InsurerTypeDAOImpl();
								for(InsurerType type : insTypes.listInsurerTypes()) { %>
									<option><%=type.getInsurerType() %></option>
								<%} %>
							</select>
						</div>
						<div class="form-row">
							<label>Собственик</label>
							<input type="text" class="field" name="insuredFirstName" placeholder="Име" size="30" maxlength="50">
							<input type="text" class="field" name="insuredSecondName" placeholder="Презиме" size="30" maxlength="50">
							<input type="text" class="field" name="insuredLastName" placeholder="Фамилия" size="30" maxlength="50">
						</div>
						<div class="form-row">
							<label for="EGN">ЕГН</label>
							<input type="text" id="EGN" class="field" name="EGN" placeholder="ЕГН" size="30" maxlength="10">
						</div>
						<div class="form-row">
							<label for="mobilePhone">Мобилен телефон</label>
							<input type="text" class="field" name="mobilePhone" placeholder="Мобилен телефон" size="30" maxlength="10">
						</div>
<!-- 						<div class="form-row"> -->
<!-- 							<label>Държава</label> -->
<!-- 							<select class="field"> -->
<%-- 								<% -
// 									CountryDAO countries = new CountryDAOImpl();
<%-- 									for(Country country : countries.listCountries()) { %> --%>
<%-- 										<option><%=country.getCountry() %></option> --%>
<%-- 									<%} %> --%>
<!-- 							</select> -->
<!-- 						</div> -->
						<div class="form-row">
							<div class="form-row-inner">
								<label for="address">Адрес на собственика</label>
								<input type="text" class="field" name="address" placeholder="гр. ж.к. ул. бл. вх. ет. ап." size="50" maxlength="200">
							</div> 
							<div class="form-row-inner">
								<label for="pKod">Пощенски код</label>
								<input type="text" class="field" name="pKod" placeholder="Пощенски код" size="20" maxlength="4">
							</div>
						</div>
					</div>
					<div class="form-section">
						<h4>Данни за МПС</h4>
						<div class="form-row">
							<label for="registrationNumber">Регистрационен №</label>
							<input type="text" id="registrationNumber" class="field" name="registrationNumber" placeholder="Регистрационен №" size="20" onchange="isValidRegNumber();" maxlength="8">
						</div>
						
						<div class="form-row">
							<div class="form-row-inner">
								<label for="vehicleType">Вид МПС</label>
								<select id="vehicleType" class="field" name="vehicleType" onchange="change();">
								<%
									VehicleTypeDAO vTypes = new VehicleTypeDAOImpl();
									for(VehicleType type : vTypes.listVehicleTypes()) { %>
										<option><%=type.getVehicleType() %></option>
									<%} %>
								</select>
							</div>
							<div class="form-row-inner">
								<label for="ramaN">Рама №</label>
								<input type="text" class="field" name="ramaN" placeholder="Рама №" size="30" maxlength="17">
							</div>
						</div>
						
						<div class="form-row">
							<div class="form-row-inner">
								<label for="vehicleBrand">Марка</label>
								<select id="vehicleBrand" class="field" name="vehicleBrand">
								<%
									VehicleBrandDAO types = new VehicleBrandDAOImpl();
									for(VehicleBrand type : types.listAllVehicleBrand()) { %>
										<option><%=type.getVehicleBrand() %></option>
									<%} %>
								</select>
							</div>
							<div class="form-row-inner">
								<label>Модел</label>
								<input type="text" class="field" name="vehicleModel" placeholder="Модел" size="30" maxlength="50">
							</div>
						</div>
						<div class="form-row">
							<div class="form-row-inner">
								<label>Цвят</label>
								<select id="vehicleColor" class="field" name="vehicleColor">
								<%
									VehicleColorDAO colors = new VehicleColorDAOImpl();
									for(VehicleColor color : colors.listAllVehicleColors()) { %>
									<option><%=color.getVehicleColor() %></option>
								<% } %>
								</select>
							</div>
						</div>
						<div class="form-row">
							<div class="form-row-inner">
								<label>Година на производство</label>
								<select id="year" class="field" name="year"></select>
							</div>
							<div class="form-row-inner">
								<label>Дата на първа регистрация</label>
								<input type="text" class="field" name="vehicleFirstReg" placeholder="Дата на първа регистрация" id="datepicker" size="30">
							</div>
						</div>
						<div class="form-row">
							<div class="form-row-inner">
								<label>Обем на двигателя</label>
								<select id="vehicleEngine" class="field" name="vehicleEngine">
									<option>1.4</option>
									<option>1.6</option>
									<option>1.8</option>
									<option>2.0</option>
								</select>
							</div>
							<div class="form-row-inner">
								<label>Брой места</label>
								<select id="vehiclePlaces" class="field" name="vehiclePlaces">
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>50</option>
								</select>
							</div>
						</div>
						<div class="form-row">
							<label>Застрахоателна сума</label>
							<input type="text" 
								onchange="change();" onkeypress="onchange();" onpaste="this.onchange();" oninput="onchange();"
							class="field" id="vehicleInsValue" name="vehicleInsValue" size="30" value="0">
						</div>
						<div class="form-row">
							<label>Застрахователна премия</label>
							<input type="text" class="field" id="vehicleInsPremiq" name="vehicleInsPremiq" size="30" readonly="readonly">
						</div>
					</div>
					<input type="submit" value="Сключи застраховка">
				</form>
			</div>
		</div>
		
	</body>
</html>