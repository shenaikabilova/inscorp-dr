<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 

<head>
	<body>
		<c:forEach var="i" items="1,2,3,8">
   			<c:out value="${i}"/>
		</c:forEach>
	</body>
</head>