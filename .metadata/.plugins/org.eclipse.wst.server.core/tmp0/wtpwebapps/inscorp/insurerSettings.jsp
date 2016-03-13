<!DOCTYPE html>
<html>
	<head>
		<%@ page contentType="text/html; charset=UTF-8" %>
		<link href = "style.css" type="text/css" rel = "stylesheet"/>
	</head>
	
	<body>
		<div class="menu">
			<div class="menu">
			<div class="menu-nav">
				<ul>
					<li><a href="insurer.jsp">Нова застраховка</a>
						<ul>
							<li><a href="#">Гражданска отговорност</a></li>
							<li><a href="insurerAddNewKasko.jsp">Каско</a></li>
						</ul>
					</li>
					<li><a href="#">Търсене</a>
						<ul>
							<li><a href="#">Гражданска отговорност</a></li>
							<li><a href="#">Каско</a></li>
						</ul>
					</li>
					<li><a href="insurerSettings.jsp">Настройки</a></li>
					<li><a href="#">Изход</a>
				</ul>
			</div>
		</div>
		</div>
		
		<div class="insurerSettings">
			<div class="shell">
				<form method="post">
					<table width="100%">
						<tr>
							<td></td>
							<td><h3>Настройки</h3></td>
						</tr>
						<tr>
							<td><label>ID</label></td>
							<td><input type="text" class="field" name="insurerID" size="30" readonly="readonly"></td>
						</tr>
						<tr>
							<td><label>Име</label></td>
							<td><input type="text" class="field" name="insurerName" size="30"></td>
						</tr>
						<tr>
							<td><label>Фамилия</label></td>
							<td><input type="text" class="field" name="insurerFamily" size="30"></td>
						</tr>
						<tr>
							<td><label>Е-майл</label></td>
							<td><input type="text" class="field" name="insurerEmail" size="30"></td>
						</tr>
						<tr>
							<td><label>Парола</label></td>
							<td><input type="password" class="field" name="insurerPass1" size="30"></td>
						</tr>
						<tr>
							<td><label>Повторете парола</label></td>
							<td><input type="password" class="field" name="insurerPass2" size="30"></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Промяна"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</body>
</html>