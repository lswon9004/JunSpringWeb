<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	id :${test.id}<br>
	pwd : ${test.pwd}<br>
	name : ${test.name}<br>
	phone ${test.phone}<br>
	pet :
		<c:forEach var="item" items="${test.pet}">
			${item}
		</c:forEach>
	
</body>
</html>