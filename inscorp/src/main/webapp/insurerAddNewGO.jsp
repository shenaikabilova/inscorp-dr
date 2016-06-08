<%@page import="dao_jdbc.VehicleBrandDAOImpl"%>
<%@page import="dao_api.VehicleBrandDAO"%>
<%@page import="model.VehicleBrand"%>
<%@page import="dao_jdbc.VehicleTypeDAOImpl"%>
<%@page import="model.Country"%>
<%@page import="dao_jdbc.CountryDAOImpl"%>
<%@page import="dao_api.CountryDAO"%>
<%@page import="model.InsurerType"%>
<%@page import="dao_jdbc.InsurerTypeDAOImpl"%>
<%@page import="dao_api.InsurerTypeDAO"%>
<%@page import="model.VehicleType"%>
<%@page import="dao_api.VehicleTypeDAO"%>
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
		<script>
			$(function() {
				$( "#datepicker1" ).datepicker({
					dateFormat: "yy-mm-dd",
					onSelect: function(datetext){
						$(this).val(datetext); }
				});
			});
			
			$(function() {
				$( "#datepicker2" ).datepicker({
					dateFormat: "yy-mm-dd",
					onSelect: function(datetext){
						$(this).val(datetext); }
				});
			});
		</script>
		
		<script>
			function change() {
				var arr = [];
				switch(document.getElementById("vehicleType").value) {
				case 'Автомобил':
					if(!arr.length) {
					arr = ["до 1100 куб см", 
					           "от 1101 до 1200 куб см", 
					           "от 1201 до 1400 куб см",
							   "от 1401 до 1600 куб см", 
							   "от 1601 до 1800 куб см", 
							   "от 1801 до 2000 куб см",
							   "от 2001 до 2200 куб см", 
							   "от 2201 до 2500 куб см", 
							   "над  2500 куб см", 
							   "Електромобил"];
					document.getElementById("kubici").innerHTML = "";
					var kubici = document.getElementById('kubici');
					for(var i = 0; i < arr.length; i++) {
						var option = document.createElement('option');
				    	option.text = option.value = arr[i];
				    	kubici.add(option, 0);
					}}
					sum();
				break;
				
				case 'Товарни автомобили':
					if(!arr.length) {
					arr = ["до 0.8 т. включително",
							   "над 0.8 до 1.5 т.",
							   "над 1,5 до 2.5 т.",
							   "над 2,5 до 3.5 т.",
							   "над 3,5 до 5,0 т.",
							   "над 5,0 до 10 т.",
				 			   "над 10  до 20 т.",
							   "над 20 т."];
					document.getElementById("kubici").innerHTML = "";
					var kubici = document.getElementById('kubici');
					for(var i = 0; i < arr.length; i++) {
						var option = document.createElement('option');
				    	option.text = option.value = arr[i];
				    	kubici.add(option, 0);
					}}
					sum();
				break;
				
				case 'Мотоциклет':
					if(!arr.length) {
						arr = ["до 50 куб. см.",
						       "над   50 до 125 куб. см",
						       "над 125 до 250 куб. см",
						       "над 250 до 350 куб. см",
						       "над 350 до 490 куб. см",
						       "над 490 до 750 куб. см",
						       "над 750 куб. см"];
						document.getElementById("kubici").innerHTML = "";
						var kubici = document.getElementById('kubici');
						for(var i = 0; i < arr.length; i++) {
							var option = document.createElement('option');
					    	option.text = option.value = arr[i];
					    	kubici.add(option, 0);
						}}
					sum();
				break;
					
				case 'Автобус':
					if(!arr.length) {
					arr = ["до   20 места включително",
					           "над 20 места до 40 места",
					           "над 40 места"];
					document.getElementById("kubici").innerHTML = "";
					var kubici = document.getElementById('kubici');
					for(var i = 0; i < arr.length; i++) {
						var option = document.createElement('option');
				    	option.text = option.value = arr[i];
				    	kubici.add(option, 0);
					}}
					sum();
				break;
				}
			}
			</script>
			<script>
				function sum() {
					document.getElementById('vehicleInsValue').value="";
					switch (document.getElementById("kubici").value) {
					
					case "до 1100 куб см":
						if(document.getElementById('zone').value === "Зона І - София"){
							document.getElementById('vehicleInsValue').value=162;
						}
						if(document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас") {
							document.getElementById('vehicleInsValue').value=153;
						}
						if(document.getElementById('zone').value === "Зона ІІІ - Други"){
							document.getElementById('vehicleInsValue').value=147;
						}
						break;
					case "от 1101 до 1200 куб см":
						if(document.getElementById('zone').value === "Зона І - София"){
							document.getElementById('vehicleInsValue').value=162;
						}
						if(document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас") {
							document.getElementById('vehicleInsValue').value=153;
						}
						if(document.getElementById('zone').value === "Зона ІІІ - Други"){
							document.getElementById('vehicleInsValue').value=147;
						}
						break;
					case "от 1201 до 1400 куб см":
						if(document.getElementById('zone').value === "Зона І - София"){
							document.getElementById('vehicleInsValue').value=162;
						}
						if(document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас") {
							document.getElementById('vehicleInsValue').value=154;	
						}
						if(document.getElementById('zone').value === "Зона ІІІ - Други"){
							document.getElementById('vehicleInsValue').value=147;
						}
						break;
					case "от 1401 до 1600 куб см": 
						if(document.getElementById('zone').value === "Зона І - София"){
							document.getElementById('vehicleInsValue').value=163;
						}
						if(document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас") {
							document.getElementById('vehicleInsValue').value=155;
						}
						if(document.getElementById('zone').value === "Зона ІІІ - Други"){
							document.getElementById('vehicleInsValue').value=152;
						}
						break;
					case "от 1601 до 1800 куб см": 
						if(document.getElementById('zone').value === "Зона І - София"){
							document.getElementById('vehicleInsValue').value=173;
						}
						if(document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас") {
							document.getElementById('vehicleInsValue').value=163;	
						}
						if(document.getElementById('zone').value === "Зона ІІІ - Други"){
							document.getElementById('vehicleInsValue').value=153;	
						}
						break;
					case "от 1801 до 2000 куб см":
						if(document.getElementById('zone').value === "Зона І - София"){
							document.getElementById('vehicleInsValue').value=181;
						}
						if(document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас") {
							document.getElementById('vehicleInsValue').value=164;
						}
						if(document.getElementById('zone').value === "Зона ІІІ - Други"){
							document.getElementById('vehicleInsValue').value=159;		
						}
						break;
					case "от 2001 до 2200 куб см": 
						if(document.getElementById('zone').value === "Зона І - София"){
							document.getElementById('vehicleInsValue').value=226;
						}
						if(document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас") {
							document.getElementById('vehicleInsValue').value=210;	
						}
						if(document.getElementById('zone').value === "Зона ІІІ - Други"){
							document.getElementById('vehicleInsValue').value=196;
						}
						break;
					case "от 2201 до 2500 куб см": 
						if(document.getElementById('zone').value === "Зона І - София"){
							document.getElementById('vehicleInsValue').value=226;
						}
						if(document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас") {
							document.getElementById('vehicleInsValue').value=210;	
						}
						if(document.getElementById('zone').value === "Зона ІІІ - Други"){
							document.getElementById('vehicleInsValue').value=197;
						}
						break;
					case "над  2500 куб см": 
						if(document.getElementById('zone').value === "Зона І - София"){
							document.getElementById('vehicleInsValue').value=253;
						}
						if(document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас") {
							document.getElementById('vehicleInsValue').value=237;	
						}
						if(document.getElementById('zone').value === "Зона ІІІ - Други"){
							document.getElementById('vehicleInsValue').value=225;
						}
						break;
					case "Електромобил":
						if(document.getElementById('zone').value === "Зона І - София"){
							document.getElementById('vehicleInsValue').value=163;
						}
						if(document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас") {
							document.getElementById('vehicleInsValue').value=155;	
						}
						if(document.getElementById('zone').value === "Зона ІІІ - Други"){
							document.getElementById('vehicleInsValue').value=152;
						}
						break;
						
					case "до 0.8 т. включително":
						if(document.getElementById('zone').value === "Зона І - София"){
							document.getElementById('vehicleInsValue').value=191;
						}
						if(document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас") {
							document.getElementById('vehicleInsValue').value=188;	
						}
						if(document.getElementById('zone').value === "Зона ІІІ - Други"){
							document.getElementById('vehicleInsValue').value=185;
						}
						break;
					case "над 0.8 до 1.5 т.":
						if(document.getElementById('zone').value === "Зона І - София"){
							document.getElementById('vehicleInsValue').value=205;
						}
						if(document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас") {
							document.getElementById('vehicleInsValue').value=200;	
						}
						if(document.getElementById('zone').value === "Зона ІІІ - Други"){
							document.getElementById('vehicleInsValue').value=195;
						}
						break;
					case "над 1,5 до 2.5 т.":
						if(document.getElementById('zone').value === "Зона І - София"){
							document.getElementById('vehicleInsValue').value=205;
						}
						if(document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас") {
							document.getElementById('vehicleInsValue').value=200;	
						}
						if(document.getElementById('zone').value === "Зона ІІІ - Други"){
							document.getElementById('vehicleInsValue').value=195;
						}
						break;
					case "над 2,5 до 3.5 т.":
						if(document.getElementById('zone').value === "Зона І - София"){
							document.getElementById('vehicleInsValue').value=240;
						}
						if(document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас") {
							document.getElementById('vehicleInsValue').value=235;	
						}
						if(document.getElementById('zone').value === "Зона ІІІ - Други"){
							document.getElementById('vehicleInsValue').value=230;
						}
					case "над 3,5 до 5,0 т.":
						if(document.getElementById('zone').value === "Зона І - София"){
							document.getElementById('vehicleInsValue').value=290;
						}
						if(document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас") {
							document.getElementById('vehicleInsValue').value=285;
						}
						if(document.getElementById('zone').value === "Зона ІІІ - Други"){
							document.getElementById('vehicleInsValue').value=280;
						}
						break;
					case "над 5,0 до 10 т.":
						if(document.getElementById('zone').value === "Зона І - София"){
							document.getElementById('vehicleInsValue').value=590;
						}
						if(document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас") {
							document.getElementById('vehicleInsValue').value=585;
						}
						if(document.getElementById('zone').value === "Зона ІІІ - Други"){
							document.getElementById('vehicleInsValue').value=580;
						}
						break;
					case "над 10  до 20 т.":
						if(document.getElementById('zone').value === "Зона І - София"){
							document.getElementById('vehicleInsValue').value=865;
						}
						if(document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас") {
							document.getElementById('vehicleInsValue').value=860;
						}
						if(document.getElementById('zone').value === "Зона ІІІ - Други"){
							document.getElementById('vehicleInsValue').value=855;
						}
						break;
					case "над 20 т.":
						if(document.getElementById('zone').value === "Зона І - София"){
							document.getElementById('vehicleInsValue').value=1045;
						}
						if(document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас") {
							document.getElementById('vehicleInsValue').value=1040;	
						}
						if(document.getElementById('zone').value === "Зона ІІІ - Други"){
							document.getElementById('vehicleInsValue').value=1035;
						}
						break;
						
					case "до 50 куб. см.":
						if(document.getElementById('zone').value === "Зона І - София" || 
							document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас" ||
							document.getElementById('zone').value === "Зона ІІІ - Други"){
							document.getElementById('vehicleInsValue').value=85;
						}
						break;
					case "над   50 до 125 куб. см":
						if(document.getElementById('zone').value === "Зона І - София" ||
						   document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас" ||
						   document.getElementById('zone').value === "Зона ІІІ - Други"){
								document.getElementById('vehicleInsValue').value=85;
						}
						break;
					case "над 125 до 250 куб. см":
						if(document.getElementById('zone').value === "Зона І - София" || 
						   document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас" ||
						   document.getElementById('zone').value === "Зона ІІІ - Други"){
								document.getElementById('vehicleInsValue').value=85;
						}
						break;
					case "над 250 до 350 куб. см":
						if(document.getElementById('zone').value === "Зона І - София" || 
						   document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас" ||
						   document.getElementById('zone').value === "Зона ІІІ - Други"){
								document.getElementById('vehicleInsValue').value=85;
						}
						break;
					case "над 350 до 490 куб. см":
						if(document.getElementById('zone').value === "Зона І - София" || 
					   	   document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас"){
								document.getElementById('vehicleInsValue').value=85;
						}
						break;
						if(document.getElementById('zone').value === "Зона ІІІ - Други"){
							document.getElementById('vehicleInsValue').value=90;
						}
						break;
					case "над 490 до 750 куб. см":
						if(document.getElementById('zone').value === "Зона І - София" || 
					  	   document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас"){
								document.getElementById('vehicleInsValue').value=95;
						}
						break;
						if(document.getElementById('zone').value === "Зона ІІІ - Други"){
							document.getElementById('vehicleInsValue').value=105;
						}
						break;
					case "над 750 куб. см":
						if(document.getElementById('zone').value === "Зона І - София" || 
						   document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас"){
								document.getElementById('vehicleInsValue').value=120;
						}
						break;
						if(document.getElementById('zone').value === "Зона ІІІ - Други"){
							document.getElementById('vehicleInsValue').value=130;
						}
						break;
						
					case "до   20 места включително":
						if(document.getElementById('zone').value === "Зона І - София" || 
						   document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас" ||
						   document.getElementById('zone').value === "Зона ІІІ - Други"){
						 		document.getElementById('vehicleInsValue').value=447;
						}
						break;
					case "над 20 места до 40 места":
						if(document.getElementById('zone').value === "Зона І - София" || 
						   document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас" ||
						   document.getElementById('zone').value === "Зона ІІІ - Други"){
								document.getElementById('vehicleInsValue').value=667;
						}
						break;
					case "над 40 места":
						if(document.getElementById('zone').value === "Зона І - София" || 
						   document.getElementById('zone').value === "Зона IІ - Пловдив, Варна и Бургас" ||
						   document.getElementById('zone').value === "Зона ІІІ - Други"){
								document.getElementById('vehicleInsValue').value=795;
						}
						break;
				}}
			</script>
	</head>
	
	<body>
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
					<li><a href="insurerSettings.jsp">Настройки</a></li>
					<li><a href="/logout">Изход</a>
				</ul>
			</div>
		</div>
		
		<div class="newGO">
			<div class="shell">
				<h3>Сключване на застраховка "Гражданеска отговорност"</h3>
				<form action="addNewGO" method="post">
					<div class="form-section">
						<div class="form-section">
							<h4>Застрахователна полица ГО на МПС</h4>
							<div class="form-row">
								<label>№ на полица</label>
								<input class="field" type="text" name="policaN" >						
							</div>
							<div class="form-row">
									<label>Застраховател</label>
								<input class="field" type="text" value=<%=userName%> name="userName" readonly="readonly">
							</div>
						</div>
						<div class="form-section">
							<h4>Застрахован</h4>
							<div class="form-row">
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
								<input type="text" class="field" name="insuredFirstName" placeholder="Име" size="30">
								<input type="text" class="field" name="insuredSecondName" placeholder="Презиме" size="30">
								<input type="text" class="field" name="insuredLastName" placeholder="Фамилия" size="30">
							</div>
							<div class="form-row">
								<label>ЕГН</label>
								<input type="text" class="field" name="EGN" placeholder="ЕГН">
							</div>
							<div class="form-row">
								<label>Държава</label>
								<select class="field">
								<%
									CountryDAO countries = new CountryDAOImpl();
									for(Country country : countries.listCountries()) { %>
										<option><%=country.getCountry()%></option>
								<%} %>
							</select>
							</div>
							<div class="form-row">
								<div class="form-row-inner">
									<label for="address">Адрес на собственика</label>
									<input type="text" class="field" name="address" placeholder="гр. ж.к. ул. бл. вх. ет. ап." size="50">
								</div>
								<div class="form-row-inner">
									<label for="pKod">Пощенски код</label>
									<input type="text" class="field" name="pKod" placeholder="Пощенски код" size="20">
								</div>
							</div>
							<div class="form-row">
								<label>Мобилен телефон</label>
								<input type="text" class="field" name="mobilePhone" placeholder="Мобилен телефон" size="30">
							</div>
						</div>
					</div>
					<div class="form-action">
						<h4>Данни за МПС</h4>
						<div class="form-row">
								<div class="form-row">
									<label for="registrationNumber">Регистрационен №</label>
									<input type="text" class="field" name="registrationNumber" placeholder="Регистрационен №" size="20">
								
									<label for="zone">Зона</label>
									<select id="zone" class="field" name="zone" onchange="sum();">
										<option>Зона І - София</option>
										<option>Зона IІ - Пловдив, Варна и Бургас</option>
										<option>Зона ІІІ - Други</option>
									</select>
								</div>
						
						<div class="form-row">
							<div class="form-row-inner">
								<label for="vehicleType">Вид МПС</label>
<!-- 								<select id="vehicleType" class="field" name="vehicleType" onchange="change();" ></select> -->
									<select id="vehicleType" class="field" name="vehicleType" onchange="change();">
										<%
											VehicleTypeDAO vTypes = new VehicleTypeDAOImpl();
											for(VehicleType type : vTypes.listVehicleTypes()) { %>
												<option><%=type.getVehicleType() %></option>
											<%} %>
									</select>
							</div>
							<div class="form-row-inner">
								<label for="kubici">Кубици</label>
								<select id="kubici" class="field" name="kubici" onchange="sum();"></select>
							</div>
							<div class="form-row-inner">
								<label for="ramaN">Рама №</label>
								<input type="text" class="field" name="ramaN" placeholder="Рама №" size="30">
							</div>
						</div>
						
						<div class="form-row">
							<div class="form-row-inner">
								<label for="vehicleBrand">Марка</label>
								<select id="vehicleBrand" class="field" name="vehicleBrand">
								<%
							   		VehicleBrandDAO brands = new VehicleBrandDAOImpl();
									for(VehicleBrand brand : brands.listAllVehicleBrand()) { %>
										<option><%=brand.getVehicleBrand() %></option>
									<%} %>
								</select>
							</div>
							<div class="form-row-inner">
								<label>Модел</label>
								<input type="text" class="field" name="vehicleModel" placeholder="Модел" size="30">
							</div>
						</div>
						
						<div class="form-row">
							<label>Дата на сключване</label>
						</div>
						<div class="form-row">
							<div class="form-row-inner">
								<label>Начало</label>
								<input class="field" type="text" placeholder="Начална дата" id="datepicker1" name="fromDate">							
							</div>
							<div class="form-row-inner">
								<label>Край</label>
								<input class="field" type="text" placeholder="Крайна датва" id="datepicker2" name="toDate">							
							</div>
						</div>
<!-- 						<div class="form-row"> -->
<!-- 							<label>Срок</label> -->
<!-- 							<select id="months" class="field" name="months"> -->
<!-- 								<option>3 месеца</option> -->
<!-- 								<option>6 месеца</option> -->
<!-- 								<option>12 месеца</option> -->
<!-- 							</select> -->
<!-- 						</div> -->
					</div>
					
					<div class="form-action">
						<h4>Застрахователна сума</h4>
						<div class="form-row">
							<label>Застрахоателна сума</label>
							<input type="text" 
								class="field" id="vehicleInsValue" name="vehicleInsValue" size="30">
						
						</div>
						<div class="form-row">
							<label>Отстъпки</label>
							<input class="field" type="text" name="insOtstapki">
						</div>
						<div class="form-row">
							<label>Надбавки</label>
							<input class="field" type="text" name="insNadbavki">
						</div>
						<div class="form-row">
							<label>Застрахователна премия</label>
							<input class="field" type="text" name="insPremiq">
						</div>
					</div>
				</div>
				<input type="submit" value="Сключи застраховка">
				</form>
			</div>
		</div>
	</body>
</html>