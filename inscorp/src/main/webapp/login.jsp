<!DOCTYPE html>
<html>
	<head>
		<title>InsuranceCorporation</title>
		<%@ page contentType="text/html; charset=UTF-8" %>
		<link href = "style.css" type="text/css" rel = "stylesheet"/>
	</head>
	
	<body>
		
		<div class="login">
			<div class="shell">
				<form method="post">
				<h3>Вход за потребители</h3>
					<table width="100%">
						<tr>
							<td><label for="userName">Потребителско име </label></td>
							<td><input type="text" class="field" name="userName" placeholder="Потребителско име"><br/></td>
						</tr>
						<tr>
							<td><label for="password">Парола</label></td>
							<td><input type="password" class="field" name="password" placeholder="Парола"><br/></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Вход"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</body>
</html>