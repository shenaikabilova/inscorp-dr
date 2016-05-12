<%@page import="dao_jdbc.VehicleTypeDAOImpl"%>
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
			var vehicleType = ['Автомобил', 'Камион', 'Мотоциклет', 'Автобус'];
		    var selectVehicleType = document.getElementById('vehicleType');
		    for(var i=0; i<vehicleType.length; i++) {
		    	var option = document.createElement('option');
		    	option.text = option.value = vehicleType[i];
		    	selectVehicleType.add(option, 0);
		    }
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
									<li><a href="#">Търсене по текущ застраховател</a></li>
									<li><a href="">Изведи всички</a></li>
								</ul>
							</li>
							<li><a href="#">Каско</a>
								<ul>
									<li><a href="searchGO.jsp">Търсене по №</a></li>
									<li><a href="#">Търсене по текущ застраховател</a></li>
									<li><a href="">Изведи всички</a></li>
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
								<label>Тип на клиента</label>
								<select class="field">
									<option>Физическо лице</option>
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
									<option>България</option>
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
						</div>
						
						<div class="form-row">
							<div class="form-row-inner">
								<label for="vehicleType">Вид МПС</label>
								<select id="vehicleType" class="field" name="vehicleType"></select>
							</div>
							<div class="form-row-inner">
								<label for="ramaN">Рама №</label>
								<input type="text" class="field" name="ramaN" placeholder="Рама №" size="30">
							</div>
						</div>
						
						<div class="form-row">
							<div class="form-row-inner">
								<label for="vehicleBrand">Марка</label>
								<select id="vehicleBrand" class="field">
								<%
							   		VehicleTypeDAO types = new VehicleTypeDAOImpl();
									for(VehicleType type : types.listAllVehicleTypes()) { %>
										<option><%=type.getVehicleType() %></option>
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
						<div class="form-row">
							<label>Срок</label>
							<select class="field">
								<option>3 месеца</option>
								<option>6 месеца</option>
								<option>12 месеца</option>
							</select>
						</div>
					</div>
					
					<div class="form-action">
						<h4>Застрахователна сума</h4>
						<div class="form-row">
							<label>Застрахователна сума</label>
							<input class="field" type="text">
						</div>
						<div class="form-row">
							<label>Отстъпки</label>
							<input class="field" type="text">
						</div>
						<div class="form-row">
							<label>Надбавки</label>
							<input class="field" type="text">
						</div>
						<div class="form-row">
							<label>Застрахователна премия</label>
							<input class="field" type="text">
						</div>
					</div>
				</div>
				<input type="submit" value="Сключи застраховка">
				</form>
			</div>
		</div>
	</body>
</html>