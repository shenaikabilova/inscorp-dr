<!DOCTYPE html>
<html>
	<head>
		<title>InsuranceCorporation</title>
		<%@ page contentType="text/html; charset=UTF-8" %>
		<link href = "style.css" type="text/css" rel = "stylesheet"/>
	</head>
	
	<body>
		<center class="error-msg"><% String message = (String) request.getAttribute("errmsg"); %>
				<%=message %></center>
	</body>
</html>