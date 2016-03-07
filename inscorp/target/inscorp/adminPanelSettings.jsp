<!DOCTYPE html>
<html>
	<head>
		<title>InsuranceCorporation</title>
		<%@ page contentType="text/html; charset=UTF-8" %>
		<link href = "style.css" type="text/css" rel = "stylesheet"/>
	</head>
	
	<body>
		<div class="menu">
			<div class="shell">
				<ul class="menu-nav">
					<li><a href="adminPanelAddInsurer.jsp">Добави</a>
						<ul>
							<li><a href="adminPanelAddInsurer.jsp">Застрахователен агент</a></li>
						</ul>
					</li>
					<li><a href="adminPanelSettings.jsp">Настройки</a></li>
					<li><a href="adminPanelInsurers.jsp">Застрахователни агенти</a></li>
					<li><a href="#">Изход</a></li>
				</ul>
			</div>
		</div>
		
		<div class="adminpanelSettings"> 
			<div class="shell">
				<form method="post">
					<table width="100%">
						<tr>
							<td></td>
							<td><h3>Настройки на администратора</h3></td>
						</tr>
						<tr>
							<td><label for="admin">ID</label></td>
							<td><input type="text" class="field" name="insurerID" placeholder="ID" size="30"></td>
						</tr>
						<tr>
							<td><label for="adminName">Име</label></td>
							<td><input type="text" class="field" name="adminName" placeholder="Име" size="30"></td>
						</tr>
						<tr>
							<td><label for="adminEmail">Е-майл</label></td>
							<td><input type="text" class="field" name="adminEmail" placeholder="Е-майл" size="30"></td>
						</tr>
						<tr>
							<td><label for="password1">Парола</label></td>
							<td><input type="password" class="field" name="password1" placeholder="Парола" size="30"></td>
						</tr>
						<tr>
							<td><label for="password2">Повторете парола</label></td>
							<td><input type="password" class="field" name="password2" placeholder="Повторете паролата" size="30"></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Промени"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</body>
</html>